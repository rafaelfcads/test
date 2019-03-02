package br.com.atech.test.pilot;

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
public class PilotRepositoryTest {
	
	@Autowired
	PilotRepository repository;
	
	@Test
    public void findOne() {
		Pilot pilot = this.repository.findOne("TAHAvj152W");
        Assert.assertEquals("Alberto", pilot.getFirstName());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Pilot> pilots = this.repository.findAll(pageable);
        Assert.assertEquals(3, pilots.getTotalElements());
    }
	
}