package com.example.Proveedores_Empresariales.ProductWholesaler;

import com.example.Proveedores_Empresariales.Product.Product;
import com.example.Proveedores_Empresariales.ProductService.ProductService;
import com.example.Proveedores_Empresariales.ProductService.ProductServiceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/ProductWholesaler")
@RestController
public class ProductWholesalerRestController {

    private ProductWholesalerService productWholesalerService;
    private ProductServiceService productServiceService;

    public ProductWholesalerRestController(ProductWholesalerService productWholesalerService, RepositoryProductWholesaler repositoryProductWholesaler, ProductServiceService productServiceService) {
        this.productWholesalerService = productWholesalerService;
        this.productServiceService = productServiceService;
    }
    public ProductService productService(Integer id)
    {
        ProductService productService = null;
        List<ProductService>productServices=productServiceService.getAll();
        for(int i = 0 ;productServices.size()>i; i++)
        {
            if(productServices.get(i).getId()==id)
            {
                productService = productServices.get(i);
            }
        }
        return productService;
    }

    @PostMapping
    public ResponseEntity<ProductWholesaler> save(@RequestBody ProductWholesaler productWholesaler)
    {
        return ResponseEntity.ok().body(this.productWholesalerService.save(productWholesaler));
    }


    @GetMapping()
    public ResponseEntity <List<ProductWholesaler>> getAll()
    {
        return ResponseEntity.ok().body(this.productWholesalerService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductWholesaler> getById(@PathVariable("id") int code, int quantityinitial) {
        ProductWhoPK productWhoPK = new ProductWhoPK(code,quantityinitial);
        return  ResponseEntity.ok().body(this.productWholesalerService.getById(productWhoPK));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<ProductWholesaler> update(@PathVariable("identificacion") ProductWhoPK productWhoPK,@RequestBody ProductWholesaler productWholesaler) {

        return new ResponseEntity<>(this.productWholesalerService.update(productWhoPK,productWholesaler), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion")int code, int quentityInitial) {
        ProductWhoPK productWhoPK = new ProductWhoPK(code,quentityInitial);
        ProductWholesaler productWholesaler= this.productWholesalerService.getById(productWhoPK);
        if ( productWholesaler!= null) {
            this.productWholesalerService.delete(productWholesaler);
        }
    }

}
