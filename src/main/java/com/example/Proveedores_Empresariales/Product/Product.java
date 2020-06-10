package com.example.Proveedores_Empresariales.Product;

import com.sun.istack.Nullable;
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
        @GeneratedValue
        @Basic(optional = false)
        private Integer id;
        @Basic(optional = true)
        private String presentation;
        @Basic(optional = true)
        private int quantity;
    }


