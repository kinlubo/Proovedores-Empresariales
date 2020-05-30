package com.example.Proveedores_Empresariales.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/ProductWholesaler")
@RestController
public class ProductServiceRestController {

    private ProductServiceService productServiceService;

    public ProductServiceRestController(ProductServiceService productServiceService ) {
        this.productServiceService = productServiceService;
    }

    @PostMapping
    public ResponseEntity<ProductService> save(@RequestBody Integer id,int code,String name,int value,int unitMeasure)
    {
        ProductService productService  = new ProductService();
        return ResponseEntity.ok().body(this.productServiceService.save(productService));
    }

    @GetMapping
    public ResponseEntity <List<ProductService>> getAll()
    {
        return ResponseEntity.ok().body(this.productServiceService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<ProductService>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.productServiceService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<ProductService> update(@PathVariable("identificacion") Integer id,int code,String name,int value,int unitMeasure) {

        ProductService productService= this.productServiceService.getById(id);
        if ( productService== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {

        }
        return new ResponseEntity<>(this.productServiceService.update(productService), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        ProductService productService= this.productServiceService.getById(identificacion);
        if ( productService!= null) {
            this.productServiceService.delete(productService);
        }
    }
}
