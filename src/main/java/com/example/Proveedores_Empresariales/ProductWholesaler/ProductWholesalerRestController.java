package com.example.Proveedores_Empresariales.ProductWholesaler;

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
public class ProductWholesalerRestController {

    private ProductWholesalerService productWholesalerService;

    public ProductWholesalerRestController(ProductWholesalerService productWholesalerService) {
        this.productWholesalerService = productWholesalerService;
    }

    @PostMapping
    public ResponseEntity<ProductWholesaler> save(@RequestBody ProductWholesalerPK productWholesalerPK, int quantityFinal,int value)
    {
        ProductWholesaler productWholesaler  = new ProductWholesaler();
        return ResponseEntity.ok().body(this.productWholesalerService.save(productWholesaler));
    }

    @GetMapping
    public ResponseEntity <List<ProductWholesaler>> getAll()
    {
        return ResponseEntity.ok().body(this.productWholesalerService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<ProductWholesaler>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.productWholesalerService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<ProductWholesaler> update(@PathVariable("identificacion") int identificacion) {

        ProductWholesaler productWholesaler= this.productWholesalerService.getById(identificacion);
        if ( productWholesaler== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {

        }
        return new ResponseEntity<>(this.productWholesalerService.update(productWholesaler), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion")int identificacion) {

        ProductWholesaler productWholesaler= this.productWholesalerService.getById(identificacion);
        if ( productWholesaler!= null) {
            this.productWholesalerService.delete(productWholesaler);
        }
    }
}
