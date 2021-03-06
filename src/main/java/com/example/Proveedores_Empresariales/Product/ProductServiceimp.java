package com.example.Proveedores_Empresariales.Product;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimp implements ProductService{

    private RepositoryProduct repositoryProduct;

    public ProductServiceimp(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }


    @Override
    public Product save(Product product) {
        return this.repositoryProduct.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.repositoryProduct.findAll();
    }

    @Override
    public Product getById(int id) {
        return this.repositoryProduct.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }
    @Override
    public Product update(int id,Product product) {

        Product product1 = getById(id);
        product1.setPresentation(product.getPresentation());
        product1.setQuantity(product.getQuantity());
        return this.repositoryProduct.save(product1);
    }

    @Override
    public void delete(Product product) {
        this.repositoryProduct.delete(product);
    }


}
