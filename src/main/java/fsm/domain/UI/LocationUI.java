package fsm.domain.UI;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="LOCATION")
@JsonIgnoreProperties("city")
@JsonFilter("locationFilter")
public class LocationUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityUI city;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "location_code")
	private String locationCode;

	@OneToMany(mappedBy = "location")
	private Set<FloorUI> floors;

	public LocationUI() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CityUI getCity() {
		return city;
	}

	public void setCity(CityUI city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Set<FloorUI> getFloors() {
		return floors;
	}

	public void setFloors(Set<FloorUI> floors) {
		this.floors = floors;
	}

}
