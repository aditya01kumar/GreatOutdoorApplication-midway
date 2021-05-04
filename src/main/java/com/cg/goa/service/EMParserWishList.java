package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IWishlistRepository;
import com.cg.goa.entity.WishlistItemEntity;
import com.cg.goa.model.WishlistItemModel;

@Service
public class EMParserWishList {

	@Autowired
	private IWishlistRepository wishlistrepo;
	
	public WishlistItemEntity parse(WishlistItemModel source) {
		return source == null ? null
				: new WishlistItemEntity(source.getWishlistId(),
						source.getUserId(),
						source.getProductId()
						);
	}

	public WishlistItemModel parse(WishlistItemEntity source) {
		return source == null ? null
				: new WishlistItemModel(source.getWishlistId(),
						source.getUserId(),
						source.getProductId()
						);
	}

}
