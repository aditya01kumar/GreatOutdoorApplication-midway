package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ISalesReportRepository;
import com.cg.goa.entity.SalesReportEntity;
import com.cg.goa.model.SalesReportModel;

@Service
public class EMParserSalesReport {

	@Autowired
	private ISalesReportRepository salesrepo;
	
	
	public SalesReportEntity parse(SalesReportModel source) {
		return source == null ? null
				: new SalesReportEntity(source.getSalesReportId(),
						source.getProductId(),
						source.getProductName(),
						source.getQuantitySold(), 
						source.getTotalSale()
						);
	}

	public SalesReportModel parse(SalesReportEntity source) {
		return source == null ? null
				: new SalesReportModel(source.getSalesReportId(), 
						source.getProductId(),
						source.getProductName(),
						source.getQuantitySold(), 
						source.getTotalSale()
						);
	}
}
