package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@javax.persistence.Table(name="fsm_location")
@JsonIgnoreProperties("city")
@JsonFilter("filter")
public class Location {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "location_code")
	private String locationCode;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "location")
	private List<Floor> floors;

	public Location() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
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

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

}
