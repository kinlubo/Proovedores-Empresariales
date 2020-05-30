package com.example.Proveedores_Empresariales.OrdersPurchase;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.DetailOrdersPurchase.DetailOrdersPurchase;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import com.example.Proveedores_Empresariales.WayToPay.WayToPay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "orders_purchase", catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersPurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_order")
    private Date dateOrder;
    @Basic(optional = false)
    @Column(name = "date_delivery")
    private Date dateDelivery;
    @JoinColumn(name = "way_to_pay_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WayToPay wayToPay;
    @JoinColumn(name = "branchoffice_company_nic", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private BranchOfficeCompan branchOfficeCompan;
    @JoinColumn(name = "petitions_inventory_identification", referencedColumnName = "identification")
    @ManyToOne(optional = false)
    private OrderInventory orderInventory;
}