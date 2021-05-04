package com.cg.goa.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.goa.exception.ProductException;
import com.cg.goa.model.ProductModel;
import com.cg.goa.service.IProductService;

@RestController
@RequestMapping(path = "/ProductEntity")
public class ProductApi {

	@Autowired
	private IProductService productservice;
	/*
	 * to retrieve all Products
	 * return : List<Products>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<ProductModel>> findAllProducts() {
		return ResponseEntity.ok(productservice.findAllProducts());
	}
	/*
	 * to retrieve by ProductId
	 * return : Product
	 * params : productId
	 */
	@GetMapping("findByProductId/{id}")
	public ResponseEntity<ProductModel> findByProductId(@PathVariable("id") Long productId) {
		ResponseEntity<ProductModel> response = null;
		ProductModel p = productservice.findByProductId(productId);
		if (p == null) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(p);
		}
		return response;
	}
	/*
	 * to retrieve by Product Category
	 * return : List <product>(category)
	 * params : category
	 */
	@GetMapping("findByProductCategory/{category}")
	public ResponseEntity<List<ProductModel>> findByProductCategory(@PathVariable("category") String productCategory) {
		//ResponseEntity<List<ProductModel>> response = null;
		return ResponseEntity.ok( productservice.findByProductCategory(productCategory));

	}
	/*
	 * to add new product
	 * return : product
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel product) throws ProductException {
		product = productservice.addProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	/*
	 * to update product
	 * return : product
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel product) throws ProductException {
		product = productservice.updateProduct(product);
		return ResponseEntity.ok(product);
	}
	/*
	 * to update Product  Quantity
	 * return : product
	 * params : quantity,productId
	 */
	@PutMapping("updateProductQuantity/{quan},{id}")
	public ResponseEntity<Boolean> updateProductQuantity(@PathVariable("quan") Integer quantity,
			@PathVariable("id") Long s2) {
		Boolean p = productservice.updateProductQuantity(quantity, s2);
		return ResponseEntity.ok(p);
	}
	/*
	 * to delete by product id
	 * return : productId
	 * params : productId
	 */
	@DeleteMapping("deletebyproductid/{productId}")
	public ResponseEntity<Boolean> deleteByProductId(@PathVariable(name="productId") Long id) throws ProductException {
		Boolean result = productservice.deleteByProductId(id);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}
	
	/*
	 * to search product name
	 * return : product name
	 * params : keyword
	 */
	@GetMapping("/{keyword}")
	public ResponseEntity<List<ProductModel>> search(@PathVariable("keyword") String keyword) {
		return ResponseEntity.ok(productservice.search(keyword));

	}
	/*
	 * to filter product by max price
	 * return : maxprice
	 * params : maxprice
	 */
	@GetMapping("filter/{maxprice}")
	public ResponseEntity<List<ProductModel>> filter(@PathVariable("maxprice") BigDecimal maxPrice) {
		return ResponseEntity.ok(productservice.filter(maxPrice));
	}

}