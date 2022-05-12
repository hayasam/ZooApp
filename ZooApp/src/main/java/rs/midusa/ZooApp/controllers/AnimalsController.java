package rs.midusa.ZooApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rs.midusa.ZooApp.entities.Animal;
import rs.midusa.ZooApp.entities.Specie;
import rs.midusa.ZooApp.entities.Vaccine;
import rs.midusa.ZooApp.repositories.AnimalsRepository;

@RestController
public class AnimalsController {

	
	
	
	@Autowired
	private AnimalsRepository animalsRepository;
	
	
	//GET ALL
	@GetMapping("/animals")
	public List<Animal> getAllAnimals(){
		
		return (List<Animal>)animalsRepository.findAll();
	}
	
	// GET ONE BY ID
	@GetMapping("/animals/{id}")
	public Animal getAnimalById(@PathVariable int id){
		return (Animal)animalsRepository.findById(id).orElse(null);
	}
	
	// CREATE NEW ANIMAL
	@PostMapping("/animals")
	public Animal createAnimal( @RequestBody Animal newAnimal) {
		
		return (Animal)animalsRepository.save(newAnimal);
	}
	
	// UPDATE CURRENT ANIMAL
	@PutMapping("/animals/{id}")
	public Animal updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal ) {
		
		return (Animal) animalsRepository.save(newAnimal); 
		
	}
	
	// DELETE ANIMAL
	@DeleteMapping("/animals/{id}")
	public void deleteAnimal(@PathVariable int id) {
		animalsRepository.deleteById(id);
	}
	
	// COUNT
	@GetMapping("animals/count")
	public Integer countAnimals() {
		return (int) animalsRepository.count();
	}
	
	
	// GET ALL ANIMALS BY VACCINE 
	 @GetMapping("/animals/vaccines")
	public List<Animal> getAnimalsByVaccine(@RequestBody Vaccine vaccine){
		return (List<Animal>)animalsRepository.findAllAnimalsByVaccines(vaccine);
	}
	
	
	 // GET ALL ANIMALS BY SPECIE
	 @GetMapping("/animals/specie")
	 public List<Animal> getAnimalsBySpecie(@RequestBody Specie specie){
		return (List<Animal>)animalsRepository.findAllAnimalsBySpecie(specie);
	  }
	 
	// GET ALL ANIMAL BY MONTHS OLD GREATER THAN {months}
	@GetMapping("animals/greaterthan/{months}")
	public List<Animal> animalsByMonthsOldGreater(@PathVariable int months) {
		
		return (List<Animal>) animalsRepository.findByMonthsOldGreaterThan(months);
	}
	
	// FIND ANIMALS BY SPECIE ID SORTED
	@GetMapping("animals/species/{speceId}")
	public List<Animal> sortedBySpeceId(@PathVariable int speceId) {
		return (List<Animal>) animalsRepository.findBySpecieIdOrderByMonthsOldDesc(speceId);
	}
	
	// FIND ANIMALS BY NAME IGNORE CASE
	@GetMapping("animals/name/{name}")
	public List<Animal> findByNameIgnoreCase(@PathVariable String name) {
		return (List<Animal>) animalsRepository.findByNameIgnoreCase(name);
	}
	
	
	
	
	
}
