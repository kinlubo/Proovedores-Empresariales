package com.example.Proveedores_Empresariales.Product;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryProduct extends JpaRepository<Product,Integer> {
}
