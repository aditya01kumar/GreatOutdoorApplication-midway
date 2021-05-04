package com.cg.goa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "sales_report_entity")
public class SalesReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "sales_report_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salesReportId;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity_sold")
	private Integer quantitySold;

	@Column(name = "total_sale")
	private BigDecimal totalSale;
	/*
	 * A default Constructor with no implementation
	 */

	public SalesReportEntity() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public SalesReportEntity(long salesReportId, String productId, String productName, Integer quantitySold,
			BigDecimal totalSale) {
		super();
		this.salesReportId = salesReportId;
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public long getSalesReportId() {
		return salesReportId;
	}

	public void setSalesReportId(long salesReportId) {
		this.salesReportId = salesReportId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	public BigDecimal getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}

	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return String.format(
				"SalesReportEntity [salesReportId=%s, productId=%s, productName=%s, quantitySold=%s, totalSale=%s]",
				salesReportId, productId, productName, quantitySold, totalSale);
	}

}
