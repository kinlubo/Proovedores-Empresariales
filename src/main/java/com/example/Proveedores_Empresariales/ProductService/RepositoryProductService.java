package com.example.Proveedores_Empresariales.ProductService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProductService extends JpaRepository<ProductService,Integer> {
    @Query("Select c  from ProductService c where  upper( c.name) like upper(:name) ")
    public List findFInd(@Param("name") String name);
}
