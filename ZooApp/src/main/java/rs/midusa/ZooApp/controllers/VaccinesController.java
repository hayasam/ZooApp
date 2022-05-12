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


import rs.midusa.ZooApp.entities.Vaccine;
import rs.midusa.ZooApp.repositories.VaccinesRepository;


@RestController
public class VaccinesController {

		@Autowired
		private VaccinesRepository vaccinesRepository;
	
		//GET ALL
		@GetMapping("/vaccines")
		public List<Vaccine> getAllVaccines(){
			
			return (List<Vaccine>)vaccinesRepository.findAll();
		}
		
		// GET ONE BY ID
		@GetMapping("/vaccines/{id}")
		public Vaccine getVaccinesById(@PathVariable int id){
			return (Vaccine)vaccinesRepository.findById(id).orElse(null);
		}
		
		// CREATE NEW VACCINE
		@PostMapping("/vaccines")
		public Vaccine createVaccine( @RequestBody Vaccine newVaccine) {
			
			return (Vaccine)vaccinesRepository.save(newVaccine);
		}
		
		// UPDATE CURRENT VACCINE
		@PutMapping("/vaccines/{id}")
		public Vaccine updateVaccine(@PathVariable int id, @RequestBody Vaccine newVaccine ) {
			
			return (Vaccine) vaccinesRepository.save(newVaccine); 
			
		}
		// COUNT
		@GetMapping("vaccines/count")
		public Integer countSVaccines() {
			return (int) vaccinesRepository.count();
		}
		
		// DELETE SPECIE
		@DeleteMapping("/vaccines/{id}")
		public void deleteVaccine(@PathVariable int id) {
			vaccinesRepository.deleteById(id);
		}
		
		
		
		
	
	
	
}
