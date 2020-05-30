package com.example.Proveedores_Empresariales.OrdersPurchase;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersPurchaseServiceimp implements OrdersPurchaseService {

    private RepositoryOrdersPurchase repositoryOrdersPurchase;

    public OrdersPurchaseServiceimp(RepositoryOrdersPurchase repositoryDepartment) {
        this.repositoryOrdersPurchase = repositoryDepartment;
    }


    @Override
    public OrdersPurchase save(OrdersPurchase ordersPurchase) {
        return this.repositoryOrdersPurchase.save(ordersPurchase);
    }

    @Override
    public List<OrdersPurchase> getAll() {
        return this.repositoryOrdersPurchase.findAll();
    }

    @Override
    public OrdersPurchase getById(int id) {
        return this.repositoryOrdersPurchase.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public OrdersPurchase update(OrdersPurchase ordersPurchase) {
        return this.repositoryOrdersPurchase.save(ordersPurchase);
    }

    @Override
    public void delete(OrdersPurchase ordersPurchase) {
        this.repositoryOrdersPurchase.delete(ordersPurchase);
    }
}
