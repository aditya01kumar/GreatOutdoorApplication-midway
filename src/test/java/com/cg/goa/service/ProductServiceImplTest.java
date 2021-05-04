package com.cg.goa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.goa.dao.IProductRepository;
import com.cg.goa.entity.ProductEntity;
import com.cg.goa.exception.ProductException;
import com.cg.goa.model.ProductModel;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	private IProductRepository productrepo;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private ProductServiceImpl psImpl;
	/*
	 * Test Case 1 - to find cart list
	 */
	@Test
	@DisplayName("ProductServiceImpl::findAllProducts should return list of existing product as Product List")
	void testFindAllProducts() {
		BigDecimal cost = new BigDecimal("100.00");
		List<ProductEntity> testdata = Arrays.asList(new ProductEntity[] {
				new ProductEntity(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductEntity(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		
		List<ProductModel> expected = Arrays.asList(new ProductModel[] {
				new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductModel(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		Mockito.when(productrepo.findAll()).thenReturn(testdata);
		List<ProductModel> actual = psImpl.findAllProducts();

		assertEquals(expected, actual);

	}
	/*
	 * Test Case 2 - to Find By Product Id
	 */
	@Test
	@DisplayName("ProductServiceImpl::findByProductId should return list of existing product follwed by product id as Product Model")
	void testFindByProductId() {
		BigDecimal cost = new BigDecimal("100.00");
		ProductEntity testdata = new ProductEntity(1L, "cookies",cost, "cookies", "red", "grocery", 2,
				"Rakesh Kumar", "Sweet");
		ProductModel expected = new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar",
				"Sweet");
		// Mockito.when(productrepo.existsById(testdata.getProductId())).thenReturn(true);
		Mockito.when(productrepo.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));
		ProductModel actual = psImpl.findByProductId(expected.getProductId());
		assertEquals(expected, actual);
	}
	/*
	 * Test Case 3 - to Find By Product Category
	 */
	@Test
	@DisplayName("ProductServiceImpl::FindByProductCategory should return list of existing productCategory as Product Model")
	void testFindByProductCategory() {
		BigDecimal cost = new BigDecimal("100.00");
		List<ProductEntity> testdata = Arrays.asList(new ProductEntity[] {
				new ProductEntity(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductEntity(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });

		List<ProductModel> expected = Arrays.asList(new ProductModel[] {
				new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductModel(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		Mockito.when(productrepo.findByCategory("grocery")).thenReturn(testdata);
		List<ProductModel> actual = psImpl.findByProductCategory("grocery");
		assertEquals(expected, actual);
	}
	/*
	 * Test Case 4 - to Add Product
	 * @throws ProductException
	 */
	@Test
	@DisplayName("ProductServiceImpl::AddProduct should add existing packages as Product Model")
	void testAddProduct() throws ProductException {
		BigDecimal cost = new BigDecimal("100.00");
		ProductEntity testdata = new ProductEntity(1L, "cookies", cost, "cookies", "red", "grocery", 2,
				"Rakesh Kumar", "Sweet");
		ProductModel expected = new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar",
				"Sweet");
		Mockito.when(productrepo.existsById(testdata.getProductId())).thenReturn(false);
		//Mockito.when(productrepo.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));
		Mockito.when(productrepo.save(testdata)).thenReturn(testdata);
		ProductModel actual = psImpl.addProduct(expected);
		assertEquals(expected, actual);
	}
	/*
	 * Test Case 5 - to Update Product
	 *  @throws ProductException
	 */
	@Test
	@DisplayName("ProductServiceImpl::Update Product should update list of existing packages as ProductModel List")
	void testUpdateProduct() throws ProductException {
		BigDecimal cost = new BigDecimal("100.00");
		ProductEntity testdata = new ProductEntity(1L, "cookies",cost, "cookies", "red", "grocery", 2,
				"Rakesh Kumar", "Sweet");
		ProductModel expected = new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar",
				"Sweet");
		Mockito.when(productrepo.existsById(testdata.getProductId())).thenReturn(true);
		//Mockito.when(productrepo.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));
		Mockito.when(productrepo.save(testdata)).thenReturn(testdata);
		ProductModel actual = psImpl.updateProduct(expected);
		assertEquals(expected, actual);
	}
	/*
	 * Test Case 6 - to Update Product Quantity
	 */
	@Test
	@DisplayName("ProductServiceImpl::ProductQuantity should return list of existing packages as ProductModel")
	void testUpdateProductQuantity() {
		BigDecimal cost = new BigDecimal("100.00");
		ProductEntity testdata = new ProductEntity(1L, "cookies",cost, "cookies", "red", "grocery", 2,
				"Rakesh Kumar", "Sweet");
		ProductModel expected = new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar",
				"Sweet");
	 Mockito.when(productrepo.existsById(testdata.getProductId())).thenReturn(true);
		Mockito.when(productrepo.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));
		// Mockito.when(productrepo.save(testdata)).thenReturn(testdata);

		boolean actual = psImpl.updateProductQuantity(expected.getQuantity(), expected.getProductId());
		assertTrue(actual);

	}
	/*
	 * Test Case 7 - to find cart list
	 *  @throws ProductException
	 */
	@Test
	@DisplayName("ProductServiceImpl::DeleteByProductId should return list of existing packages as ProductModel List")
	void testDeleteByProductId() throws ProductException {
		BigDecimal cost = new BigDecimal("100.00");
		ProductEntity testdata = new ProductEntity(1L, "cookies",cost, "cookies", "red", "grocery", 2,
				"Rakesh Kumar", "Sweet");
		ProductModel expected = new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar",
				"Sweet");
		// Mockito.when(productrepo.existsById(testdata.getProductId())).thenReturn(true);
		Mockito.when(productrepo.findById(testdata.getProductId())).thenReturn(Optional.of(testdata));


		boolean actual = psImpl.deleteByProductId(expected.getProductId());
		assertTrue(actual);
	}
	/*
	 * Test Case 8 - to Search by product name
	 */
	@Test
	@DisplayName("ProductServiceImpl::Search should search product list of existing product in Product Model")
	void testSearch() {
		BigDecimal cost = new BigDecimal("100.00");
		List<ProductEntity> testdata = Arrays.asList(new ProductEntity[] {
				new ProductEntity(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductEntity(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		
		List<ProductModel> expected = Arrays.asList(new ProductModel[] {
				new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductModel(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		Mockito.when(productrepo.findByproductName("cookies")).thenReturn(testdata);
		assertEquals(expected, psImpl.search("cookies"));
	}
	/*
	 * Test Case 9 - to Filter
	 */
	@Test
	@DisplayName("ProductServiceImpl::Filter should filter list of specific products in Product Model")
	void testFilter() {
		BigDecimal cost = new BigDecimal("100.00");
		List<ProductEntity> testdata = Arrays.asList(new ProductEntity[] {
				new ProductEntity(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductEntity(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
		List<ProductModel> expected = Arrays.asList(new ProductModel[] {
				new ProductModel(1L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh Kumar", "Sweet"),
				new ProductModel(2L, "cookies", cost, "cookies", "red", "grocery", 2, "Rakesh gupta", "Sweet") });
			
		Mockito.when(productrepo.findByprice(cost)).thenReturn(testdata);
		assertEquals(expected, psImpl.filter(cost));
	}
}