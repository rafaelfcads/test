package br.com.atech.test.aircraft;

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
public class AircraftRepositoryTest {
	
	@Autowired
	AircraftRepository repository;
	
	@Test
    public void findOne() {
		Aircraft aircraft = this.repository.findOne("1111111111");
        Assert.assertEquals("Phenom 100", aircraft.getModel());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Aircraft> aircrafts = this.repository.findAll(pageable);
        Assert.assertEquals(5, aircrafts.getTotalElements());
    }
	
}