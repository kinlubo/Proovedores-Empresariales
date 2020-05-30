package com.example.Proveedores_Empresariales.Orders;

import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
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
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer code;
    @Column(name = "branch_office")
    private int branchOffice;
    @Basic(optional = false)
    @Column(name = "state_code")
    private int stateCode;
    @JoinColumn(name = "order_inventory")
    @OneToOne(optional = false)
    private OrderInventory orderInventory;
}