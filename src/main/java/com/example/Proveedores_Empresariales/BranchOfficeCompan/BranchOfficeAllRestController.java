package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Company.Company;
import com.example.Proveedores_Empresariales.Company.CompanyService;
import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/branchofficeall")
@RestController
public class BranchOfficeAllRestController {
    private BranchOfficeCompanService branchOfficeCompanService;
    private CompanyService companyService;
    private CityService cityService;
    private CountryService countryService;
    private DepartmentService departmentService;

    public BranchOfficeAllRestController(BranchOfficeCompanService branchOfficeCompanService, CompanyService companyService, CityService cityService, CountryService countryService, DepartmentService departmentService) {
        this.branchOfficeCompanService = branchOfficeCompanService;
        this.companyService = companyService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.departmentService = departmentService;
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

    public City cityId(String id)
    {
        City city = null;
        List<City> cities = cityService.getAll();
        for (int i = 0; cities.size()>i; i++)
        {
            if(cities.get(i).getName().equalsIgnoreCase(id))
            {
                city = cities.get(i);
            }
        }
        return  city;
    }
    public Country country(String id)
    {
        Country city = null;
        List<Country> cities = countryService.getAll();
        for (int i = 0; cities.size()>i; i++)
        {
            if(cities.get(i).getName().equalsIgnoreCase(id))
            {
                city = cities.get(i);
            }
        }
        return  city;
    }
    public Departament departament(String id)
    {
        Departament city = null;
        List<Departament> cities = departmentService.getAll();
        for (int i = 0; cities.size()>i; i++)
        {
            if(cities.get(i).getName().equalsIgnoreCase(id))
            {
                city = cities.get(i);
            }
        }
        return  city;
    }

    @PostMapping
    public ResponseEntity<BranchOfficeCompan> save(@RequestBody BranchOfficeCompan branchOfficeCompan)
    {
        int ver = this.branchOfficeCompanService.getAll().size()+1;
        branchOfficeCompan.setNic(ver);
        City city = branchOfficeCompan.getCity();
        Departament departament = city.getDepartament();
        Country country = departament.getCountry();
        Company company =
        return ResponseEntity.ok().body(this.branchOfficeCompanService.save(branchOfficeCompan));
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Company> save(@PathVariable("id") Integer nic, String name, String mail, int phone, String direccion)
    {
        Company company = new Company(nic,name,mail,phone,direccion);
        return ResponseEntity.ok().body(this.companyService.save(company));
    }
}
