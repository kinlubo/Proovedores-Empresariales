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
    public OrdersPurchase update(int id,OrdersPurchase ordersPurchase) {
        OrdersPurchase ordersPurchase1 = getById(id);
        ordersPurchase1.setWayToPay(ordersPurchase.getWayToPay());
        ordersPurchase1.setDateOrder(ordersPurchase.getDateOrder());
        ordersPurchase1.setDateDelivery(ordersPurchase.getDateDelivery());
        ordersPurchase1.setBranchOfficeCompan(ordersPurchase.getBranchOfficeCompan());
        ordersPurchase1.setOrderInventory(ordersPurchase.getOrderInventory());
        return this.repositoryOrdersPurchase.save(ordersPurchase1);
    }

    @Override
    public void delete(OrdersPurchase ordersPurchase) {
        this.repositoryOrdersPurchase.delete(ordersPurchase);
    }
}
