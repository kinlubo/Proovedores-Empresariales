package com.example.Proveedores_Empresariales.Orders;


import com.example.Proveedores_Empresariales.OrderInventary.OrderInventaryService;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/orders")
@RestController
@CrossOrigin
public class OrdersRestController {

    private OrdersService ordersService;
    private OrderInventaryService orderInventaryService;

    public OrdersRestController(OrdersService ordersService, OrderInventaryService orderInventaryService) {
        this.ordersService = ordersService;
        this.orderInventaryService = orderInventaryService;
    }

    public OrderInventory orderInventoryId(Integer id)
    {
        OrderInventory orderInventory = null;
        List<OrderInventory> orderInventories = orderInventaryService.getAll();
        for (int i = 0; orderInventories.size()>i; i++)
        {
            if(orderInventories.get(i).getIdentification()==id)
            {
                orderInventory = orderInventories.get(i);
            }
        }
        return orderInventory;
    }

    @PostMapping
    public ResponseEntity<Orders> save(@RequestBody Orders orders
    )
    {
        return ResponseEntity.ok().body(this.ordersService.save(orders));
    }

    @GetMapping
    public ResponseEntity <List<Orders>> getAll()
    {
        return ResponseEntity.ok().body(this.ordersService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Orders>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.ordersService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Orders> update(@PathVariable("identificacion")Integer code,@RequestBody Orders orders
    ) {


        return new ResponseEntity<>(this.ordersService.update(code,orders), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        Orders orders= this.ordersService.getById(identificacion);
        if ( orders!= null) {
            this.ordersService.delete(orders);
        }
    }
}
