package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
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

@RequestMapping("api/v1/company")
@RestController
@CrossOrigin
public class CompanyRestController {

    private CompanyService companyService;

    public CompanyRestController(CompanyService companyService, DepartmentService departmentService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody Company company)
    {
        return ResponseEntity.ok().body(this.companyService.save(company));
    }

    @GetMapping
    public ResponseEntity <List<Company>> getAll()
    {
        return ResponseEntity.ok().body(this.companyService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<Company>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.companyService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<Company> update(@PathVariable("identificacion") Integer nic,@RequestBody Company company)
    {
        return new ResponseEntity<>(this.companyService.update(nic,company), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int nic) {

        Company company= this.companyService.getById(nic);
        if ( company!= null) {
            this.companyService.delete(company);
        }
    }
}
