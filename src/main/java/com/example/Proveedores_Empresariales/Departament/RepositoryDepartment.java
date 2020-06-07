package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDepartment extends JpaRepository<Departament,Integer> {

    @Query("Select c from Departament c where upper(c.name) like UPPER(:name)")
    public Departament findDepartamentByName(@Param("name")String name);
}
