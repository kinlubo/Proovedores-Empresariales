package com.example.Proveedores_Empresariales.RawMaterials;

import com.example.Proveedores_Empresariales.Country.Country;
import com.example.Proveedores_Empresariales.Country.CountryService;
import com.example.Proveedores_Empresariales.Departament.Departament;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("api/v1/rawmaterials")
@RestController
public class RawMaterialsRestController {

    private RawMaterialsService rawMaterialsService;

    public RawMaterialsRestController(RawMaterialsService rawMaterialsService) {
        this.rawMaterialsService = rawMaterialsService;
    }

    @PostMapping
    public ResponseEntity<RawMaterials> save(@RequestBody Integer code, int type, int measurement_code, String name, String description, BigDecimal max , BigDecimal minimum,int state_code)
    {
        RawMaterials rawMaterials  = new RawMaterials(code,type,measurement_code,name,description,max,minimum,state_code);
        return ResponseEntity.ok().body(this.rawMaterialsService.save(rawMaterials));
    }

    @GetMapping
    public ResponseEntity <List<RawMaterials>> getAll()
    {
        return ResponseEntity.ok().body(this.rawMaterialsService.getAll());
    }

    @GetMapping ( path = "/{id}")
    public ResponseEntity<RawMaterials>getById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok().body(this.rawMaterialsService.getById(id));
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Actividades", notes = "Servicio para actualizar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades actualizado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public ResponseEntity<RawMaterials> update(@PathVariable("identificacion")Integer code, int type, int measurement_code,
                                               String name, String description, BigDecimal max , BigDecimal minimum,int state_code) {

        RawMaterials rawMaterials= this.rawMaterialsService.getById(code);
        if ( rawMaterials== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            rawMaterials.setName(name);
            rawMaterials.setRawMaterialType(type);
            rawMaterials.setMeasurementCode(measurement_code);
            rawMaterials.setName(name);
            rawMaterials.setDescription(description);
            rawMaterials.setMaxStock(max);
            rawMaterials.setMinimumStock(minimum);
            rawMaterials.setStateCode(state_code);


        }
        return new ResponseEntity<>(this.rawMaterialsService.update(rawMaterials), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Actividades", notes = "Servicio para eliminar un Actividades")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Actividades eliminado correctamente"),
            @ApiResponse(code = 404, message = "Programa no encontrado") })
    public void remove(@PathVariable("identificacion") int identificacion) {

        RawMaterials rawMaterials= this.rawMaterialsService.getById(identificacion);
        if ( rawMaterials!= null) {
            this.rawMaterialsService.delete(rawMaterials);
        }
    }
}
