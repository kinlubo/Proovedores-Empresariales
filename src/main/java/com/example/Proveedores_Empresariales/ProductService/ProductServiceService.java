package com.example.Proveedores_Empresariales.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceService {

    public ProductService save (ProductService productService);

    public List<ProductService> getAll();

    public ProductService getById(int id);

    public ProductService update(ProductService productService);

    public void delete (ProductService productService);
}
