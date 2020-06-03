package com.example.Proveedores_Empresariales.Orders;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceimp implements OrdersService {

    private RepositoryOrders repositoryOrders;

    public OrdersServiceimp(RepositoryOrders repositoryOrders) {
        this.repositoryOrders = repositoryOrders;
    }


    @Override
    public Orders save(Orders orders) {
        return this.repositoryOrders.save(orders);
    }

    @Override
    public List<Orders> getAll() {
        return this.repositoryOrders.findAll();
    }

    @Override
    public Orders getById(int id) {
        return this.repositoryOrders.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public Orders update(int code,Orders orders) {
        Orders orders1 = getById(code);
        orders1.setStateCode(orders.getStateCode());
        return this.repositoryOrders.save(orders);
    }

    @Override
    public void delete(Orders orders) {
        this.repositoryOrders.delete(orders);
    }
}
