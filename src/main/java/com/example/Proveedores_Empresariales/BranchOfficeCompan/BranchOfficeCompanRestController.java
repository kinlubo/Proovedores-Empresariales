package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Company.Company;
import com.example.Proveedores_Empresariales.Company.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/branchoffice")
@RestController
public class BranchOfficeCompanRestController {

    private BranchOfficeCompanService branchOfficeCompanService;
    private CompanyService companyService;
    private CityService cityService;

    public BranchOfficeCompanRestController(BranchOfficeCompanService branchOfficeCompanService, CompanyService companyService, CityService cityService) {
       this.branchOfficeCompanService = branchOfficeCompanService;
        this.companyService = companyService;
        this.cityService = cityService;
    }

    public Company companyId(Integer id)
    {
        Company company = null;
        List<Company> companies = companyService.getAll();
        for (int i = 0; companies.size()>i; i++)
        {
            if(companies.get(i).getNic()==id)
            {
                 company = companies.get(i);
            }
        }
        return  company;
    }

    public City cityId(Integer id)
    {
        City city = null;
        List<City> cities = cityService.getAll();
        for (int i = 0; cities.size()>i; i++)
        {
            if(cities.get(i).getId()==id)
            {
                city = cities.get(i);
            }
        }
        return  city;
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
    public ResponseEntity<BranchOfficeCompan>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.branchOfficeCompanService.getById(id));
    }


    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<BranchOfficeCompan> update(@PathVariable("identificacion")Integer nic,@RequestBody BranchOfficeCompan branchOfficeCompan) {

        return new ResponseEntity<>(this.branchOfficeCompanService.update(nic,branchOfficeCompan),HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        BranchOfficeCompan branchOfficeCompan= this.branchOfficeCompanService.getById(identificacion);
        if ( branchOfficeCompan!= null) {
            this.branchOfficeCompanService.delete(branchOfficeCompan);
        }
    }

}
