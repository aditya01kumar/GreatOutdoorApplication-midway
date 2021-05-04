package com.cg.goa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.CartItemEntity;

@Repository
public interface ICartRepository extends JpaRepository<CartItemEntity, Long> {
	boolean deleteByUserId(String userId);

	CartItemEntity findAllByProducts(Long productId);

	boolean deleteByproducts(Long productId);

	
	CartItemEntity findByuserId(Integer userId);

	List<CartItemEntity> findAllByuserId(Integer userId);

	void deleteByuserId(Integer userId);

	//List<CartItemEntity> findCartlist(Integer userId);

}
