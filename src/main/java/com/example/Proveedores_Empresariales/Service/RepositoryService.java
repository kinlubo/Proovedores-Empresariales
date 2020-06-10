package com.example.Proveedores_Empresariales.Service;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryService extends JpaRepository<Service,Integer> {

}
