package com.api_rest.tickets.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
@Data
public class tickets_entity {

    @Id
    private Integer id;

    @JsonProperty("band_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private band_entity band_id;

    @JsonProperty("stadium_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private stadiums_entity stadium_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @NotBlank(message = "Event date is required")
    private LocalDateTime event_date;

    @JsonProperty("category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ticket_categories_entity category_id;
}
