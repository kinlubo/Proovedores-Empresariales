package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompanService;
import com.example.Proveedores_Empresariales.Product.Product;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWhoPK;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWholesaler;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWholesalerService;
import com.example.Proveedores_Empresariales.Service.Service;
import com.example.Proveedores_Empresariales.Service.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/productservice")
@RestController
@Api(tags = "ProductServices")
public class ProductServiceRestController {

    private ProductServiceService productServiceService;
    private ServiceService serviceService;
    private com.example.Proveedores_Empresariales.Product.ProductService productService;
    private BranchOfficeCompanService branchOfficeCompanService;
    private ProductWholesalerService productWholesalerService ;
    public ProductServiceRestController(ProductServiceService productServiceService, ServiceService serviceService, com.example.Proveedores_Empresariales.Product.ProductService productService, BranchOfficeCompanService branchOfficeCompanService, ProductWholesalerService productWholesalerService) {
        this.productServiceService = productServiceService;
        this.serviceService = serviceService;
        this.productService = productService;
        this.branchOfficeCompanService = branchOfficeCompanService;
        this.productWholesalerService = productWholesalerService;
    }


    public Service serviceId(Integer id)
    {
        Service service = null;
        List<Service> serviceList = serviceService.getAll();
        for (int i = 0; serviceList.size()>i; i++)
        {
            if(serviceList.get(i).getId()==id)
            {
                service = serviceList.get(i);
            }
        }
        return  service;
    }
    public Product productId(Integer id)
    {
        Product product = null;
        List<Product> productList = productService.getAll();
        for (int i = 0; productList.size()>i; i++)
        {
            if(productList.get(i).getId()==id)
            {
                product = productList.get(i);
            }
        }
        return  product;
    }
    public BranchOfficeCompan branchOfficeCompanId(Integer id)
    {
        BranchOfficeCompan branchOfficeCompan = null;
        List<BranchOfficeCompan> branchOfficeCompans = branchOfficeCompanService.getAll();
        for (int i = 0; branchOfficeCompans.size()>i; i++)
        {
            if(branchOfficeCompans.get(i).getNic()==id)
            {
                branchOfficeCompan = branchOfficeCompans.get(i);
            }
        }
        return  branchOfficeCompan;
    }

    @PostMapping
    public ResponseEntity<ProductService> save(@RequestBody ProductService productService)
    {
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
    public ResponseEntity<ProductService> update(@PathVariable("identificacion") Integer id,@RequestBody ProductService productService) {

        return new ResponseEntity<>(this.productServiceService.update(id,productService), HttpStatus.OK);

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
