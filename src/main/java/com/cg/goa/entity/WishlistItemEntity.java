package com.cg.goa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "wishlist_item_entity")
public class WishlistItemEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "wishlist_id")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long wishlistId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "product_id")
	private String productId;

	/*
	 * A default Constructor with no implementation
	 */
	public WishlistItemEntity() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public WishlistItemEntity(long wishlistId, String userId, String productId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return String.format("WishlistItemEntity [wishlistId=%s, userId=%s, productId=%s]", wishlistId, userId,
				productId);
	}

}
