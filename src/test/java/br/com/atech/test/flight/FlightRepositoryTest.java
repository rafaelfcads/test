package br.com.atech.test.flight;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryTest {
	
	@Autowired
	FlightRepository repository;
	
	@Test
    public void list() {
        Iterable<Flight> flights = this.repository.findAll();
        Assert.assertEquals(2, flights.spliterator().estimateSize());
    }
	
}