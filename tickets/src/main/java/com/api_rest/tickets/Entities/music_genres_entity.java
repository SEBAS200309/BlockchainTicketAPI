package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "music_genres")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class music_genres_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("genre_name")
    @NotBlank(message = "Music gender name is required")
    @Size(min = 3, max = 100, message = "Music gender name must be between 3 and 100 characters")
    @Column(name="name")
    private String genreName;

}
