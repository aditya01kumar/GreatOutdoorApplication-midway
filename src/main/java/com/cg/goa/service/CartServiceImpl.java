package com.cg.goa.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICartRepository;
import com.cg.goa.exception.CartException;
import com.cg.goa.model.CartItemModel;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartRepository cartrepo;

	@Autowired
	private EMParserCart parser;
	/*
	 * A default Constructor with no implementation
	 */

	public CartServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public CartServiceImpl(ICartRepository cartrepo) {
		super();
		this.cartrepo = cartrepo;
		this.parser = new EMParserCart();
	}

	/*
	 * service implementation for finding  CartList
	 */
	@Transactional
	@Override
	public List<CartItemModel> findCartlist() {
		return cartrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	/*
	 * service implementation for finding  Cart Item
	 */
	@Transactional
	@Override
	public CartItemModel findCartItem(Long productId, Integer userId) {
			CartItemModel p = parser.parse(cartrepo.findAllByProducts(productId));
			return p;
	}
	/*
	 * service implementation for adding cart to CartEntity
	 * @Throws CartException
	 */
	
	@Transactional
	@Override
	public CartItemModel addCart(CartItemModel cartItemEntity) throws CartException {
		if (cartrepo.existsById(cartItemEntity.getCartId())) {
			throw new CartException("It already exists");
		}
		parser.parse(cartrepo.save(parser.parse(cartItemEntity)));
		return cartItemEntity;
	}
	/*
	 * service implementation for Updating Cart 
	 * @Throws CartException
	 */
	
	@Transactional
	@Override
	public CartItemModel updateCart(CartItemModel cartItemEntity) throws CartException {
		if (!cartrepo.existsById(cartItemEntity.getCartId())) {
			throw new CartException("cartId not exist exists");
		}
		parser.parse(cartrepo.save(parser.parse(cartItemEntity)));
		return cartItemEntity;
	}

	/*
	 * service implementation for Deleting Cart Item
	 * @Throws CartException
	 */
	@Transactional
	@Override
	public boolean deleteCartItem(Long cartId, Long productId) throws CartException {
		if (cartId != null || productId != null) {
			if (cartrepo.existsById(cartId)) {
				CartItemModel c = parser.parse(cartrepo.findById(cartId).orElse(null));
				return cartrepo.deleteByproducts(c.getProducts().get(0).getProductId());
			}
		}
		else {
			throw new CartException("product is not found");
		}
		return false;
	}

	/*
	 * service implementation for Delete Cart LIst
	 * @Throws CartException
	 */
	@Transactional
	@Override
	public boolean deleteCartlist(Integer userId) throws CartException {
		if (userId != null) {
			
			cartrepo.deleteByuserId(userId);
			return true;
		}
		return false;
	}

}