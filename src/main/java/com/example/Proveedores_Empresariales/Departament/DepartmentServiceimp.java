package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimp implements DepartmentService {

    private RepositoryDepartment repositoryDepartment;

    public DepartmentServiceimp(RepositoryDepartment repositoryDepartment) {
        this.repositoryDepartment = repositoryDepartment;

    }


    @Override
    public Departament save(Departament departament) {
        return this.repositoryDepartment.save(departament);
    }

    @Override
    public List<Departament> getAll() {
        return this.repositoryDepartment.findAll();
    }

    @Override
    public Departament getById(int id) {
        return this.repositoryDepartment.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department identified by :"+id+" . Not found"));
    }

    @Override
    public Departament update(int id,Departament departament) {
        Departament departament1 = getById(id);
        departament1.setName(departament.getName());

        return this.repositoryDepartment.save(departament1);
    }

    @Override
    public void delete(Departament departament) {
        this.repositoryDepartment.delete(departament);
    }

    @Override
    public Departament getByName(String name) {
        return this.repositoryDepartment.findDepartamentByName(name);
    }
}
