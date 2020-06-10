package com.example.Proveedores_Empresariales.WayToPay;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/waytopay")
@RestController
@CrossOrigin
public class WayToPayRestController {

    private WayToPayService wayToPayService;


    public WayToPayRestController(WayToPayService wayToPayService) {
        this.wayToPayService = wayToPayService;
    }
    @PostMapping
    public ResponseEntity<WayToPay> save(@RequestBody WayToPay wayToPay)
    {
       return ResponseEntity.ok().body(this.wayToPayService.save(wayToPay));
    }

    @GetMapping
    public ResponseEntity <List<WayToPay>> getAll()
    {
        return ResponseEntity.ok().body(this.wayToPayService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<WayToPay>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.wayToPayService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<WayToPay> update(@PathVariable("identificacion")Integer id,@RequestBody WayToPay wayToPay) {

        return new ResponseEntity<>(this.wayToPayService.update(id,wayToPay), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        WayToPay wayToPay= this.wayToPayService.getById(identificacion);
        if ( wayToPay!= null) {
            this.wayToPayService.delete(wayToPay);
        }
    }
}
