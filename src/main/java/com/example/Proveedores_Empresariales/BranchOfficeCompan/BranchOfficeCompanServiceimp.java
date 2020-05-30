package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeCompanServiceimp implements BranchOfficeCompanService {

    private RepositoryBranchOfficeCompan repositoryCity;

    public BranchOfficeCompanServiceimp(RepositoryBranchOfficeCompan repositoryCity) {
        this.repositoryCity = repositoryCity;
    }


    @Override
    public BranchOfficeCompan save(BranchOfficeCompan branchOfficeCompan) {
        return this.repositoryCity.save(branchOfficeCompan);
    }

    @Override
    public List<BranchOfficeCompan> getAll() {
        return this.repositoryCity.findAll();
    }

    @Override
    public BranchOfficeCompan getById(int id) {
        return this.repositoryCity.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }
    @Override
    public BranchOfficeCompan update(BranchOfficeCompan branchOfficeCompan) {
        return this.repositoryCity.save(branchOfficeCompan);
    }

    @Override
    public void delete(BranchOfficeCompan branchOfficeCompan) {
        this.repositoryCity.delete(branchOfficeCompan);
    }
}
