package com.cg.goa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderModel {
	/*
	 * Private Members Validation
	 * */
	
	private Integer orderId;
	
	@NotNull(message="user Id cannot be null")
	@NotBlank(message="user Id cannot be blank")
	private String userId;
	
	@NotNull(message="products cannot be null")
	@NotBlank(message="products cannot be blank")
	private List<ProductModel> products = new ArrayList<>(); // product and quantity
	
	@NotNull(message="totalPrice cannot be null")
	@NotBlank(message="totalPrice cannot be blank")
	@Min(value=0,message=("Total Price cannot be negative"))
	private BigDecimal totalPrice;
	
	@NotNull(message="total Quantity cannot be null")
	@NotBlank(message="total Quantity cannot be blank")
	@Min(value=0,message=("Total Quantity cannot be negative"))
	private Long totalQuantity;
	
	@NotNull(message="dispatch Date cannot be null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dispatchDate;
	
	@NotNull(message="deliveryDate cannot be null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime deliveryDate;
	
	/*
	 * A default Constructor with no implementation
	 */

	public OrderModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public OrderModel(Integer orderId, String userId, BigDecimal totalPrice, Long totalQuantity,
			LocalDateTime dispatchDate, LocalDateTime deliveryDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
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

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(  List<ProductModel> products) {
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

	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
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
		OrderModel other = (OrderModel) obj;
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
	 *toString() method overridden here
	 * 
	 * */
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", userId=" + userId + ", totalPrice=" + totalPrice
				+ ", totalQuantity=" + totalQuantity + ", dispatchDate=" + dispatchDate + ", deliveryDate="
				+ deliveryDate + "]";
	}
		
}
