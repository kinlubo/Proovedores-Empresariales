package com.example.Proveedores_Empresariales.ProductService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProductService extends JpaRepository<ProductService,Integer> {
}
