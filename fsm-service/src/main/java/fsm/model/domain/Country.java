package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@javax.persistence.Table(name = "fsm_country")
@JsonFilter("filter")
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "country")
	private List<City> cities;

	public Country() {
		super();
	}

	public Country(String country) {
		this.name=country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
