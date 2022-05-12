package rs.midusa.ZooApp.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity(name = "animals")
public class Animal {

	
	@Id
	@Value("animal_id")
	private Integer animalId;
	
	
	private String name;
	
	@Value("months_old")
	private Integer monthsOld;
	
	
	@Value("specie_id")
	private Integer specieId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name= "vaccines_animals",
	joinColumns = @JoinColumn(name = "animal_id", referencedColumnName = "animalId"),
	inverseJoinColumns = @JoinColumn(name = "vaccine_id", referencedColumnName = "vaccineId"))
	private Set<Vaccine> vaccines;
	
	

	@ManyToOne
    @MapsId("specieId")
    @JoinColumn(name = "specieId")
	 private Specie specie;
	

	 
	public Animal() {
	
	}	
	
	public Animal(Integer animal_id, String name, Integer monthsOld, Integer specieId) {
		
		this.animalId = animal_id;
		this.name = name;
		this.monthsOld = monthsOld;
		this.specieId = specieId;
	}

	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer id) {
		this.animalId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMonthsOld() {
		return monthsOld;
	}

	public void setMonthsOld(Integer monthsOld) {
		this.monthsOld = monthsOld;
	}

	public Integer getSpecieId() {
		return specieId;
	}

	public void setSpecieId(Integer specie_id) {
		this.specieId = specie_id;
	}

	@Override
	public String toString() {
		return "Animal [animalId=" + animalId + ", name=" + name + ", months_old=" + monthsOld + ", specie_id=" + specieId + "]";
	}
	
	
	
}
