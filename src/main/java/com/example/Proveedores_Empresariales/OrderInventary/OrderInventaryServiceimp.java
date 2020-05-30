package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInventaryServiceimp implements OrderInventaryService {

    private RepositoryOrderInventary repositoryOrderInventary;

    public OrderInventaryServiceimp(RepositoryOrderInventary repositoryOrderInventary) {
        this.repositoryOrderInventary = repositoryOrderInventary;
    }


    @Override
    public OrderInventory save(OrderInventory orderInventory) {
        return this.repositoryOrderInventary.save(orderInventory);
    }

    @Override
    public List<OrderInventory> getAll() {
        return this.repositoryOrderInventary.findAll();
    }

    @Override
    public OrderInventory getById(int id) {
        return this.repositoryOrderInventary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public OrderInventory update(OrderInventory orderInventory) {
        return this.repositoryOrderInventary.save(orderInventory);
    }

    @Override
    public void delete(OrderInventory orderInventory) {
        this.repositoryOrderInventary.delete(orderInventory);
    }
}
