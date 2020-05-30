package com.example.Proveedores_Empresariales.DetailOrdersPurchase;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrdersPurchaseServiceimp implements DetailOrdersPurchaseService {

    private RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase;

    public DetailOrdersPurchaseServiceimp(RepositoryDetailOrdersPurchase repositoryDetailOrdersPurchase) {
        this.repositoryDetailOrdersPurchase = repositoryDetailOrdersPurchase;
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
    public DetailOrdersPurchase update(DetailOrdersPurchase detailOrdersPurchase) {
        return this.repositoryDetailOrdersPurchase.save(detailOrdersPurchase);
    }

    @Override
    public void delete(DetailOrdersPurchase detailOrdersPurchase) {
        this.repositoryDetailOrdersPurchase.delete(detailOrdersPurchase);
    }
}
