package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table (name = "ticket_categories")
@Data
public class ticket_categories_entity {
    @Id
    private Integer id;

    @JsonProperty("category_name")
    @NotBlank(message = "Ticket Category name is required")
    @Size(min = 3, max = 100, message = "Ticket Category name must be between 3 and 100 characters")
    private String Name;

    @NotBlank(message = "Base price is required")
    @Digits(integer = 8, fraction = 2, message = "The price must have up to 8 whole digits and 2 decimal places")
    @DecimalMin(value = "0.00", inclusive = true, message = "The price cant be negative")
    private BigDecimal base_price;
}
