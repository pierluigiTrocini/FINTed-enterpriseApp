package it.unical.demacs.pierluigi.fintedapp.data.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Address {
    private String route;
    private String number;
    private String city;
}