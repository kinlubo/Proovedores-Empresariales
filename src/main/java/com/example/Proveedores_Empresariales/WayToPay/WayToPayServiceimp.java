package com.example.Proveedores_Empresariales.WayToPay;

import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayToPayServiceimp implements WayToPayService {

    private RepositoryWayToPay repositoryWayToPay;

    public WayToPayServiceimp(RepositoryWayToPay repositoryWayToPay) {
        this.repositoryWayToPay = repositoryWayToPay;
    }


    @Override
    public WayToPay save(WayToPay wayToPay) {
        return this.repositoryWayToPay.save(wayToPay);
    }

    @Override
    public List<WayToPay> getAll() {
        return this.repositoryWayToPay.findAll();
    }

    @Override
    public WayToPay getById(int id) {
        return this.repositoryWayToPay.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public WayToPay update(int id,WayToPay wayToPay)
    {
        WayToPay wayToPay1 = getById(id);
        wayToPay1.setName(wayToPay.getName());
        return this.repositoryWayToPay.save(wayToPay1);
    }

    @Override
    public void delete(WayToPay wayToPay) {
        this.repositoryWayToPay.delete(wayToPay);
    }
}
