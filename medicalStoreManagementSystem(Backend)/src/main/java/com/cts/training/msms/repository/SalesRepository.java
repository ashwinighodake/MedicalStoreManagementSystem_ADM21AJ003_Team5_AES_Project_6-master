package com.cts.training.msms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.training.msms.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	@Query(value = "from Sales where date = :date")
	List<Sales> getDailySales(@Param("date") String date);

}
