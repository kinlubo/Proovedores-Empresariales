package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceimp implements CompanyService {

    private RepositoryCompany repositoryCompany;

    public CompanyServiceimp(RepositoryCompany repositoryCompany) {
        this.repositoryCompany = repositoryCompany;
    }

    @Override
    public Company save(Company company) {
        return this.repositoryCompany.save(company);
    }

    @Override
    public List<Company> getAll() {
        return this.repositoryCompany.findAll();
    }

    @Override
    public Company getById(int id) {
        return this.repositoryCompany.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public Company update(Company company) {
        return this.repositoryCompany.save(company);
    }

    @Override
    public void delete(Company company) {
        this.repositoryCompany.delete(company);
    }
}
