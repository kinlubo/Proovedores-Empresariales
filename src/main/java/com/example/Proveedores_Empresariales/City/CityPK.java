package com.example.Proveedores_Empresariales.City;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author judaz
 */
@Embeddable
public class CityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "departament_id")
    private int departamentId;

    public CityPK() {
    }

    public CityPK(int id, int departamentId) {
        this.id = id;
        this.departamentId = departamentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) departamentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityPK)) {
            return false;
        }
        CityPK other = (CityPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.departamentId != other.departamentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadesda.CityPK[ id=" + id + ", departamentId=" + departamentId + " ]";
    }

}