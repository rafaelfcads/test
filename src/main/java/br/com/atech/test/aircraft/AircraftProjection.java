package br.com.atech.test.aircraft;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "aircraft", types = { Aircraft.class })
public interface AircraftProjection {

    String getSerialNumber();

    String getModel();
}
