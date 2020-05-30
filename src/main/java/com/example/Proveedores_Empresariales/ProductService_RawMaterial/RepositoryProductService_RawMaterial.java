package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProductService_RawMaterial extends JpaRepository<ProductService_RawMaterial,ProductService_RawMaterialPK> {
}
