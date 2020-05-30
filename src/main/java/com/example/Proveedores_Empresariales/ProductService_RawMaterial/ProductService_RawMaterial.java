package com.example.Proveedores_Empresariales.ProductService_RawMaterial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(catalog = "producservice_rawmaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductService_RawMaterial {
    @EmbeddedId
    private ProductService_RawMaterialPK productService_rawMaterialPK;
}
