package br.com.atech.test.flight;

import br.com.atech.test.aircraft.AircraftProjection;
import br.com.atech.test.airport.AirportProjection;
import br.com.atech.test.pilot.PilotProjection;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "flight", types = { Flight.class })
public interface FlightProjection {

    Long getId();

    Date getDepartDate();

    Date getArriveDate();

    AircraftProjection getAircraft();

    PilotProjection getPilot();

    String getStatus();

    AirportProjection getDepart();

    AirportProjection getArrive();
}
