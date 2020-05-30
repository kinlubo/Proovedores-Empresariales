package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductServiceServiceimp implements ProductServiceService {

    private RepositoryProductService repositoryProductService;

    public ProductServiceServiceimp(RepositoryProductService repositoryProductService) {
        this.repositoryProductService = repositoryProductService;
    }


    @Override
    public ProductService save(ProductService productService) {
        return this.repositoryProductService.save(productService);
    }

    @Override
    public List<ProductService> getAll() {
        return this.repositoryProductService.findAll();
    }

    @Override
    public ProductService getById(int id) {
        return this.repositoryProductService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public ProductService update(ProductService productService) {
        return this.repositoryProductService.save(productService);
    }

    @Override
    public void delete(ProductService productService) {
        this.repositoryProductService.delete(productService);
    }
}
