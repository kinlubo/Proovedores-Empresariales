package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailPetitionServiceimp implements DetailPetitionService {

    private RepositoryDetailPetition repositoryDetailPetition;

    public DetailPetitionServiceimp(RepositoryDetailPetition repositoryDetailPetition) {
        this.repositoryDetailPetition = repositoryDetailPetition;
    }


    @Override
    public DetailPetition save(DetailPetition detailPetition) {
        return this.repositoryDetailPetition.save(detailPetition);
    }

    @Override
    public List<DetailPetition> getAll() {
        return this.repositoryDetailPetition.findAll();
    }

    @Override
    public DetailPetition getById(int id) {
        return this.repositoryDetailPetition.findById(id).orElseThrow(()-> new ResourceNotFoundException("Country identified by :"+id+" . Not found"));
    }

    @Override
    public DetailPetition update(DetailPetition detailPetition) {
        return this.repositoryDetailPetition.save(detailPetition);
    }

    @Override
    public void delete(DetailPetition detailPetition) {
        this.repositoryDetailPetition.delete(detailPetition);
    }
}
