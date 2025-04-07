package com.api_rest.tickets.Controllers;

import com.api_rest.tickets.Services.GettAllServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api_rest/v1/WEB3_Ticketer")
@Validated
public class ticket_web3_controller {

    @Autowired
    private GettAllServices getallservices;
    //Manejo de errores
    private ResponseEntity<?> handleRequest(Supplier<Page<?>> supplier) {
        try {
            return ResponseEntity.ok(supplier.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    //metodo para crear el paginado
    private Pageable buildPageable(int page, int size, String sort) {
        String[] sortParams = sort.split(",");
        if (sortParams.length != 2) {
            throw new IllegalArgumentException("El parámetro 'sort' debe tener el formato 'campo,direccion'.");
        }

        String sortField = sortParams[0];
        String direction = sortParams[1];

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        return PageRequest.of(page, size, Sort.by(sortDirection, sortField));
    }

    @GetMapping("/bands")
    public ResponseEntity<?> getAllBands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "band_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllBands(pageable));
    }

    @GetMapping("/music-genres")
    public ResponseEntity<?> getAllMusicGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "genre_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllMusicGenres(pageable));
    }

    @GetMapping("/tickets")
    public ResponseEntity<?> getAllTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "event_date,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllTickets(pageable));
    }

    @GetMapping("/stadiums")
    public ResponseEntity<?> getAllStadiums(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "stadium_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllStadiums(pageable));
    }

    @GetMapping("/cities")
    public ResponseEntity<?> getAllCities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "city_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllCities(pageable));
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "country_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllCountries(pageable));
    }

    @GetMapping("/ticket-categories")
    public ResponseEntity<?> getAllTicketCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "category_name,asc") String sort) {
        Pageable pageable = buildPageable(page, size, sort);
        return handleRequest(() -> getallservices.getAllTicketCategories(pageable));
    }
}
