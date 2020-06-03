package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Company.Company;
import com.example.Proveedores_Empresariales.Company.CompanyService;
import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
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
    public ResponseEntity<BranchOfficeCompan> save(@RequestBody Integer nic, String name, Integer phone, String mail, String diretion, String city_Name,String country_Name, Integer companyId,String departament_Name,int codeCity)
    {   BranchOfficeCompan branchOfficeCompan = null;
        Country country1 = null;
        Departament departament1 = null;
        City city = null;
        int varCoun= this.countryService.getAll().size()+1;
        int varDep=this.departmentService.getAll().size()+1;
        int varCit= this.cityService.getAll().size()+1;
        if(country(country_Name)==null)
        {/*
            country1 = new Country(varCoun,country_Name);
            this.countryService.save(country1);
            departament1 = new Departament(varDep,departament_Name,country1);
            this.departmentService.save(departament1);
            city = new City(varCit,codeCity,city_Name,departament1);
            this.cityService.save(city);
            */


        }else if(departament(departament_Name)==null)
        {
            country1 = country(country_Name);
            departament1 = new Departament(varDep,departament_Name,country1);
            this.departmentService.save(departament1);
            city = new City(varCit,codeCity,city_Name,departament1);
            this.cityService.save(city);
        } else
            if(cityId(city_Name)==null)
        {
            departament1 = departament(departament_Name);
            city = new City(varCit,codeCity,city_Name,departament1);
            this.cityService.save(city);

        } else
        {
            city = cityId(city_Name);
        }
        Company company = companyId(companyId);
        branchOfficeCompan =  new BranchOfficeCompan(nic,name,phone,mail,diretion,city,company);
        return ResponseEntity.ok().body(this.branchOfficeCompanService.save(branchOfficeCompan));
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Company> save(@RequestBody @PathVariable("id") Integer nic, String name, String mail, int phone, String direccion)
    {
        Company company = new Company(nic,name,mail,phone,direccion);
        return ResponseEntity.ok().body(this.companyService.save(company));
    }
}
