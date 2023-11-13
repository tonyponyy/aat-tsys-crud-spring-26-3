package com.crud263.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud263.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto,Integer> {



	
}
