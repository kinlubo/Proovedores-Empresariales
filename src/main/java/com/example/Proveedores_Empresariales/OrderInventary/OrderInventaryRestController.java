package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import com.example.Proveedores_Empresariales.Departament.Departament;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/orderinventory")
@RestController
public class OrderInventaryRestController {

    private OrderInventaryService orderInventaryService;
    private CountryService countryService;

    public OrderInventaryRestController(OrderInventaryService orderInventaryService, CountryService countryService) {
        this.orderInventaryService = orderInventaryService;
        this.countryService = countryService;
    }

    public Country countryId(Integer id)
    {
        Country country = null;
        List<Country> countries = countryService.getAll();
        for (int i = 0; countries.size()>i; i++)
        {
            if(countries.get(i).getId()==id)
            {
                country = countries.get(i);
            }
        }
        return country;
    }

    @PostMapping
    public ResponseEntity<OrderInventory> save(@RequestBody OrderInventory orderInventory )
    {
        return ResponseEntity.ok().body(this.orderInventaryService.save(orderInventory));
    }

    @GetMapping
    public ResponseEntity <List<OrderInventory>> getAll()
    {
        return ResponseEntity.ok().body(this.orderInventaryService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<OrderInventory>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.orderInventaryService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<OrderInventory> update(@PathVariable("identificacion")Integer identification,@RequestBody OrderInventory orderInventory )
    {


        return new ResponseEntity<>(this.orderInventaryService.update(identification,orderInventory), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        OrderInventory orderInventory= this.orderInventaryService.getById(identificacion);
        if ( orderInventory!= null) {
            this.orderInventaryService.delete(orderInventory);
        }
    }
}
