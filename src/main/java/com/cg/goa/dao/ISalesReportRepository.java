package com.cg.goa.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.SalesReportEntity;
@Repository
public interface ISalesReportRepository extends JpaRepository<SalesReportEntity, Long>{
	boolean existsByproductId(String productId);
	SalesReportEntity findAllByproductId(String productId);
	SalesReportEntity findByproductId(String productId);
	
}
