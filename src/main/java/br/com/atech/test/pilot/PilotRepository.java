package br.com.atech.test.pilot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PilotRepository extends PagingAndSortingRepository<Pilot, String> {}
