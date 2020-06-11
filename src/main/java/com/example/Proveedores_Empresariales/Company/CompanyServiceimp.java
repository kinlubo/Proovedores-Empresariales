package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
    public Company getById(BigInteger id) {
        return this.repositoryCompany.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public Company update( BigInteger nic, Company company) {
        Company company1 = getById(nic);
        company1.setName(company.getName());
        company1.setEmail(company.getEmail());
        company1.setPhone(company.getPhone());
        company1.setDirection(company.getDirection());
        return this.repositoryCompany.save(company1);
    }

    @Override
    public void delete(Company company) {
        this.repositoryCompany.delete(company);
    }
}
