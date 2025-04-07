package com.api_rest.tickets.Services;

import com.api_rest.tickets.Entities.*;
import com.api_rest.tickets.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GettAllServices {
    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private MusicGenresRepository musicGenreRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private StadiumsRepository stadiumRepository;

    @Autowired
    private CitiesRepository cityRepository;

    @Autowired
    private CountriesRepository countryRepository;

    @Autowired
    private TicketCategoriesRepository ticketCategoryRepository;

    // Metodos getAll de cada entidad
    public Page<band_entity> getAllBands(Pageable pageable) {
        return bandRepository.findAll(pageable);
    }

    public Page<music_genres_entity> getAllMusicGenres(Pageable pageable) {
        return musicGenreRepository.findAll(pageable);
    }

    public Page<tickets_entity> getAllTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    public Page<stadiums_entity> getAllStadiums(Pageable pageable) {
        return stadiumRepository.findAll(pageable);
    }

    public Page<cities_entity> getAllCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    public Page<countries_entity> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public Page<ticket_categories_entity> getAllTicketCategories(Pageable pageable) {
        return ticketCategoryRepository.findAll(pageable);
    }
}
