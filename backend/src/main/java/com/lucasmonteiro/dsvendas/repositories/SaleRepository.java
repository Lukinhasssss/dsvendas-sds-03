package com.lucasmonteiro.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucasmonteiro.dsvendas.dto.SaleSuccessDTO;
import com.lucasmonteiro.dsvendas.dto.SaleSumDTO;
import com.lucasmonteiro.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.lucasmonteiro.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.lucasmonteiro.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
