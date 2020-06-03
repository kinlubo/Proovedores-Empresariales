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
    public RawMaterials update(int id,RawMaterials rawMaterials) {
        RawMaterials rawMaterials1 = getById(id);
        rawMaterials1.setName(rawMaterials.getName());
        rawMaterials1.setRawMaterialType(rawMaterials.getRawMaterialType());
        rawMaterials1.setMeasurementCode(rawMaterials.getMeasurementCode());
        rawMaterials1.setDescription(rawMaterials.getDescription());
        rawMaterials1.setMaxStock(rawMaterials.getMaxStock());
        rawMaterials1.setMinimumStock(rawMaterials.getMinimumStock());
        rawMaterials1.setStateCode(rawMaterials.getStateCode());
        return this.repositoryRawMaterials.save(rawMaterials1);
    }

    @Override
    public void delete(RawMaterials rawMaterials) {
        this.repositoryRawMaterials.delete(rawMaterials);
    }
}
