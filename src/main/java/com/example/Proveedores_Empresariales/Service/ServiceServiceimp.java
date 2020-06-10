package com.example.Proveedores_Empresariales.Service;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceimp implements ServiceService {

    private RepositoryService repositoryService;

    public ServiceServiceimp(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }


    @Override
    public Service save(Service service) {
        return this.repositoryService.save(service);
    }

    @Override
    public List<Service> getAll() {
        return this.repositoryService.findAll();
    }

    @Override
    public Service getById(int id) {
        return this.repositoryService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public Service update(int id,Service service) {
        Service service1 = getById(id);
        service1.setPlan(service.getPlan());
        service1.setDuration(service.getDuration());
        return this.repositoryService.save(service1);
    }

    @Override
    public void delete(Service service) {
        this.repositoryService.delete(service);
    }


}
