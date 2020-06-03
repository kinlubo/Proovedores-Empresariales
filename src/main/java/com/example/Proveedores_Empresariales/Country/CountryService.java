package com.example.Proveedores_Empresariales.Country;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    public Country save (Country country);

    public List<Country> getAll();

    public Country getById(int id);

    public Country update(int id,Country country);

    public void delete (Country country);
}
