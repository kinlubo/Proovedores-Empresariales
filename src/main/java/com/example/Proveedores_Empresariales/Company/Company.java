package com.example.Proveedores_Empresariales.Company;

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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer nic;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private int phone;
    @Basic(optional = false)
    private String direction;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Collection<BranchOfficeCompan> branchOfficeCompanCollection;
     */

}

