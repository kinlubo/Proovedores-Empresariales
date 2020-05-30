package com.example.Proveedores_Empresariales.Product;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/Product")
@RestController
public class ProductRestController {

    private ProductService productservice;

    public ProductRestController(ProductService productservice) {
        this.productservice = productservice;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Integer id, String presentation, Integer quantity)
    {
        Product product = new Product(id,presentation,quantity);
                return ResponseEntity.ok().body(this.productservice.save(product));
    }

    @GetMapping
    public ResponseEntity <List<Product>> getAll()
    {
        return ResponseEntity.ok().body(this.productservice.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Product>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.productservice.getById(id));
    }

    @PutMapping("/{identificacion}")
            @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
            @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Product> update(@PathVariable("identificacion") Integer id, String presentation, Integer quantity) {

        Product product= this.productservice.getById(id);
        if ( product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            product.setId(id);
            product.setPresentation(presentation);
            product.setQuantity(quantity);
        }
        return new ResponseEntity<Product>(this.productservice.update(product),HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        Product product= this.productservice.getById(identificacion);
        if ( product!= null) {
            this.productservice.delete(product);
        }
    }
}
