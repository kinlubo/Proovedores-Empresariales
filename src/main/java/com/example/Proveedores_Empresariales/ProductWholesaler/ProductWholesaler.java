package com.example.Proveedores_Empresariales.ProductWholesaler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWholesaler implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductWholesalerPK productWholesalerPK;
    @Basic(optional = false)
    @Column(name = "quantity_final")
    private int quantityFinal;
    @Basic(optional = false)
    private int value;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "productWholesaler")
    private Collection<ProductService> productServiceCollection;*/
}
