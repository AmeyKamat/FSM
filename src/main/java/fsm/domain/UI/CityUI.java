package fsm.domain.UI;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="CITY")
@JsonFilter("cityFilter")
public class CityUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryUI country;

	@NotNull
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "city")
	private Set<LocationUI> locations;

	public CityUI() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CountryUI getCountry() {
		return country;
	}

	public void setCountry(CountryUI country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<LocationUI> getLocations() {
		return locations;
	}

	public void setLocations(Set<LocationUI> locations) {
		this.locations = locations;
	}

}
