package com.example.Proveedores_Empresariales.Service;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceService {

    public Service save (Service service);

    public List<Service> getAll();

    public Service getById(int id);

    public Service update(Service service);

    public void delete (Service service);
}
