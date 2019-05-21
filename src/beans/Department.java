package beans;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Department {



	private int id;
	
	
	
	private String type;
	
	
	private String location;
	
	
	private Set<Employee> s;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Set<Employee> getS() {
		return s;
	}


	public void setS(Set<Employee> s) {
		this.s = s;
	}


	public Department(int id, String type, String location, Set<Employee> s) {
		super();
		this.id = id;
		this.type = type;
		this.location = location;
		this.s = s;
	}


	public Department() {
		super();
	}
	

		
}
