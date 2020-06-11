package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface CompanyService {

    public Company save(Company company);

    public List<Company> getAll();

    public Company getById(BigInteger id);

    public Company update(BigInteger nic,Company company);

    public void delete (Company company);
}
