package com.example.Proveedores_Empresariales.Orders;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrders extends JpaRepository<Orders,Integer> {
}
