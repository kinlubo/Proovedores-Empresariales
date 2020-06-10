package com.example.Proveedores_Empresariales.OrdersPurchase;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompanService;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventaryService;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import com.example.Proveedores_Empresariales.WayToPay.WayToPay;
import com.example.Proveedores_Empresariales.WayToPay.WayToPayService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/orderspurchase")
@RestController
@CrossOrigin
public class OrdersPurchaseRestController {

    private OrdersPurchaseService ordersPurchaseService;
    private WayToPayService wayToPayService;
    private BranchOfficeCompanService branchOfficeCompanService;
    private OrderInventaryService orderInventaryService;

    public OrdersPurchaseRestController(OrdersPurchaseService ordersPurchaseService, WayToPayService wayToPayService, BranchOfficeCompanService branchOfficeCompanService, OrderInventaryService orderInventaryService) {
        this.ordersPurchaseService = ordersPurchaseService;
        this.wayToPayService = wayToPayService;
        this.branchOfficeCompanService = branchOfficeCompanService;
        this.orderInventaryService = orderInventaryService;
    }

    public OrderInventory  orderInventoryId(Integer id)
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

    public BranchOfficeCompan branchOfficeCompanId(BigInteger id)
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
        return branchOfficeCompan;
    }

    public WayToPay  wayToPayId (Integer id)
    {
        WayToPay wayToPay = null;
        List<WayToPay> wayToPays = wayToPayService.getAll();
        for (int i = 0; wayToPays.size()>i; i++)
        {
            if(wayToPays.get(i).getId()==id)
            {
                wayToPay = wayToPays.get(i);
            }
        }
        return wayToPay;
    }

    @PostMapping
    public ResponseEntity<OrdersPurchase> save(@RequestBody OrdersPurchase ordersPurchase)
    {
        return ResponseEntity.ok().body(this.ordersPurchaseService.save(ordersPurchase));
    }

    @GetMapping
    public ResponseEntity <List<OrdersPurchase>> getAll()
    {
        return ResponseEntity.ok().body(this.ordersPurchaseService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<OrdersPurchase>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.ordersPurchaseService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<OrdersPurchase> update(@PathVariable("identificacion")Integer id,@RequestBody OrdersPurchase ordersPurchase) {


        return new ResponseEntity<>(this.ordersPurchaseService.update(id,ordersPurchase), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        OrdersPurchase ordersPurchase= this.ordersPurchaseService.getById(identificacion);
        if ( ordersPurchase!= null) {
            this.ordersPurchaseService.delete(ordersPurchase);
        }
    }
}
