package br.com.atech.test.flight;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = FlightProjection.class)
public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {}

