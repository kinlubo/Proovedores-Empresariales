package com.example.Proveedores_Empresariales.ProductWholesaler;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductWhoPK  implements Serializable {

    private int code;
    @Column(name = "quantity_initial")
    private int quantityInitial;

    public ProductWhoPK() {
    }

    public ProductWhoPK(int code, int quantityInitial) {
        this.code = code;
        this.quantityInitial = quantityInitial;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantityInitial() {
        return quantityInitial;
    }

    public void setQuantityInitial(int quantityInitial) {
        this.quantityInitial = quantityInitial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code;
        hash += (int) quantityInitial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductWhoPK)) {
            return false;
        }
        ProductWhoPK other = (ProductWhoPK) object;
        if (this.code != other.code) {
            return false;
        }
        if (this.quantityInitial != other.quantityInitial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProductWholesalerPK[ code=" + code + ", quantityInitial=" + quantityInitial + " ]";
    }
}
