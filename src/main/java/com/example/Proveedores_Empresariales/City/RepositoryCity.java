package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCity extends JpaRepository<City,CityPK> {

    @Query("Select c from City c where UPPER(c.name) like UPPER(:name)")
    public City findCityByName(@Param("name")String name);
}
