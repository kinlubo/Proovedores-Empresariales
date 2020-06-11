package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterial;
import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterialPK;
import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterialService;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterials;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterialsService;
import com.example.Proveedores_Empresariales.Service.ServiceService;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceServiceimp implements ProductServiceService {

    private RepositoryProductService repositoryProductService;
    private ServiceService repositoryService;
    private com.example.Proveedores_Empresariales.Product.ProductService repositoryProduct;
    private RawMaterialsService rawMaterialsService;
    private ProductService_RawMaterialService productService_rawMaterialService;

    public ProductServiceServiceimp(RepositoryProductService repositoryProductService, ServiceService repositoryService, com.example.Proveedores_Empresariales.Product.ProductService repositoryProduct, RawMaterialsService rawMaterialsService, ProductService_RawMaterialService productService_rawMaterialService) {
        this.repositoryProductService = repositoryProductService;
        this.repositoryService = repositoryService;
        this.repositoryProduct = repositoryProduct;
        this.rawMaterialsService = rawMaterialsService;
        this.productService_rawMaterialService = productService_rawMaterialService;
    }


    @Override
    public ProductService save(ProductService productService) {
            repositoryProduct.save(productService.getProduct());
            repositoryService.save(productService.getService());
        List<RawMaterials> rawMaterials = rawMaterialsService.getAll();
            if(rawMaterialsService.getByName(productService.getName())==null)
            {
                ProductService_RawMaterialPK productService_rawMaterialPK =  new ProductService_RawMaterialPK(productService.getId(),rawMaterialsService.getByName(productService.getName()).getCode());
                ProductService_RawMaterial productService_rawMaterial = new ProductService_RawMaterial(productService_rawMaterialPK);
                productService_rawMaterialService.save(productService_rawMaterial);
            }

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
