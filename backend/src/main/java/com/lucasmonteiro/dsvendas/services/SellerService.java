package com.lucasmonteiro.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmonteiro.dsvendas.dto.SellerDTO;
import com.lucasmonteiro.dsvendas.entities.Seller;
import com.lucasmonteiro.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> sellers = repository.findAll();
		return sellers.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
	}

}
