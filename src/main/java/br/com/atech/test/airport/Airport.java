package br.com.atech.test.airport;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(of = "iata")
@NoArgsConstructor
@RequiredArgsConstructor
public class Airport {

    @Id
    @NonNull
    private String iata;

    @NonNull
    private String icao;

    @NonNull
    private String name;

    @NonNull
    private String city;

    @NonNull
    private String country;
}
