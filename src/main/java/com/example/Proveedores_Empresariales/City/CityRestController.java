package com.example.Proveedores_Empresariales.City;


import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/city")
@RestController
@CrossOrigin
public class CityRestController {

    private CityService cityService;
    private DepartmentService departmentService;

    public CityRestController(CityService cityService, DepartmentService departmentService) {
        this.cityService = cityService;

        this.departmentService = departmentService;
    }

    public Departament departamentId(Integer id)
    {
        Departament departament = null;
        List<Departament> departaments = departmentService.getAll();
        for (int i = 0; departaments.size()>i; i++)
        {
            if(departaments.get(i).getId()==id)
            {
                 departament = departaments.get(i);
            }
        }
        return  departament;
    }

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city)
    {
        //Departament departament= departamentId(departmentid);
        return ResponseEntity.ok().body(this.cityService.save(city));
    }

    @GetMapping
    public ResponseEntity <List<City>> getAll()
    {
        return ResponseEntity.ok().body(this.cityService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<City>getById(@PathVariable("id") CityPK id)
    {
        return ResponseEntity.ok().body(this.cityService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<City> update(@PathVariable("identificacion") CityPK id,@RequestBody City city) {


        return new ResponseEntity<>(this.cityService.update(id,city),HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") CityPK identificacion) {

        City city= this.cityService.getById(identificacion);
        if ( city!= null) {
            this.cityService.delete(city);
        }
    }

    @GetMapping(path = "/esp/{name}")
    public ResponseEntity<City> getByFirstName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(cityService.getByName(name));
    }
}
