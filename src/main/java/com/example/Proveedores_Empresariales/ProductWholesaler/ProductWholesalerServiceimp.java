package com.example.Proveedores_Empresariales.ProductWholesaler;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductWholesalerServiceimp implements ProductWholesalerService {

    private RepositoryProductWholesaler repositoryProductWholesaler;

    public ProductWholesalerServiceimp(RepositoryProductWholesaler repositoryProductWholesaler) {
        this.repositoryProductWholesaler = repositoryProductWholesaler;
    }


    @Override
    public ProductWholesaler save(ProductWholesaler productWholesaler) {
        return this.repositoryProductWholesaler.save(productWholesaler);
    }

    @Override
    public List<ProductWholesaler> getAll() {
        return this.repositoryProductWholesaler.findAll();
    }

    @Override
    public ProductWholesaler getById(ProductWhoPK productWhoPK) {
        return this.repositoryProductWholesaler.findByIdProducto(productWhoPK);
    }


    @Override
    public ProductWholesaler update(ProductWholesaler productWholesaler) {
        return this.repositoryProductWholesaler.save(productWholesaler);
    }

    @Override
    public void delete(ProductWholesaler productWholesaler) {
        this.repositoryProductWholesaler.delete(productWholesaler);
    }
}
