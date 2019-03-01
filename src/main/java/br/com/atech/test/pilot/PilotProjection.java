package br.com.atech.test.pilot;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import br.com.atech.test.flight.Flight;

@Projection(name = "pilot", types = { Pilot.class })
public interface PilotProjection {

    String getBrevete();

    String getFirstName();

    String getLastName();
    
    @Value("#{target.firstName} #{target.lastName}") 
    String getFullName();

    List<Flight> getFlights();
}
