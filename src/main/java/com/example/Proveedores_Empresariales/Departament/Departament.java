package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Country.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "departament")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country country;



}
