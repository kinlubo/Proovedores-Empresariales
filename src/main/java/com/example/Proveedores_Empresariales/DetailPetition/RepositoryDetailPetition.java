package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDetailPetition extends JpaRepository<DetailPetition,Integer> {
}
