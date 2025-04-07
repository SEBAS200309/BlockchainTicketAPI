package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "cities")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class cities_entity {

    @Id
    private Integer id;

    @JsonProperty("city_name")
    @NotBlank(message = "City name is required")
    @Size(min = 3, max = 100, message = "City name must be between 3 and 100 characters")
    @Column(name = "name")
    private String cityName;

    @JsonProperty("country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private countries_entity country_id;

}
