package com.example.Proveedores_Empresariales.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

    @Entity
    @Table(catalog = "proveedores", schema = "public")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class Product implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        private Integer id;
        @Basic(optional = false)
        private String presentation;
        @Basic(optional = false)
        private int quantity;
       // @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
       // private Collection<ProductService> productServiceCollection;


    }


