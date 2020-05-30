package com.example.Proveedores_Empresariales.ProductService;

import java.util.List;

@org.springframework.stereotype.Service
public interface ProductServiceService {

    public ProductService save (ProductService productService);

    public List<ProductService> getAll();

    public ProductService getById(int id);

    public ProductService update(ProductService productService);

    public void delete (ProductService productService);
}
