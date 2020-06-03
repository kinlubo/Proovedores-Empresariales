package com.example.Proveedores_Empresariales.RawMaterials;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RawMaterialsService {

    public RawMaterials save(RawMaterials rawMaterials);

    public List<RawMaterials> getAll();

    public RawMaterials getById(int id);

    public RawMaterials update(int code,RawMaterials rawMaterials);

    public void delete(RawMaterials rawMaterials);
}
