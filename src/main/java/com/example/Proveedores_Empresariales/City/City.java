package com.example.Proveedores_Empresariales.City;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.Departament.Departament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.cityPK.id = :id"),
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
        @NamedQuery(name = "City.findByDepartamentId", query = "SELECT c FROM City c WHERE c.cityPK.departamentId = :departamentId")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CityPK cityPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "departament_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departament departament;

    public City() {
    }

    public City(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public City(CityPK cityPK, int code, String name) {
        this.cityPK = cityPK;
        this.name = name;
    }

    public City(int id, int departamentId) {
        this.cityPK = new CityPK(id, departamentId);
    }

    public CityPK getCityPK() {
        return cityPK;
    }

    public void setCityPK(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityPK != null ? cityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityPK == null && other.cityPK != null) || (this.cityPK != null && !this.cityPK.equals(other.cityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadesda.City[ cityPK=" + cityPK + " ]";
    }

}