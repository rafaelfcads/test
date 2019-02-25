package br.com.atech.test.airport;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "airport", types = { Airport.class })
public interface AirportProjection {

    String getIata();

    String getIcao();

    String getName();

    String getCity();

    String getCountry();
}
