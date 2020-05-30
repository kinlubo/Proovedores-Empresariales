package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.Departament.Departament;
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
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int code;
    @Basic(optional = false)
    private String name;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Collection<BranchOfficeCompan> branchOfficeCompanCollection;
     */
    @ManyToOne(optional = false)
    private Departament departament;

}