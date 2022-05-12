package rs.midusa.ZooApp.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity(name="species")
public class Specie {

	
	
		@Id
		@Value("id")
		private int Id;
		
		private String name;
		
		@Value("family_name")
		private String familyName;
		
		
		
		@OneToMany(mappedBy = "specie")
		private Set<Animal> animals;
		
		
		
		public Specie() {
			
		}
		
		public Specie(Integer id, String name, String familyName) {
			
			this.Id = id;
			this.name = name;
			this.familyName = familyName;
		}

		public Integer getSpecieId() {
			return Id;
		}

		public void setSpecieId(Integer specieId) {
			this.Id = specieId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFamilyName() {
			return familyName;
		}

		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}

		@Override
		public String toString() {
			return "Specie [specieId=" + Id + ", name=" + name + ", familyName=" + familyName + "]";
		}
		
		
}
