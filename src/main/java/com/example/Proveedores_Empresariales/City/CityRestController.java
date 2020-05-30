package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Country.Country;
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
    public ResponseEntity<City> save(@RequestBody Integer id,int code,String nombre, Integer departmentid)
    {
        Departament departament= departamentId(departmentid);
        City city = new City(id,code,nombre,departament);
        return ResponseEntity.ok().body(this.cityService.save(city));
    }

    @GetMapping
    public ResponseEntity <List<City>> getAll()
    {
        return ResponseEntity.ok().body(this.cityService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<City>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.cityService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<City> update(@PathVariable("identificacion") Integer id,int code,String nombre, Integer departmentid) {

        City city= this.cityService.getById(id);
        if ( city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            city.setCode(code);
            city.setName(nombre);
            //city.setDepartament(departmentid);
        }
        return new ResponseEntity<>(this.cityService.update(city),HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        City city= this.cityService.getById(identificacion);
        if ( city!= null) {
            this.cityService.delete(city);
        }
    }

}
