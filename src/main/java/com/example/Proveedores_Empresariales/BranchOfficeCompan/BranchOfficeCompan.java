package com.example.Proveedores_Empresariales.BranchOfficeCompan;

import com.example.Proveedores_Empresariales.City.City;
import com.example.Proveedores_Empresariales.Company.Company;
import com.example.Proveedores_Empresariales.OrdersPurchase.OrdersPurchase;
import com.example.Proveedores_Empresariales.Product.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "branch_office_compan")
@NamedQueries({
        @NamedQuery(name = "BranchOfficeCompan.findAll", query = "SELECT b FROM BranchOfficeCompan b"),
        @NamedQuery(name = "BranchOfficeCompan.findByNic", query = "SELECT b FROM BranchOfficeCompan b WHERE b.nic = :nic"),
        @NamedQuery(name = "BranchOfficeCompan.findByDirection", query = "SELECT b FROM BranchOfficeCompan b WHERE b.direction = :direction"),
        @NamedQuery(name = "BranchOfficeCompan.findByEmail", query = "SELECT b FROM BranchOfficeCompan b WHERE b.email = :email"),
        @NamedQuery(name = "BranchOfficeCompan.findByName", query = "SELECT b FROM BranchOfficeCompan b WHERE b.name = :name"),
        @NamedQuery(name = "BranchOfficeCompan.findByPhone", query = "SELECT b FROM BranchOfficeCompan b WHERE b.phone = :phone")})
public class BranchOfficeCompan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nic")
    private BigInteger nic;
    @Basic(optional = false)
    @Column(name = "direction")
    private String direction;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @JoinColumns({
            @JoinColumn(name = "departament_id", referencedColumnName = "departament_id"),
            @JoinColumn(name = "city_id", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private City city;
    @JoinColumn(name = "company_id", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private Company companyId;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "branchofficeCompanyNic")
    private List<OrdersPurchase> ordersPurchaseList;
    @OneToMany(mappedBy = "branchofficeCompanyNic")
    private List<ProductService> productServiceList;*/

    public BranchOfficeCompan() {
    }

    public BranchOfficeCompan(BigInteger nic) {
        this.nic = nic;
    }

    public BranchOfficeCompan(BigInteger nic, String direction, String email, String name, String phone) {
        this.nic = nic;
        this.direction = direction;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public BigInteger getNic() {
        return nic;
    }

    public void setNic(BigInteger nic) {
        this.nic = nic;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    /*public List<OrdersPurchase> getOrdersPurchaseList() {
        return ordersPurchaseList;
    }

    public void setOrdersPurchaseList(List<OrdersPurchase> ordersPurchaseList) {
        this.ordersPurchaseList = ordersPurchaseList;
    }

    public List<ProductService> getProductServiceList() {
        return productServiceList;
    }

    public void setProductServiceList(List<ProductService> productServiceList) {
        this.productServiceList = productServiceList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nic != null ? nic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchOfficeCompan)) {
            return false;
        }
        BranchOfficeCompan other = (BranchOfficeCompan) object;
        if ((this.nic == null && other.nic != null) || (this.nic != null && !this.nic.equals(other.nic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidadesda.BranchOfficeCompan[ nic=" + nic + " ]";
    }

}
