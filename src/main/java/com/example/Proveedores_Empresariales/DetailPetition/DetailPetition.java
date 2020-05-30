package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterials;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail_petition", catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailPetition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int product;
    @Basic(optional = false)
    private int quantity;
    @JoinColumn(name = "petitions_inventory_identification")
    @ManyToOne(optional = false)
    private OrderInventory orderInventory;
    @JoinColumn(name = "raw_materialscode")
    @ManyToOne(optional = false)
    private RawMaterials rawMaterials;
}