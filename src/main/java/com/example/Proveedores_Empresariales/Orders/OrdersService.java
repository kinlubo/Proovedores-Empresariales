package com.example.Proveedores_Empresariales.Orders;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

    public Orders save(Orders orders);

    public List<Orders> getAll();

    public Orders getById(int id);

    public Orders update(Orders orders);

    public void delete(Orders orders);
}
