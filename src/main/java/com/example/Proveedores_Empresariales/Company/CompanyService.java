package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    public Company save(Company company);

    public List<Company> getAll();

    public Company getById(int id);

    public Company update(Company company);

    public void delete (Company company);
}
