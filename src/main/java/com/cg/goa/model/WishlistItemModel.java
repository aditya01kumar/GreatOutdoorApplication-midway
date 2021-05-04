package com.cg.goa.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WishlistItemModel {
	/*
	 * Private Members Validation
	 * */
	@NotNull(message = "wishlist Id cannot be null")
	@NotBlank(message = "wishlist Id cannot be blank")
	private long wishlistId;

	@NotNull(message = "user Id cannot be null")
	@NotBlank(message = "user Id cannot be blank")
	private String userId;

	@NotNull(message = "Product Id cannot be null")
	@NotBlank(message = "Product Id cannot be blank")
	private String productId;
	/*
	 * A default Constructor with no implementation
	 */

	public WishlistItemModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public WishlistItemModel(
			@NotNull(message = "wishlist Id cannot be null") @NotBlank(message = "wishlist Id cannot be blank") long wishlistId,
			@NotNull(message = "user Id cannot be null") @NotBlank(message = "user Id cannot be blank") String userId,
			@NotNull(message = "Product Id cannot be null") @NotBlank(message = "Product Id cannot be blank") String productId) {
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
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + (int) (wishlistId ^ (wishlistId >>> 32));
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
		WishlistItemModel other = (WishlistItemModel) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (wishlistId != other.wishlistId)
			return false;
		return true;
	}
	
	/* 
	 *toString() method overridden here
	 * 
	 * */	
	
	@Override
	public String toString() {
		return String.format("WishlistItemModel [wishlistId=%s, userId=%s, productId=%s]", wishlistId, userId,
				productId);
	}

	
	
	
}
