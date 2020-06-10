package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceimp implements CityService {

    private RepositoryCity repositoryCity;
    private DepartmentService departmentService;

    public CityServiceimp(RepositoryCity repositoryCity, DepartmentService departmentService) {
        this.repositoryCity = repositoryCity;
        this.departmentService = departmentService;
    }


    @Override
    public City save(City city) {
        Departament departament = null;
            if (departmentService.getByName(city.getDepartament().getName())==null) {
                departmentService.save(city.getDepartament());
            }
        departament = departmentService.getByName(city.getDepartament().getName());
        int val = repositoryCity.findAll().size()+1;
        CityPK cityPK = new CityPK(val,departament.getId());
        city.setCityPK(cityPK);
        city.setDepartament(departament);
        return this.repositoryCity.save(city);
    }

    @Override
    public List<City> getAll() {
        return this.repositoryCity.findAll();
    }

    @Override
    public City getById(CityPK id) {
        return this.repositoryCity.findById(id).orElseThrow(()->
                new ResourceNotFoundException("City identified by :"+id+" . Not found"));
    }
    @Override
    public City update(CityPK id,City city) {
        City city1 = getById(id);
        city1.setName(city.getName());
        return this.repositoryCity.save(city1);
    }

    @Override
    public void delete(City city) {
        this.repositoryCity.delete(city);
    }

    @Override
    public City getByName(String name) {
        return this.repositoryCity.findCityByName(name);
    }
}
