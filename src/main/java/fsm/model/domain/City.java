package fsm.model.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@javax.persistence.Table(name="CITY")
@JsonFilter("filter")
public class City {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@NotNull
	@Column(name = "name")
	private String name;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "city")
	private List<Location> locations;

	public City() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
