package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    public City save(City city);

    public List<City> getAll();

    public City getById(int id);

    public City update( int id,City city);

    public void delete (City city);
}
