package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "bands")
@Data
public class band_entity {

    @Id
    private Integer id;

    @JsonProperty("band_name")
    @NotBlank(message = "Band name is required")
    @Size(min = 3, max = 100, message = "Band name must be between 3 and 100 characters")
    private String band_name;

    @JsonProperty("genre_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private music_genres_entity genre_id;
}
