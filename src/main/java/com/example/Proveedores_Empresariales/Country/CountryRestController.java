package com.example.Proveedores_Empresariales.Country;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/Country")
@RestController
public class CountryRestController {

    private CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<Country> save(@RequestBody Integer id,String nombre)
    {
        Country country  = new Country(id,nombre);
        return ResponseEntity.ok().body(this.countryService.save(country));
    }

    @GetMapping
    public ResponseEntity <List<Country>> getAll()
    {
        return ResponseEntity.ok().body(this.countryService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Country>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.countryService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Country> update(@PathVariable("identificacion") Integer id,String nombre) {

        Country country= this.countryService.getById(id);
        if ( country== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {

        }
        return new ResponseEntity<>(this.countryService.update(country), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        Country actividades= this.countryService.getById(identificacion);
        if ( actividades!= null) {
            this.countryService.delete(actividades);
        }
    }
}
