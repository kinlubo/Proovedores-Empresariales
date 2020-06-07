package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBranchOfficeCompan extends JpaRepository<BranchOfficeCompan,Integer> {
}
