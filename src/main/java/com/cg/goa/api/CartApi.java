package com.cg.goa.api;

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

import com.cg.goa.exception.CartException;
import com.cg.goa.model.CartItemModel;
import com.cg.goa.service.ICartService;

@RestController
@RequestMapping("/CartItemEntity")
public class CartApi {

	@Autowired
	private ICartService cartservice;
	/*
	 * to retrieve all cartlist
	 * return : List
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<CartItemModel>> findCartlist() {

		return ResponseEntity.ok(cartservice.findCartlist());
	}
	/*
	 * to find Cart Item
	 * return : cart
	 * params : productId ,cartId
	 */
	@GetMapping("/{productId},{cartId}")
	public ResponseEntity<CartItemModel> findCartItem(@PathVariable("productId") Long productId,
			@PathVariable("userId") Integer userId) {
		ResponseEntity<CartItemModel> response = null;
		CartItemModel cart = cartservice.findCartItem(productId, userId);

		if (cart == null) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}
	/*
	 * to add new cart
	 * return : cart
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<CartItemModel> createCart(@RequestBody CartItemModel cart) throws CartException {
		cart = cartservice.addCart(cart);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}

	
	/*
	 * to update cart
	 * return : cart
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<CartItemModel> updateCart(@RequestBody CartItemModel cart) throws CartException {
		cart = cartservice.updateCart(cart);
		// return new ResponseEntity<>(cart, HttpStatus.OK);
		return ResponseEntity.ok(cart);
	}
	/*
	 * to delete  cartItem
	 * return : cart
	 * params : cartId, productId
	 */
	@DeleteMapping("/{cartId},{productId}")
	public ResponseEntity<Boolean> deleteCartItem(@PathVariable("cartId") Long cartId,
			@PathVariable("productId") Long productId) throws CartException {
		ResponseEntity<Boolean> response = null;
		boolean cart = cartservice.deleteCartItem(cartId, productId);
		if (cart == false) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}

	
	/*
	 * to delete cartList
	 * return : cart
	 * params : userId
	 */
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> deleteCartList(@PathVariable("userId") Integer userId) throws CartException {
		Boolean c = cartservice.deleteCartlist(userId);
		return ResponseEntity.ok(c);

	}

}