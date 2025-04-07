package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table  (name = "stadiums")
@Data

public class stadiums_entity {

    @Id
    private Integer id;

    @JsonProperty("stadium_name")
    @NotBlank(message = "Stadium name is required")
    @Size(min = 3, max = 100, message = "Stadium name must be between 3 and 100 characters")
    private String Name;

    @JsonProperty("city_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private cities_entity city_id;

}
