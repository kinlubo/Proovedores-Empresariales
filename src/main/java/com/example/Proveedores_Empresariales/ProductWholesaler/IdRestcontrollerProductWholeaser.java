package com.example.Proveedores_Empresariales.ProductWholesaler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/ProductWholesalerId")
@RestController
public class IdRestcontrollerProductWholeaser {

    private ProductWholesalerService productWholesalerService;
    private RepositoryProductWholesaler repositoryProductWholesaler;


    public IdRestcontrollerProductWholeaser(ProductWholesalerService productWholesalerService, RepositoryProductWholesaler repositoryProductWholesaler) {
        this.productWholesalerService = productWholesalerService;
        this.repositoryProductWholesaler = repositoryProductWholesaler;
    }


    @GetMapping
    public ResponseEntity<ProductWholesaler> getById(int code, int quantityinitial) {
        ProductWhoPK productWhoPK = new ProductWhoPK(code,quantityinitial);
        return  ResponseEntity.ok().body(this.productWholesalerService.getById(productWhoPK));
    }
}
