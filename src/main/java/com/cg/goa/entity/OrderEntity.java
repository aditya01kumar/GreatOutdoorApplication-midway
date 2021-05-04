package com.cg.goa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "order_entity")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	@Column(name = "user_id")
	private String userId;

	@OneToMany(cascade= CascadeType.ALL,mappedBy = "order")
	private List<ProductEntity> products = new ArrayList<>();

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	@Column(name = "dispatch_date")
	private LocalDateTime dispatchDate;

	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;
	/*
	 * A default Constructor with no implementation
	 */

	public OrderEntity() {
		// no implementation
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public OrderEntity(Integer orderId, String userId, BigDecimal totalPrice,
			Long totalQuantity, LocalDateTime dispatchDate, LocalDateTime deliveryDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((dispatchDate == null) ? 0 : dispatchDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((totalQuantity == null) ? 0 : totalQuantity.hashCode());
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
		OrderEntity other = (OrderEntity) obj;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (dispatchDate == null) {
			if (other.dispatchDate != null)
				return false;
		} else if (!dispatchDate.equals(other.dispatchDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (totalQuantity == null) {
			if (other.totalQuantity != null)
				return false;
		} else if (!totalQuantity.equals(other.totalQuantity))
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
		return "OrderEntity [orderId=" + orderId + ", userId=" + userId + ", totalPrice=" + totalPrice
				+ ", totalQuantity=" + totalQuantity + ", dispatchDate=" + dispatchDate + ", deliveryDate="
				+ deliveryDate + "]";
	}
}
