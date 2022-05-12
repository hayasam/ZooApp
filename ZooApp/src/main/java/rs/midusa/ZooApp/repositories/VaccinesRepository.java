package rs.midusa.ZooApp.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.midusa.ZooApp.entities.Vaccine;

public interface VaccinesRepository extends CrudRepository<Vaccine, Integer> {

	
	
}
