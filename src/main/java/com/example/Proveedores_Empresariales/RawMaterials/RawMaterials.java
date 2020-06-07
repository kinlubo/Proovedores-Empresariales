package com.example.Proveedores_Empresariales.RawMaterials;

import com.example.Proveedores_Empresariales.Product.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "raw_materials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterials {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer code;
    @Basic(optional = false)
    @Column(name = "raw_material_type")
    private int rawMaterialType;
    @Basic(optional = false)
    @Column(name = "measurement_code")
    private int measurementCode;
    @Basic(optional = false)
    private String name;
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "max_stock")
    private BigDecimal maxStock;
    @Basic(optional = false)
    @Column(name = "minimum_stock")
    private BigDecimal minimumStock;
    @Basic(optional = false)
    @Column(name = "state_code")
    private int stateCode;
}
