package com.example.Proveedores_Empresariales.RawMaterials;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryRawMaterials extends JpaRepository<RawMaterials,Integer> {
    @Query("Select c from RawMaterials c where UPPER(c.name) like UPPER(:name)")
    public RawMaterials findCityByName(@Param("name")String name);
}
