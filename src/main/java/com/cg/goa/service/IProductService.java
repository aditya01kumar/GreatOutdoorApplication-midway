package com.cg.goa.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.goa.exception.ProductException;
import com.cg.goa.model.ProductModel;

public interface IProductService {

	List<ProductModel> findAllProducts();

	ProductModel findByProductId(Long id);

	List<ProductModel> findByProductCategory(String productCategory);

	ProductModel addProduct(ProductModel productEntity) throws ProductException;

	ProductModel updateProduct(ProductModel productEntity) throws ProductException;

	boolean updateProductQuantity(Integer quantity,Long productId);

	boolean deleteByProductId(Long id) throws ProductException;

	List<ProductModel> search(String keyword);

	List<ProductModel> filter(BigDecimal maxPrice);

}
