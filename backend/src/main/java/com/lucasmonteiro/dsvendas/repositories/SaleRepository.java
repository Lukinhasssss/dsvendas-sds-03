package com.lucasmonteiro.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmonteiro.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
