package com.example.Proveedores_Empresariales.WayToPay;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WayToPayService {

    public WayToPay save(WayToPay wayToPay);

    public List<WayToPay> getAll();

    public WayToPay getById(int id);

    public WayToPay update(int id,WayToPay wayToPay);

    public void delete(WayToPay wayToPay);
}
