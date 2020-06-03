package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.Departament.Departament;
import com.example.Proveedores_Empresariales.serviceException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailPetitionServiceimp implements DetailPetitionService {

    private RepositoryDetailPetition repositoryDetailPetition;
    private DetailPetition detailPetition1;

    public DetailPetitionServiceimp(RepositoryDetailPetition repositoryDetailPetition) {
        this.repositoryDetailPetition = repositoryDetailPetition;
        detailPetition1 = null;
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
    public DetailPetition update(int id,DetailPetition detailPetition) {
        detailPetition1 = getById(id);
        detailPetition1.setRawMaterials(detailPetition.getRawMaterials());
        detailPetition1.setOrderInventory(detailPetition.getOrderInventory());
        detailPetition1.setQuantity(detailPetition.getQuantity());
        detailPetition1.setProduct(detailPetition.getProduct());
        return this.repositoryDetailPetition.save(detailPetition1);
    }

    @Override
    public void delete(DetailPetition detailPetition) {
        this.repositoryDetailPetition.delete(detailPetition);
    }
}
