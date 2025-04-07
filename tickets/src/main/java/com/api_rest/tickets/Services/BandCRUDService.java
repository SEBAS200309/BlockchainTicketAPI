package com.api_rest.tickets.Services;

import com.api_rest.tickets.DTO.BandDTO;
import com.api_rest.tickets.Entities.band_entity;
import com.api_rest.tickets.Entities.music_genres_entity;
import com.api_rest.tickets.Repositories.BandRepository;
import com.api_rest.tickets.Repositories.MusicGenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BandCRUDService {

    private final BandRepository bandRepository;
    private final MusicGenresRepository musicGenresRepository;

    @Autowired
    public BandCRUDService(BandRepository bandRepository, MusicGenresRepository musicGenresRepository) {
        this.bandRepository = bandRepository;
        this.musicGenresRepository = musicGenresRepository;
    }

    // Crear una nueva banda
    public ResponseEntity<?> addBand(BandDTO bandDTO) {
        Page<band_entity> existingBands = bandRepository.findAllByBandNameContaining(bandDTO.getBandName(), Pageable.unpaged());
        if (existingBands.getTotalElements() > 0) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status",
                            String.format("Band already exists with %d coincidences.", existingBands.getTotalElements())),
                    HttpStatus.CONFLICT);
        }
        Optional<music_genres_entity> optionalGenre = musicGenresRepository.findById(bandDTO.getGenreId());
        if (!optionalGenre.isPresent()) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status", String.format("Genre with ID %d not found.", bandDTO.getGenreId())),
                    HttpStatus.NOT_FOUND);
        }
        //Crear bandToAdd entity atraves del DTO
        band_entity bandToAdd = new band_entity();
        System.out.println("Nombre banda: "+ bandDTO.getBandName());
        bandToAdd.setBandName(bandDTO.getBandName());

        bandToAdd.setGenre_id(optionalGenre.get());

        //impresion de bandToAdd
        System.out.println(bandToAdd);

        // Asignar la entidad de género validada
        band_entity savedBand = bandRepository.save(bandToAdd);
        System.out.println("Nombre banda en entidad guardada: "+ savedBand.getBandName());
        // Crear respuesta del metodo
        Map<String, Object> response = new HashMap<>();
        response.put("Status", String.format("Added Band with ID %d", savedBand.getId()));
        response.put("band", savedBand);
        //Respuesta
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    // Actualizar una banda existente
    public ResponseEntity<?> updateBand(Integer id, band_entity bandToUpdate) {
        Optional<band_entity> optionalBand = bandRepository.findById(id);
        if (!optionalBand.isPresent()) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status", String.format("Band with ID %d not found.", id)),
                    HttpStatus.NOT_FOUND);
        }
        band_entity existingBand = optionalBand.get();
        // Actualizar el nombre
        existingBand.setBandName(bandToUpdate.getBandName());

        // Si se envía un nuevo género, validarlo
        if (bandToUpdate.getGenre_id() != null && bandToUpdate.getGenre_id().getId() != null) {
            Integer genreId = bandToUpdate.getGenre_id().getId();
            Optional<music_genres_entity> optionalGenre = musicGenresRepository.findById(genreId);
            if (!optionalGenre.isPresent()) {
                return new ResponseEntity<>(
                        Collections.singletonMap("Status", String.format("Genre with ID %d not found.", genreId)),
                        HttpStatus.NOT_FOUND);
            }
            existingBand.setGenre_id(optionalGenre.get());
        }
        band_entity bandUpdated = bandRepository.save(existingBand);
        // Crear respuesta del metodo
        Map<String, Object> response = new HashMap<>();
        response.put("Status", String.format("Added Band with ID %d", bandUpdated.getId()));
        response.put("band", bandUpdated);
        return ResponseEntity.ok(response);
    }

    // Eliminar una banda por ID
    public ResponseEntity<?> deleteBand(Integer id) {
        Optional<band_entity> optionalBand = bandRepository.findById(id);
        if (!optionalBand.isPresent()) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status", String.format("Band with ID %d doesn't exist.", id)),
                    HttpStatus.NOT_FOUND);
        }
        bandRepository.deleteById(id);
        return ResponseEntity.ok(
                Collections.singletonMap("Status", String.format("Deleted Band with ID %d", id)));
    }

    // Obtener una banda por ID
    public ResponseEntity<?> getBandById(Integer id) {
        Optional<band_entity> optionalBand = bandRepository.findById(id);
        if (!optionalBand.isPresent()) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status", String.format("Band with ID %d not found.", id)),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(optionalBand.get());
    }

    //Obtener banda por nombre
    public ResponseEntity<?> searchBandsByName(String bandName, Pageable pageable) {
        Page<band_entity> bands = bandRepository.findAllByBandNameContaining(bandName, pageable);

        if (bands.isEmpty()) {
            return new ResponseEntity<>(
                    Collections.singletonMap("Status", String.format("No bands found with name containing '%s'", bandName)),
                    HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(bands);
    }
}
