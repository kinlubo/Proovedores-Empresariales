package com.example.Proveedores_Empresariales.ProductWholesaler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWholesaler implements Serializable {

    @EmbeddedId
    private ProductWhoPK idProducto;
    @Basic(optional = false)
    @Column(name = "quantity_final")
    private int quantityFinal;
    @Basic(optional = false)
    private int value;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "productWholesaler")
    private Collection<ProductService> productServiceCollection;*/
}
