package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOrderInventary extends JpaRepository<OrderInventory,Integer> {
}
