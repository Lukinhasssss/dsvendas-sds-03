package com.lucasmonteiro.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasmonteiro.dsvendas.dto.SaleDTO;
import com.lucasmonteiro.dsvendas.entities.Sale;
import com.lucasmonteiro.dsvendas.repositories.SaleRepository;
import com.lucasmonteiro.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) // Vai garantir que toda operação com o banco seja resolvida no service
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); // A JPA vai armazenar os vendedores em cache e quando as vendas forem buscadas os vendedores já  estarão em memória
	
		Page<Sale> sales = repository.findAll(pageable);
		return sales.map(sale -> new SaleDTO(sale));
	}

}
