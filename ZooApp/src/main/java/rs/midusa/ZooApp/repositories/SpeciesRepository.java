package rs.midusa.ZooApp.repositories;

import org.springframework.data.repository.CrudRepository;

import rs.midusa.ZooApp.entities.Specie;

public interface SpeciesRepository extends CrudRepository<Specie, Integer>{

}
