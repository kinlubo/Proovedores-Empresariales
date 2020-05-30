package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.Product.Product;
import com.example.Proveedores_Empresariales.ProductService.ProductService;
import com.example.Proveedores_Empresariales.ProductService.ProductServiceService;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWholesaler;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterials;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterialsService;
import com.example.Proveedores_Empresariales.Service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/productservicerawmaterial")
@RestController
@Api(tags = "ProductServices-RawMaterial")
public class ProductService_RawMaterialRestController {

    private ProductService_RawMaterialService productService_rawMaterialService;


    public ProductService_RawMaterialRestController(ProductService_RawMaterialService productService_rawMaterialService, ProductServiceService productServiceService,  RawMaterialsService rawMaterialsService) {
        this.productService_rawMaterialService = productService_rawMaterialService;
       // this.productServiceService = productServiceService;
        //this.rawMaterialsService = rawMaterialsService;

    }
    @PostMapping
    @ApiOperation(value = "Crear nuevo producto o servicio", notes = "Crea nuevo producto o servicio de proveedor")
    @ApiResponses(value={@ApiResponse(code = 201, message = "Creado Correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida")})
    public ResponseEntity<ProductService_RawMaterial> save(@RequestBody Integer productoservicioId , Integer rawMaterial)
    {
      ProductService_RawMaterialPK productService_rawMaterialPK = new ProductService_RawMaterialPK(productoservicioId,rawMaterial);
      ProductService_RawMaterial productService_rawMaterial = new ProductService_RawMaterial(productService_rawMaterialPK);
      return ResponseEntity.ok().body(this.productService_rawMaterialService.save(productService_rawMaterial));
    }

    @GetMapping
    public ResponseEntity <List<ProductService_RawMaterial>> getAll()
    {
        return ResponseEntity.ok().body(this.productService_rawMaterialService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<ProductService_RawMaterial>getById(@PathVariable("id") int idProductoServicio, int rawMaterialId)
    {
        ProductService_RawMaterialPK productService_rawMaterialPK = new ProductService_RawMaterialPK(idProductoServicio,rawMaterialId);
        return ResponseEntity.ok().body(this.productService_rawMaterialService.getById(productService_rawMaterialPK));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<ProductService_RawMaterial> update(@PathVariable("identificacion") Integer productoservicioId , Integer rawMaterial) {
        ProductService_RawMaterialPK productService_rawMaterialPK = new ProductService_RawMaterialPK(productoservicioId,rawMaterial);
        ProductService_RawMaterial productService= this.productService_rawMaterialService.getById(productService_rawMaterialPK);
        if ( productService== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {

        }
        return new ResponseEntity<>(this.productService_rawMaterialService.update(productService), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") Integer productoservicioId , Integer rawMaterial) {
        ProductService_RawMaterialPK productService_rawMaterialPK = new ProductService_RawMaterialPK(productoservicioId,rawMaterial);
        ProductService_RawMaterial productService= this.productService_rawMaterialService.getById(productService_rawMaterialPK);
        if ( productService!= null) {
            this.productService_rawMaterialService.delete(productService);
        }
    }
}
