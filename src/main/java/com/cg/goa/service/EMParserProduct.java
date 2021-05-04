package com.cg.goa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IProductRepository;
import com.cg.goa.entity.ProductEntity;
import com.cg.goa.model.ProductModel;

@Service
public class EMParserProduct {

	@Autowired
	private IProductRepository productrepo;

	public static  ProductEntity parse(ProductModel source) {
		return source == null ? null
				: new ProductEntity(source.getProductId(), source.getProductName(), source.getPrice(),
						source.getImage(), source.getColor(), source.getCategory(), source.getQuantity(),
						source.getManufacturer(), source.getSpecification());
	}

	public static ProductModel parse(ProductEntity source) {
		return source == null ? null
				: new ProductModel(source.getProductId(), source.getProductName(), source.getPrice(), source.getImage(),
						source.getColor(), source.getCategory(), source.getQuantity(), source.getManufacturer(),
						source.getSpecification());
	}

	public static List<ProductEntity> parse2(List<ProductModel> products) {
		List<ProductEntity> products1 = new ArrayList<>();
		for (ProductModel model : products) {
			products1.add(parse(model));
		}
		return products1;
	}

	public static List<ProductModel> parse1(List<ProductEntity> products) {
		List<ProductModel> products1 = new ArrayList<>();
		for (ProductEntity model : products) {
			products1.add(parse(model));
		}
		return products1;
	}

}
