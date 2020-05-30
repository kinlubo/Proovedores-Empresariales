package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService_RawMaterialService {

    public ProductService_RawMaterial save(ProductService_RawMaterial productService_rawMaterial);

    public List<ProductService_RawMaterial> getAll();

    public ProductService_RawMaterial getById(ProductService_RawMaterialPK id);

    public ProductService_RawMaterial update(ProductService_RawMaterial productService_rawMaterial);

    public void delete(ProductService_RawMaterial productService_rawMaterial);
}
