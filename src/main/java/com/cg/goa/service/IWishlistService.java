package com.cg.goa.service;

import java.util.List;
import com.cg.goa.exception.WishlistException;
import com.cg.goa.model.WishlistItemModel;

public interface IWishlistService {

	List<WishlistItemModel> findAllItems();

	List<WishlistItemModel> findWishlist(String userId);

	List<WishlistItemModel> findWishlistItem(String productId, String userId) throws WishlistException;
	boolean addProductToWishlist(String productId,Long wishlistID);
	boolean deleteWishlistItem(String productId, String userId) throws WishlistException;

	boolean deleteWishlist(String userId) throws WishlistException;

	WishlistItemModel addWishlistItem(WishlistItemModel wishlistItem) throws WishlistException;


}
