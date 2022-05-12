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

import rs.midusa.ZooApp.entities.Specie;

import rs.midusa.ZooApp.repositories.SpeciesRepository;



@RestController
public class SpeciesControllers {

	
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	
	//GET ALL
	@GetMapping("/species")
	public List<Specie> getAllSpecies(){
		
		return (List<Specie>)speciesRepository.findAll();
	}
	
	// GET ONE BY ID
	@GetMapping("/species/{id}")
	public Specie getSpecieById(@PathVariable int id){
		return (Specie)speciesRepository.findById(id).orElse(null);
	}
	
	// CREATE NEW SPECIE
	@PostMapping("/species")
	public Specie createSpecie( @RequestBody Specie newSpecie) {
		
		return (Specie)speciesRepository.save(newSpecie);
	}
	
	// UPDATE CURRENT SPECIE
	@PutMapping("/species/{id}")
	public Specie updateSpecie(@PathVariable int id, @RequestBody Specie newSpecie ) {
		
		return (Specie) speciesRepository.save(newSpecie); 
		
	}
	
	// COUNT
	@GetMapping("species/count")
	public Integer countSpecies() {
		return (int) speciesRepository.count();
	}
	
	
	
	// DELETE SPECIE
	@DeleteMapping("/species/{id}")
	public void deleteSpecie(@PathVariable int id) {
		speciesRepository.deleteById(id);
	}
	
	
	
}
