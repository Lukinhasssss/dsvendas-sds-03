package com.lucasmonteiro.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmonteiro.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
