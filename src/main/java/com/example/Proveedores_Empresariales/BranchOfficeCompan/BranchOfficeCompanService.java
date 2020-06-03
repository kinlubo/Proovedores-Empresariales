package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchOfficeCompanService {

    public BranchOfficeCompan save(BranchOfficeCompan branchOfficeCompan);

    public List<BranchOfficeCompan> getAll();

    public BranchOfficeCompan getById(int id);

    public BranchOfficeCompan update(int nic,BranchOfficeCompan branchOfficeCompan);

    public void delete(BranchOfficeCompan branchOfficeCompan);
}
