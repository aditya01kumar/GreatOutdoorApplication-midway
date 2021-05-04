package com.cg.goa.entity;

import java.io.Serializable;
//import java.util.Map;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "cart_item_entity")
public class CartItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;

	@Column(name = "user_id")
	private Integer userId;

	@OneToMany(cascade= CascadeType.ALL,mappedBy = "cart")
//	@JoinColumn(name="product_id")
	private List<ProductEntity> products = new ArrayList<>();

	@Column(name = "cart_total_price")
	private BigDecimal cartTotalPrice;

	@Column(name = "total_quantity")
	private long totalQuantity;

	/*
	 * A default Constructor with no implementation
	 */

	public CartItemEntity() {
		// no implementation
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public CartItemEntity(long cartId, Integer userId, BigDecimal cartTotalPrice, long totalQuantity) {
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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		result = prime * result + ((cartTotalPrice == null) ? 0 : cartTotalPrice.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId != other.cartId)
			return false;
		if (cartTotalPrice == null) {
			if (other.cartTotalPrice != null)
				return false;
		} else if (!cartTotalPrice.equals(other.cartTotalPrice))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
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

	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return "CartItemEntity [cartId=" + cartId + ", userId=" + userId + ", cartTotalPrice=" + cartTotalPrice
				+ ", totalQuantity=" + totalQuantity + "]";
	}

}
