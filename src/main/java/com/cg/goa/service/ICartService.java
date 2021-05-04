package com.cg.goa.service;

import java.util.List;

import com.cg.goa.exception.CartException;
import com.cg.goa.model.CartItemModel;

public interface ICartService {

	List<CartItemModel> findCartlist();
	CartItemModel findCartItem(Long productId, Integer userId);
	CartItemModel addCart(CartItemModel cartItemEntity) throws CartException;

	CartItemModel updateCart(CartItemModel cartItemEntity) throws CartException;

	boolean deleteCartItem(Long cartId,Long productId) throws CartException;

	boolean deleteCartlist(Integer userId) throws CartException;
	//boolean deleteCartItem(Long cartId, ProductModel productId) throws CartException;

}
