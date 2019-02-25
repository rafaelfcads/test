package br.com.atech.test.pilot;

import br.com.atech.test.flight.Flight;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "pilot", types = { Pilot.class })
public interface PilotProjection {

    String getBrevete();

    String getFirstName();

    String getLastName();

    List<Flight> getFlights();
}
