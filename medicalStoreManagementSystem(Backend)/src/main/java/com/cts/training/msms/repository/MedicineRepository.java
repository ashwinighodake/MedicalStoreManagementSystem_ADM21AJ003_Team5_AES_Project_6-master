package com.cts.training.msms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.training.msms.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Medicine findByCategory(String category);

	Medicine findByName(String name);
	
	Medicine findByIdAndQuantity(Long id, String quantity);
	
	@Query(value = "from Medicine where quantity < 25")
	List<Medicine> findOrderTobePlaced();
	
	@Transactional
	@Modifying
	@Query(value= "update medicine set quantity = (quantity - :quantity) where quantity>= :quantity and medicine_id= :id",nativeQuery = true)
	void getQuantityAfterOrder(@Param("id") Long id, @Param("quantity") Integer quantity);

}
