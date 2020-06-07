package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    public City save(City city);

    public List<City> getAll();

    public City getById(CityPK id);

    public City update( CityPK id,City city);

    public void delete (City city);

    public City getByName(String name);
}
