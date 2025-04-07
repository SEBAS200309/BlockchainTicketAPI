package com.api_rest.tickets.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BandDTO {

    @JsonProperty("band_name")
    @NotBlank(message = "Band name is required")
    @Size(min = 3, max = 100, message = "Band name must be between 3 and 100 characters")
    private String bandName;

    @JsonProperty("genre_id")
    @NotNull(message = "Genre ID is required")
    private Integer genreId;
    
}
