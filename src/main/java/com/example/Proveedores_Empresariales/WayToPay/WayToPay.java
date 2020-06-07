package com.example.Proveedores_Empresariales.WayToPay;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "way_to_pay")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WayToPay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String name;
}
