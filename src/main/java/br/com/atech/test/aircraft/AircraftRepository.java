package br.com.atech.test.aircraft;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AircraftRepository extends PagingAndSortingRepository<Aircraft, String> {}
