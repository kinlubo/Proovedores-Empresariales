package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
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


    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public ResponseEntity<Departament> save(@RequestBody Departament departament)
    {
        return ResponseEntity.ok().body(departmentService.save(departament));
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
    public ResponseEntity<Departament> update(@PathVariable("identificacion")Integer id,@RequestBody Departament departament) {

        return new ResponseEntity<>(this.departmentService.update(id,departament), HttpStatus.OK);
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

    @GetMapping(path = "/esp/{name}")
    public ResponseEntity<Departament> getByFirstName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(departmentService.getByName(name));
    }
}
