package com.example.Proveedores_Empresariales.DetailOrdersPurchase;

import com.example.Proveedores_Empresariales.OrdersPurchase.OrdersPurchase;
import com.example.Proveedores_Empresariales.ProductService.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "detail_orders_purchase", catalog = "proveedores", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrdersPurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "date_maximun_delivery_order")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaximunDeliveryOrder;
    @Basic(optional = false)
    @Column(name = "value_unitary")
    private int valueUnitary;
    @Basic(optional = false)
    @Column(name = "value_total")
    private int valueTotal;
    @JoinColumn(name = "product_service_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductService productService;
    @JoinColumn(name = "order_purchase_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrdersPurchase ordersPurchase;
}