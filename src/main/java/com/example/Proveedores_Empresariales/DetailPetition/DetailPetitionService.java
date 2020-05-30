package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.Departament.Departament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailPetitionService {

    public DetailPetition save(DetailPetition detailPetition);

    public List<DetailPetition> getAll();

    public DetailPetition getById(int id);

    public DetailPetition update(DetailPetition detailPetition);

    public void delete(DetailPetition detailPetition);
}
