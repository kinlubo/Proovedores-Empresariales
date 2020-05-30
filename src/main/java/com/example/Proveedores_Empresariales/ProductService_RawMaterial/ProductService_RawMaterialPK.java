/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author judaz
 */
@Embeddable
public class ProductService_RawMaterialPK implements Serializable {

    @Basic(optional = false)
    private int productoServiceId;
    @Basic(optional = false)
    @Column(name = "raw_Material")
    private int rawMaterialId;

    public ProductService_RawMaterialPK() {
    }

    public ProductService_RawMaterialPK(int productoServiceId, int rawMaterialId) {
        this.productoServiceId = productoServiceId;
        this.rawMaterialId = rawMaterialId;
    }

    public int getProductoServiceId() {
        return productoServiceId;
    }

    public void setProductoServiceId(int code) {
        this.productoServiceId = code;
    }

    public int getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(int quantityInitial) {
        this.rawMaterialId = quantityInitial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productoServiceId;
        hash += (int) rawMaterialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductService_RawMaterialPK)) {
            return false;
        }
        ProductService_RawMaterialPK other = (ProductService_RawMaterialPK) object;
        if (this.productoServiceId != other.productoServiceId) {
            return false;
        }
        if (this.rawMaterialId != other.rawMaterialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.ProductWholesalerPK[ code=" + productoServiceId + ", quantityInitial=" + rawMaterialId + " ]";
    }
    
}
