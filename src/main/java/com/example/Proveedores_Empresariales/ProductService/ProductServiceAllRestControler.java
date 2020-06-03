package com.example.Proveedores_Empresariales.ProductService;

import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompan;
import com.example.Proveedores_Empresariales.BranchOfficeCompan.BranchOfficeCompanService;
import com.example.Proveedores_Empresariales.Product.Product;
import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterial;
import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterialPK;
import com.example.Proveedores_Empresariales.ProductService_RawMaterial.ProductService_RawMaterialService;
import com.example.Proveedores_Empresariales.ProductWholesaler.ProductWholesalerService;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterials;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterialsService;
import com.example.Proveedores_Empresariales.Service.Service;
import com.example.Proveedores_Empresariales.Service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/v1/productserviceall")
@RestController
public class ProductServiceAllRestControler {
    private ProductServiceService productServiceService;
    private ServiceService serviceService;
    private com.example.Proveedores_Empresariales.Product.ProductService productService;
    private BranchOfficeCompanService branchOfficeCompanService;
    private ProductWholesalerService productWholesalerService ;
    private RawMaterialsService rawMaterialsService;
    private ProductService_RawMaterialService productService_rawMaterialService;
    
    public ProductServiceAllRestControler(ProductServiceService productServiceService, ServiceService serviceService,
                                            com.example.Proveedores_Empresariales.Product.ProductService productService, BranchOfficeCompanService branchOfficeCompanService, ProductWholesalerService productWholesalerService, RawMaterialsService rawMaterialsService, ProductService_RawMaterialService productService_rawMaterialService) {
        this.productServiceService = productServiceService;
        this.serviceService = serviceService;
        this.productService = productService;
        this.branchOfficeCompanService = branchOfficeCompanService;
        this.productWholesalerService = productWholesalerService;
        this.rawMaterialsService = rawMaterialsService;
        this.productService_rawMaterialService = productService_rawMaterialService;
    }


    public Service serviceId(Integer id)
    {
        Service service = null;
        List<Service> serviceList = serviceService.getAll();
        for (int i = 0; serviceList.size()>i; i++)
        {
            if(serviceList.get(i).getId()==id)
            {
                service = serviceList.get(i);
            }
        }
        return  service;
    }
    public Product productId(Integer id)
    {
        Product product = null;
        List<Product> productList = productService.getAll();
        for (int i = 0; productList.size()>i; i++)
        {
            if(productList.get(i).getId()==id)
            {
                product = productList.get(i);
            }
        }
        return  product;
    }
    public BranchOfficeCompan branchOfficeCompanId(Integer id)
    {
        BranchOfficeCompan branchOfficeCompan = null;
        List<BranchOfficeCompan> branchOfficeCompans = branchOfficeCompanService.getAll();
        for (int i = 0; branchOfficeCompans.size()>i; i++)
        {
            if(branchOfficeCompans.get(i).getNic()==id)
            {
                branchOfficeCompan = branchOfficeCompans.get(i);
            }
        }
        return  branchOfficeCompan;
    }

    public RawMaterials rawMaterials (String name)
    {
        RawMaterials rawMaterials = null;
        List<RawMaterials> rawMaterialsList = this.rawMaterialsService.getAll();
        for (int i = 0; rawMaterialsList.size()>i;i++)
        {
            if(rawMaterialsList.get(i).getName().equalsIgnoreCase(name))
            {
                rawMaterials = rawMaterialsList.get(i);
            }
        }

        return rawMaterials;
    }

    @PostMapping
    public ResponseEntity<ProductService> save(@RequestBody Integer id, int code, String name, int value, int unitMeasure,
                                               Integer serviceId, Integer productId, Integer branchOfficeCompanId, String presentationProduct, int quantityProduct, String planService, Date durationService)
    {
        int varid = this.serviceService.getAll().size()+1;
        int varidpr = this.productService.getAll().size()+1;
        if  (serviceId(serviceId)==null)
        {

            Service service = new Service(varid,planService,durationService);
            this.serviceService.save(service);
        }
        if(productId(productId)==null)
        {
            Product product = new Product(varidpr,presentationProduct,quantityProduct);
            this.productService.save(product);
        }
        int varRaw = rawMaterials(name).getCode();
        ProductService_RawMaterialPK productService_rawMaterialPK = new ProductService_RawMaterialPK(id,varRaw);
        ProductService_RawMaterial productService_rawMaterial = new ProductService_RawMaterial(productService_rawMaterialPK);
        this.productService_rawMaterialService.save(productService_rawMaterial);
        Service service = serviceId(serviceId);
        Product product = productId(productId);
        BranchOfficeCompan branchOfficeCompan = branchOfficeCompanId(branchOfficeCompanId);
        ProductService productService  = new ProductService(id,code,name,value,unitMeasure,service,product,branchOfficeCompan);
        return ResponseEntity.ok().body(this.productServiceService.save(productService));
    }
}
