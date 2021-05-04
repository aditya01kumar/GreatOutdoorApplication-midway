package com.cg.goa.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartItemModel {

	/*
	 * Private Members Validation
	 */
	@NotNull(message = "cart Id cannot be null")
	private long cartId;

	@NotNull(message = "user Id cannot be null")
	private Integer userId;

	@NotNull(message = "products cannot be null")
	@NotBlank(message = "products cannot be blank")
	private List<ProductModel> products =  new ArrayList<>();// product 

	@NotNull(message = "cartTotalPrice cannot be null")
	@Min(value = 0, message = ("Cart Total Price cannot be negative"))
	private BigDecimal cartTotalPrice;

	@NotNull(message = "totalQuantity cannot be null")
	@Min(value = 0, message = ("Total Quantity cannot be negative"))
	private long totalQuantity;

	/*
	 * A default Constructor with no implementation
	 */

	public CartItemModel() {
		// no implementation
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public CartItemModel(long cartId, Integer userId, BigDecimal cartTotalPrice, long totalQuantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public BigDecimal getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(BigDecimal cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	/*
	 * Corresponding HashCode and Equals methods
	 * 
	 */

	
	
	
	
	
	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return "CartItemModel [cartId=" + cartId + ", userId=" + userId + ", cartTotalPrice=" + cartTotalPrice
				+ ", totalQuantity=" + totalQuantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		result = prime * result + ((cartTotalPrice == null) ? 0 : cartTotalPrice.hashCode());
		result = prime * result + (int) (totalQuantity ^ (totalQuantity >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemModel other = (CartItemModel) obj;
		if (cartId != other.cartId)
			return false;
		if (cartTotalPrice == null) {
			if (other.cartTotalPrice != null)
				return false;
		} else if (!cartTotalPrice.equals(other.cartTotalPrice))
			return false;
		if (totalQuantity != other.totalQuantity)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	

	

}
