package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "countries")
@Data

public class countries_entity {

    @Id
    private Integer id;

    @JsonProperty("country_name")
    @NotBlank(message = "Country name is required")
    @Size(min = 4, max = 100, message = "Country name must be between 3 and 100 characters")
    private String Name;
}
