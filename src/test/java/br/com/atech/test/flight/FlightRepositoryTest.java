package br.com.atech.test.flight;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryTest {
	
	@Autowired
	FlightRepository repository;
	
	@Test
    public void findOne() {
		Flight flight = this.repository.findOne(1L);
        Assert.assertEquals("qwertyuiop", flight.getFlightCode());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Flight> flights = this.repository.findAll(pageable);
        Assert.assertEquals(2, flights.getTotalElements());
    }
	
	@Test
    public void findByFlightCodeContaining() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Flight> flights = this.repository.findByFlightCodeContaining("qw", pageable);
        Assert.assertEquals(1, flights.getTotalElements());
        Assert.assertEquals("qwertyuiop", flights.iterator().next().getFlightCode());
    }
	
}