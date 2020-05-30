package com.example.Proveedores_Empresariales.ProductWholesaler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

public interface RepositoryProductWholesaler extends JpaRepository<ProductWholesaler,ProductWhoPK> {
    public ProductWholesaler findByIdProducto(ProductWhoPK productWhoPK);
}
