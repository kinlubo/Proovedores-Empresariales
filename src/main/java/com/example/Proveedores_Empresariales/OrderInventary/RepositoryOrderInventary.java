package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrderInventary extends JpaRepository<OrderInventory,Integer> {
}
