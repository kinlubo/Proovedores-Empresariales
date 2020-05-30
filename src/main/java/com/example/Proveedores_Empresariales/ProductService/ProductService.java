package com.example.Proveedores_Empresariales.ProductService;

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
public class ProductService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int code;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private int value;
    @Basic(optional = false)
    @Column(name = "unit_measure")
    private int unitMeasure;
/*    @ManyToMany(mappedBy = "productServiceCollection")
    private Collection<RawMaterials> rawMaterialsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productService")
    private Collection<DetailOrdersPurchase> detailOrdersPurchaseCollection;
    @JoinColumn(name = "branchoffice_company_nic", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private BranchOfficeCompan branchOfficeCompan;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumns({
            @JoinColumn(name = "product_wholesaler_code", referencedColumnName = "code"),
            @JoinColumn(name = "product_wholesaler_quantity_inicial", referencedColumnName = "quantity_initial")})
    @ManyToOne(optional = false)
    private ProductWholesaler productWholesaler;
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Service service;*/

}
