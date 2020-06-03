package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.Country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDepartment extends JpaRepository<Departament,Integer> {
}
