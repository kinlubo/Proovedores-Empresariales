package com.example.Proveedores_Empresariales.Service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/Service")
@RestController
@CrossOrigin
public class ServiceRestController {

    private ServiceService serviceService;

    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<Service> save(@RequestBody Service service)
    {
        return ResponseEntity.ok().body(this.serviceService.save(service));
    }

    @GetMapping
    public ResponseEntity <List<Service>> getAll()
    {
        return ResponseEntity.ok().body(this.serviceService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Service>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.serviceService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Service> update(@PathVariable("identificacion") Integer id,@RequestBody Service service) {

        return new ResponseEntity<>(this.serviceService.update(id,service), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        Service service= this.serviceService.getById(identificacion);
        if ( service!= null) {
            this.serviceService.delete(service);
        }
    }
}
