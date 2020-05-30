package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/departament")
@RestController
public class DepartmentRestController {

    private DepartmentService departmentService;
    private CountryService countryService;

    public DepartmentRestController(DepartmentService departmentService, CountryService countryService) {
        this.departmentService = departmentService;
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
    public ResponseEntity<Departament> save(@RequestBody Integer id,String nombre, Integer country)
    {
        Country country1 = countryId(country);
        Departament departament  = new Departament(id,nombre,country1);
        return ResponseEntity.ok().body(this.departmentService.save(departament));
    }

    @GetMapping
    public ResponseEntity <List<Departament>> getAll()
    {
        return ResponseEntity.ok().body(this.departmentService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Departament>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.departmentService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Departament> update(@PathVariable("identificacion")Integer id,String nombre, Integer country) {

        Departament departament= this.departmentService.getById(id);
        if ( departament== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            departament.setName(nombre);
            departament.setContry(countryId(country));

        }
        return new ResponseEntity<>(this.departmentService.update(departament), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        Departament departament= this.departmentService.getById(identificacion);
        if ( departament!= null) {
            this.departmentService.delete(departament);
        }
    }
}
