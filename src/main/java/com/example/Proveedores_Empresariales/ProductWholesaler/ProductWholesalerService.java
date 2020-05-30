package com.example.Proveedores_Empresariales.ProductWholesaler;

import java.util.List;

@org.springframework.stereotype.Service
public interface ProductWholesalerService {

    public ProductWholesaler save (ProductWholesaler productWholesaler);

    public List<ProductWholesaler> getAll();

    public ProductWholesaler getById(ProductWhoPK productWhoPK);

    public ProductWholesaler update(ProductWholesaler productWholesaler);

    public void delete (ProductWholesaler productWholesaler);
}
