package br.com.atech.test.airport;

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
public class AirportRepositoryTest {
	
	@Autowired
	AirportRepository repository;
	
	@Test
    public void findOne() {
		Airport airport = this.repository.findOne("GRU");
        Assert.assertEquals("SBGR", airport.getIcao());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Airport> airports = this.repository.findAll(pageable);
        Assert.assertEquals(8, airports.getTotalElements());
    }
	
}