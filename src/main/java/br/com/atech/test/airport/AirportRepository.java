package br.com.atech.test.airport;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AirportRepository extends PagingAndSortingRepository<Airport, String> {}
