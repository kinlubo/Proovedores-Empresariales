package com.example.Proveedores_Empresariales.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Service
public interface RepositoryProduct extends JpaRepository<Product,Integer> {

}
