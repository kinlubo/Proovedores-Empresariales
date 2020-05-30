package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import com.example.Proveedores_Empresariales.ProductService.ProductService;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService_RawMaterialServiceimp implements ProductService_RawMaterialService {

    private RepositoryProductService_RawMaterial repositoryProductService_rawMaterial;

    public ProductService_RawMaterialServiceimp(RepositoryProductService_RawMaterial repositoryProductService_rawMaterial) {
        this.repositoryProductService_rawMaterial = repositoryProductService_rawMaterial;
    }


    @Override
    public ProductService_RawMaterial save(ProductService_RawMaterial productService_rawMaterial) {
        return this.repositoryProductService_rawMaterial.save(productService_rawMaterial);
    }

    @Override
    public List<ProductService_RawMaterial> getAll() {
        return this.repositoryProductService_rawMaterial.findAll();
    }

    @Override
    public ProductService_RawMaterial getById(ProductService_RawMaterialPK id) {
        return this.repositoryProductService_rawMaterial.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public ProductService_RawMaterial update(ProductService_RawMaterial productService_rawMaterial) {
        return this.repositoryProductService_rawMaterial.save(productService_rawMaterial);
    }

    @Override
        public void delete(ProductService_RawMaterial productService_rawMaterial) {
            this.repositoryProductService_rawMaterial.delete(productService_rawMaterial);
        }
}
