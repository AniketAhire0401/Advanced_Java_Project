package com.flightreservation.flightservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "flight")
public class FlightEntity
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String airline;
	    @NotBlank(message = "departureCity is mandatory")
	    @Email(message = "departureCity should be valid")
	    private String departureCity;
	    private String arrivalCity;
	    private double price;
}
