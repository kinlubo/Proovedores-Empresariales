package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public ProductService update(int id,ProductService productService) {
        ProductService productService1 = getById(id);
        productService1.setName(productService.getName());
        productService1.setValue(productService.getValue());
        productService1.setUnitMeasure(productService.getUnitMeasure());
        productService1.setService(productService.getService());
        productService1.setProduct(productService.getProduct());
        productService1.setBranchOfficeCompan(productService.getBranchOfficeCompan());
        return this.repositoryProductService.save(productService1);
    }

    @Override
    public void delete(ProductService productService) {
        this.repositoryProductService.delete(productService);
    }

    @Override
    public List lista_Provedores(String name) {
        return this.repositoryProductService.findFInd(name);
    }
}
