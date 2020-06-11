package com.example.Proveedores_Empresariales.OrdersPurchase;

import com.example.Proveedores_Empresariales.DetailOrdersPurchase.DetailOrdersPurchase;
import com.example.Proveedores_Empresariales.DetailOrdersPurchase.RepositoryDetailOrdersPurchase;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersPurchaseServiceimp implements OrdersPurchaseService {

    private RepositoryOrdersPurchase repositoryOrdersPurchase;
    private RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase;

    public OrdersPurchaseServiceimp(RepositoryOrdersPurchase repositoryDepartment, RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase) {
        this.repositoryOrdersPurchase = repositoryDepartment;
        this.repositoryDetailOrdersPurchase = repositoryDetailOrdersPurchase;
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

        List<DetailOrdersPurchase> detailOrdersPurchase = repositoryDetailOrdersPurchase.findAll();
        for (int i = 0; detailOrdersPurchase.size()>i;i++)
        {
            if (detailOrdersPurchase.get(i).getOrdersPurchase()==ordersPurchase)
            {
                this.repositoryDetailOrdersPurchase.delete(detailOrdersPurchase.get(i));
            }
        }
        this.repositoryOrdersPurchase.delete(ordersPurchase);
    }
}
