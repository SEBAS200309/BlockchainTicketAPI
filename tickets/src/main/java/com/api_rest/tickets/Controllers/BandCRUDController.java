package com.api_rest.tickets.Controllers;

import com.api_rest.tickets.DTO.BandDTO;
import com.api_rest.tickets.Entities.band_entity;
import com.api_rest.tickets.Services.BandCRUDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api_rest/v1/WEB3_Ticketer/BandCRUD")
@Validated
public class BandCRUDController {

    @Autowired
    private BandCRUDService bandcrudservice;

    //Manejo de errores
    private ResponseEntity<?> handleRequest(Supplier<Page<?>> supplier) {
        try {
            return ResponseEntity.ok(supplier.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    //Buscar banda por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBandById(@PathVariable Integer id) {
        return bandcrudservice.getBandById(id);
    }

    //Crear nueva banda
    @PostMapping
    public ResponseEntity<?> insertBand (@Valid @RequestBody BandDTO band){
        return bandcrudservice.addBand(band);
    }
    //Actualizar banda
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBand (@PathVariable Integer id, @Valid @RequestBody band_entity band){
        return bandcrudservice.updateBand(id,band);
    }
    //Borrar banda
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBand (@PathVariable Integer id){
        return bandcrudservice.deleteBand(id);
    }
    //Buscar banda por nombre
    @GetMapping("/search")
    public ResponseEntity<?> searchBands(@RequestParam("name") String name, Pageable pageable) {
        return bandcrudservice.searchBandsByName(name, pageable);
    }
}
