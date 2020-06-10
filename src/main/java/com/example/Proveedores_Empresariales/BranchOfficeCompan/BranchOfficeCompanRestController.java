package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityPK;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Company.Company;
import com.example.Proveedores_Empresariales.Company.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RequestMapping("api/v1/branchoffice")
@RestController
@CrossOrigin
public class BranchOfficeCompanRestController {

    private BranchOfficeCompanService branchOfficeCompanService;
    private CompanyService companyService;
    private CityService cityService;

    public BranchOfficeCompanRestController(BranchOfficeCompanService branchOfficeCompanService, CompanyService companyService, CityService cityService) {
       this.branchOfficeCompanService = branchOfficeCompanService;
        this.companyService = companyService;
        this.cityService = cityService;
    }


    @PostMapping
    public ResponseEntity<BranchOfficeCompan> save(@RequestBody  BranchOfficeCompan branchOfficeCompan)
    {

        return ResponseEntity.ok().body(this.branchOfficeCompanService.save(branchOfficeCompan));
    }

    @GetMapping
    public ResponseEntity <List<BranchOfficeCompan>> getAll()
    {
        return ResponseEntity.ok().body(this.branchOfficeCompanService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<BranchOfficeCompan>getById(@PathVariable("id") BigInteger id)
    {
        return ResponseEntity.ok().body(this.branchOfficeCompanService.getById(id));
    }


    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<BranchOfficeCompan> update(@PathVariable("identificacion")BigInteger nic,@RequestBody BranchOfficeCompan branchOfficeCompan) {

        return new ResponseEntity<>(this.branchOfficeCompanService.update(nic,branchOfficeCompan),HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") BigInteger identificacion) {

        BranchOfficeCompan branchOfficeCompan= this.branchOfficeCompanService.getById(identificacion);
        if ( branchOfficeCompan!= null) {
            this.branchOfficeCompanService.delete(branchOfficeCompan);
        }
    }

}
