package com.example.Proveedores_Empresariales.Product;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product save(Product product);

    public List<Product> getAll();

    public Product getById(int id);

    public Product update(Product product);

    public void delete (Product product);
}
