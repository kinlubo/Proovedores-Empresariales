package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.Product.Product;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWholesaler;
import com.example.Proveedores_Empresariales.Service.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = true)
    private String name;
    @Basic(optional = true)
    private int value;
    @Basic(optional = true)
    @Column(name = "unit_measure",nullable = true)
    private int unitMeasure;
    @JoinColumn(name = "service_id",nullable = true,updatable = true)
    @OneToOne(optional = true)
    private Service service;
    @JoinColumn(name = "product_id",nullable = true,updatable = true)
    @OneToOne(optional = true)
    private Product product;
    @JoinColumn(name = "branchoffice_company_nic")
    @ManyToOne(optional = true)
    private BranchOfficeCompan branchOfficeCompan;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "productWholesaler")
    private Collection<ProductService> productServiceCollection;*/
}
