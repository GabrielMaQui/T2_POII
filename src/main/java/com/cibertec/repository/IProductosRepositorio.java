package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Productos;

public interface IProductosRepositorio extends JpaRepository<Productos, Integer>{

}
