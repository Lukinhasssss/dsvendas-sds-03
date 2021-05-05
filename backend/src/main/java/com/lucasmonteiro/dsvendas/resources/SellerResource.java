package com.lucasmonteiro.dsvendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmonteiro.dsvendas.dto.SellerDTO;
import com.lucasmonteiro.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResource {
	
	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> sellers = service.findAll();
		return ResponseEntity.ok(sellers);
	}

}
