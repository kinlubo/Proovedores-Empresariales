package com.example.Proveedores_Empresariales.DetailPetition;

import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventaryService;
import com.example.Proveedores_Empresariales.OrderInventary.OrderInventory;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterials;
import com.example.Proveedores_Empresariales.RawMaterials.RawMaterialsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/detailpetition")
@RestController
public class DetailPetitionRestController {

    private DetailPetitionService detailPetitionService;
    private RawMaterialsService rawMaterialsService;
    private OrderInventaryService orderInventaryService;

    public DetailPetitionRestController(DetailPetitionService detailPetitionService, RawMaterialsService rawMaterialsService, OrderInventaryService orderInventaryService) {
        this.detailPetitionService = detailPetitionService;
        this.rawMaterialsService = rawMaterialsService;
        this.orderInventaryService = orderInventaryService;
    }

    public RawMaterials rawMaterialsId(Integer id)
    {
        RawMaterials rawMaterials = null;
        List<RawMaterials> rawMaterialsList = rawMaterialsService.getAll();
        for (int i = 0; rawMaterialsList.size()>i; i++)
        {
            if(rawMaterialsList.get(i).getCode()==id)
            {
                rawMaterials = rawMaterialsList.get(i);
            }
        }
        return rawMaterials;
    }

    public OrderInventory orderInventoryId(Integer id)
    {
        OrderInventory orderInventory = null;
        List<OrderInventory> orderInventories = orderInventaryService.getAll();
        for (int i = 0; orderInventories.size()>i; i++)
        {
            if(orderInventories.get(i).getIdentification()==id)
            {
                orderInventory = orderInventories.get(i);
            }
        }
        return orderInventory;
    }
    @PostMapping
    public ResponseEntity<DetailPetition> save(@RequestBody DetailPetition detailPetition)
    {
        return ResponseEntity.ok().body(this.detailPetitionService.save(detailPetition));
    }

    @GetMapping
    public ResponseEntity <List<DetailPetition>> getAll()
    {
        return ResponseEntity.ok().body(this.detailPetitionService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<DetailPetition>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.detailPetitionService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<DetailPetition> update(@PathVariable("identificacion")Integer id, @RequestBody DetailPetition detailPetition) {

        return new ResponseEntity<>(this.detailPetitionService.update(id,detailPetition), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        DetailPetition departament= this.detailPetitionService.getById(identificacion);
        if ( departament!= null) {
            this.detailPetitionService.delete(departament);
        }
    }
}
