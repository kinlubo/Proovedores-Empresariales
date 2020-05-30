package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Company.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "branch_Office_Compan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchOfficeCompan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer nic;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private int phone;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private String direction;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City city;
    @JoinColumn(name = "company_id", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private Company company;
}
