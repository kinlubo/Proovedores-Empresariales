package com.example.Proveedores_Empresariales.RawMaterials;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialsServiceimp implements RawMaterialsService {

    private RepositoryRawMaterials repositoryRawMaterials;

    public RawMaterialsServiceimp(RepositoryRawMaterials repositoryRawMaterials) {
        this.repositoryRawMaterials = repositoryRawMaterials;
    }


    @Override
    public RawMaterials save(RawMaterials rawMaterials) {
        return this.repositoryRawMaterials.save(rawMaterials);
    }

    @Override
    public List<RawMaterials> getAll() {
        return this.repositoryRawMaterials.findAll();
    }

    @Override
    public RawMaterials getById(int id) {
        return this.repositoryRawMaterials.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public RawMaterials update(RawMaterials rawMaterials) {
        return this.repositoryRawMaterials.save(rawMaterials);
    }

    @Override
    public void delete(RawMaterials rawMaterials) {
        this.repositoryRawMaterials.delete(rawMaterials);
    }
}
