package com.example.Proveedores_Empresariales.DetailOrdersPurchase;

import com.example.Proveedores_Empresariales.OrdersPurchase.OrdersPurchase;
import com.example.Proveedores_Empresariales.OrdersPurchase.OrdersPurchaseService;
import com.example.Proveedores_Empresariales.ProductService.ProductService;
import com.example.Proveedores_Empresariales.ProductService.ProductServiceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/detailorderspurchase")
@RestController
@CrossOrigin
public class DetailOrdersPurchaseRestController {

    private DetailOrdersPurchaseService detailOrdersPurchaseService;
    private ProductServiceService productServiceService;
    private OrdersPurchaseService ordersPurchaseService;

    public DetailOrdersPurchaseRestController(DetailOrdersPurchaseService detailOrdersPurchaseService, ProductServiceService productServiceService, OrdersPurchaseService ordersPurchaseService) {
        this.detailOrdersPurchaseService = detailOrdersPurchaseService;
        this.productServiceService = productServiceService;

        this.ordersPurchaseService = ordersPurchaseService;
    }

    public OrdersPurchase ordersPurchaseId(Integer id)
    {
        OrdersPurchase ordersPurchase = null;
        List<OrdersPurchase> ordersPurchases = ordersPurchaseService.getAll();
        for (int i = 0; ordersPurchases.size()>i; i++)
        {
            if(ordersPurchases.get(i).getId()==id)
            {
                ordersPurchase = ordersPurchases.get(i);
            }
        }
        return ordersPurchase;
    }

    public ProductService productServiceId(Integer id)
    {
        ProductService productService = null;
        List<ProductService> productServices = productServiceService.getAll();
        for (int i = 0; productServices.size()>i; i++)
        {
            if(productServices.get(i).getId()==id)
            {
                productService = productServices.get(i);
            }
        }
        return productService;
    }

    @PostMapping
    public ResponseEntity<DetailOrdersPurchase> save(@RequestBody DetailOrdersPurchase detailOrdersPurchase)
    {
        return ResponseEntity.ok().body(this.detailOrdersPurchaseService.save(detailOrdersPurchase));
    }

    @GetMapping
    public ResponseEntity <List<DetailOrdersPurchase>> getAll()
    {
        return ResponseEntity.ok().body(this.detailOrdersPurchaseService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<DetailOrdersPurchase>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.detailOrdersPurchaseService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<DetailOrdersPurchase> update(@PathVariable("identificacion")Integer idProduct,@RequestBody DetailOrdersPurchase detailOrdersPurchase )
    {
        return new ResponseEntity<>(this.detailOrdersPurchaseService.update(idProduct,detailOrdersPurchase), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        DetailOrdersPurchase detailOrdersPurchase= this.detailOrdersPurchaseService.getById(identificacion);
        if ( detailOrdersPurchase!= null) {
            this.detailOrdersPurchaseService.delete(detailOrdersPurchase);
        }
    }
}
