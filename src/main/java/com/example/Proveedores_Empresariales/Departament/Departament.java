package com.example.Proveedores_Empresariales.Departament;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Country.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departament")
    private Collection<City> cityCollection;
     */

    @ManyToOne(optional = false)
    private Country contry;



}
