package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeCompanServiceimp implements BranchOfficeCompanService {

    private RepositoryBranchOfficeCompan repositoryBranchOfficeCompan;
    private CityService cityService;
    private DepartmentService departmentService;

    @Autowired
    public BranchOfficeCompanServiceimp(RepositoryBranchOfficeCompan repositoryBranchOfficeCompan, CityService cityService, DepartmentService departmentService) {
        this.repositoryBranchOfficeCompan = repositoryBranchOfficeCompan;
        this.cityService = cityService;
        this.departmentService = departmentService;
    }


    @Override
    public BranchOfficeCompan save(BranchOfficeCompan branchOfficeCompan) {

        try {
            departmentService.getByName(branchOfficeCompan.getCity().getDepartament().getName());
        }
        catch (ResourceNotFoundException error){
            departmentService.save(branchOfficeCompan.getCity().getDepartament());
        }
        try {
            cityService.getByName(branchOfficeCompan.getCity().getName());
        }
        catch (ResourceNotFoundException error){
            cityService.save(branchOfficeCompan.getCity());
        }
        return this.repositoryBranchOfficeCompan.save(branchOfficeCompan);
    }

    @Override
    public List<BranchOfficeCompan> getAll() {
        return this.repositoryBranchOfficeCompan.findAll();
    }

    @Override
    public BranchOfficeCompan getById(int id) {
        return this.repositoryBranchOfficeCompan.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }
    @Override
    public BranchOfficeCompan update( int nic,BranchOfficeCompan branchOfficeCompan) {
        BranchOfficeCompan branchOfficeCompan1 = getById(nic);
        branchOfficeCompan1.setName(branchOfficeCompan.getName());
        return this.repositoryBranchOfficeCompan.save(branchOfficeCompan1);
    }

    @Override
    public void delete(BranchOfficeCompan branchOfficeCompan) {
        this.repositoryBranchOfficeCompan.delete(branchOfficeCompan);
    }
}
