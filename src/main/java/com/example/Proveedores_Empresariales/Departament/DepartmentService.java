package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Country.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public Departament save(Departament department);

    public List<Departament> getAll();

    public Departament getById(int id);

    public Departament update(int id,Departament departament);

    public void delete (Departament departament);
}
