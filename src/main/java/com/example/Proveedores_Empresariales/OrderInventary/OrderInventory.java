package com.example.Proveedores_Empresariales.OrderInventary;

import com.example.Proveedores_Empresariales.Orders.Orders;
import com.example.Proveedores_Empresariales.OrdersPurchase.OrdersPurchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "order_inventory", catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer identification;
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    private Date date;
    @Basic(optional = false)
    @Column(name = "number_order_inventory")
    private int numberOrderInventory;
    @Basic(optional = false)
    private String responsable;
    @Basic(optional = false)
    @Column(name = "date_maximum_delivery_inventory")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaximumDeliveryInventory;
}