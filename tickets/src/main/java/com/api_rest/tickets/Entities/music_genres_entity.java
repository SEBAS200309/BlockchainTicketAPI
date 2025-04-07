package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "music_genres")
@Data

public class music_genres_entity {

    @Id
    private Integer id;

    @JsonProperty("genre_name")
    @NotBlank(message = "Music gender name is required")
    @Size(min = 3, max = 100, message = "Music gender name must be between 3 and 100 characters")
    private String Name;

}
