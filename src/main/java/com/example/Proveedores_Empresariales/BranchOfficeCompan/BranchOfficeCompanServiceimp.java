package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.City.CityService;
import com.example.Proveedores_Empresariales.City.CityServiceimp;
import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.Departament.DepartmentService;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BranchOfficeCompanServiceimp implements BranchOfficeCompanService {

    private RepositoryBranchOfficeCompan repositoryBranchOfficeCompan;
    private CityServiceimp cityService;
    private DepartmentService departmentService;

    @Autowired
    public BranchOfficeCompanServiceimp(RepositoryBranchOfficeCompan repositoryBranchOfficeCompan, CityService cityService, CityServiceimp cityService1, DepartmentService departmentService) {
        this.repositoryBranchOfficeCompan = repositoryBranchOfficeCompan;
        this.cityService = cityService1;
        this.departmentService = departmentService;
    }


    @Override
    public BranchOfficeCompan save(BranchOfficeCompan branchOfficeCompan) {
        Departament departament = null;
        City city = null;
            if (cityService.getByName(branchOfficeCompan.getCity().getName())==null) {
                cityService.save(branchOfficeCompan.getCity());
            }else{
                city = cityService.getByName(branchOfficeCompan.getCity().getName());
                branchOfficeCompan.setCity(city);
            }

        return this.repositoryBranchOfficeCompan.save(branchOfficeCompan);
    }

    @Override
    public List<BranchOfficeCompan> getAll() {
        return this.repositoryBranchOfficeCompan.findAll();
    }

    @Override
    public BranchOfficeCompan getById(BigInteger id) {
        return this.repositoryBranchOfficeCompan.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }
    @Override
    public BranchOfficeCompan update( BigInteger nic,BranchOfficeCompan branchOfficeCompan) {
        BranchOfficeCompan branchOfficeCompan1 = getById(nic);
        branchOfficeCompan1.setName(branchOfficeCompan.getName());
        return this.repositoryBranchOfficeCompan.save(branchOfficeCompan1);
    }

    @Override
    public void delete(BranchOfficeCompan branchOfficeCompan) {
        this.repositoryBranchOfficeCompan.delete(branchOfficeCompan);
    }
}
