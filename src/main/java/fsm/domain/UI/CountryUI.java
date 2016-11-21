package fsm.domain.UI;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="COUNTRY")
@JsonFilter("countryFilter")
public class CountryUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "country")
	private Set<CityUI> cities;

	public CountryUI() {
		super();
	}

	public CountryUI(String country) {
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

	public Set<CityUI> getCities() {
		return cities;
	}

	public void setCities(Set<CityUI> cities) {
		this.cities = cities;
	}

}
