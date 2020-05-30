package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceimp implements CityService {

    private RepositoryCity repositoryCity;

    public CityServiceimp(RepositoryCity repositoryCity) {
        this.repositoryCity = repositoryCity;
    }


    @Override
    public City save(City city) {
        return this.repositoryCity.save(city);
    }

    @Override
    public List<City> getAll() {
        return this.repositoryCity.findAll();
    }

    @Override
    public City getById(int id) {
        return this.repositoryCity.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }
    @Override
    public City update(City city) {
        return this.repositoryCity.save(city);
    }

    @Override
    public void delete(City city) {
        this.repositoryCity.delete(city);
    }
}
