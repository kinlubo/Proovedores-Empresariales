package com.example.Proveedores_Empresariales.Country;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceimp implements CountryService {

    private RepositoryCountry repositoryCountry;

    public CountryServiceimp(RepositoryCountry repositoryCountry) {
        this.repositoryCountry = repositoryCountry;
    }


    @Override
    public Country save(Country country) {
        return this.repositoryCountry.save(country);
    }

    @Override
    public List<Country> getAll() {
        return this.repositoryCountry.findAll();
    }

    @Override
    public Country getById(int id) {
        return this.repositoryCountry.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public Country update(int Id, Country country) {
        Country countryTo = getById(Id);
        countryTo.setName(country.getName());
        return this.repositoryCountry.save(country);
    }

    @Override
    public void delete(Country country) {
        this.repositoryCountry.delete(country);
    }
}
