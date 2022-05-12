package rs.midusa.ZooApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import rs.midusa.ZooApp.entities.Animal;
import rs.midusa.ZooApp.entities.Specie;
import rs.midusa.ZooApp.entities.Vaccine;

public interface AnimalsRepository extends CrudRepository<Animal, Integer>{

	List<Animal> findAllAnimalsByVaccines(Vaccine vaccine);
	List<Animal> findAllAnimalsBySpecie(Specie specie);
	List<Animal> findByMonthsOldGreaterThan(Integer monthsOld);
	List<Animal> findBySpecieIdOrderByMonthsOldDesc(Integer specieId);
	List<Animal> findByNameIgnoreCase(String name);
	
}
