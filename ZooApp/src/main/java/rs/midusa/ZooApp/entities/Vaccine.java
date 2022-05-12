package rs.midusa.ZooApp.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;



@Entity
@Table(name="vaccines")
public class Vaccine {
	
	@Id
	@Value("vaccine_id")
	private Integer vaccineId;

	private String name;

	@ManyToMany(mappedBy = "vaccines")
	private Set<Animal> animals;
	
	
	
	public Vaccine() {	
		
	}
	
	public Vaccine(Integer vaccineId, String name) {
		
		this.vaccineId = vaccineId;
		this.name = name;
	}

	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + vaccineId + ", name=" + name + "]";
	}
	
	
}
