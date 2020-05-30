package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderInventaryService {

    public OrderInventory save(OrderInventory orderInventory);

    public List<OrderInventory> getAll();

    public OrderInventory getById(int id);

    public OrderInventory update(OrderInventory orderInventory);

    public void delete(OrderInventory orderInventory);
}
