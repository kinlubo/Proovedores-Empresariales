package com.example.Proveedores_Empresariales.Company;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RepositoryCompany extends JpaRepository<Company, BigInteger> {
}
