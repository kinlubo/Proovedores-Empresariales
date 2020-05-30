package com.example.Proveedores_Empresariales.OrdersPurchase;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersPurchaseService {

    public OrdersPurchase save(OrdersPurchase ordersPurchase);

    public List<OrdersPurchase> getAll();

    public OrdersPurchase getById(int id);

    public OrdersPurchase update(OrdersPurchase ordersPurchase);

    public void delete(OrdersPurchase ordersPurchase);
}
