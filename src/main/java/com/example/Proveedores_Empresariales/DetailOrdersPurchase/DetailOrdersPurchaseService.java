package com.example.Proveedores_Empresariales.DetailOrdersPurchase;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailOrdersPurchaseService {

    public DetailOrdersPurchase save(DetailOrdersPurchase detailOrdersPurchase);

    public List<DetailOrdersPurchase> getAll();

    public DetailOrdersPurchase getById(int id);

    public DetailOrdersPurchase update(int id,DetailOrdersPurchase detailOrdersPurchase);

    public void delete(DetailOrdersPurchase detailOrdersPurchase);
}
