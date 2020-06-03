package com.example.Proveedores_Empresariales.DetailOrdersPurchase;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrdersPurchaseServiceimp implements DetailOrdersPurchaseService {

    private RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase;
    private DetailOrdersPurchase detailOrdersPurchase1;

    public DetailOrdersPurchaseServiceimp(RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase) {
        this.repositoryDetailOrdersPurchase = repositoryDetailOrdersPurchase;
        detailOrdersPurchase1 = null;
    }


    @Override
    public DetailOrdersPurchase save(DetailOrdersPurchase detailOrdersPurchase) {
        return this.repositoryDetailOrdersPurchase.save(detailOrdersPurchase);
    }

    @Override
    public List<DetailOrdersPurchase> getAll() {
        return this.repositoryDetailOrdersPurchase.findAll();
    }

    @Override
    public DetailOrdersPurchase getById(int id) {
        return this.repositoryDetailOrdersPurchase.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public DetailOrdersPurchase update( int id,DetailOrdersPurchase detailOrdersPurchase) {
        detailOrdersPurchase1 = getById(id);
        detailOrdersPurchase1.setQuantity(detailOrdersPurchase.getQuantity());
        detailOrdersPurchase1.setOrdersPurchase(detailOrdersPurchase.getOrdersPurchase());
        detailOrdersPurchase1.setProductService(detailOrdersPurchase.getProductService());
        detailOrdersPurchase1.setValueTotal(detailOrdersPurchase.getValueTotal());
        detailOrdersPurchase1.setValueUnitary(detailOrdersPurchase.getValueUnitary());
        detailOrdersPurchase1.setDateMaximunDeliveryOrder(detailOrdersPurchase.getDateMaximunDeliveryOrder());
        return this.repositoryDetailOrdersPurchase.save(detailOrdersPurchase1);
    }

    @Override
    public void delete(DetailOrdersPurchase detailOrdersPurchase) {
        this.repositoryDetailOrdersPurchase.delete(detailOrdersPurchase);
    }
}
