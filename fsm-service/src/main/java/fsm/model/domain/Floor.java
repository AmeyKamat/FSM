package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;


@Entity
@javax.persistence.Table(name="fsm_floor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator_column", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("domain")
@JsonRootName(value = "Floor")
@JsonFilter(value = "filter")
@JsonIgnoreProperties("location")
public class Floor {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@NotNull
	@Column(name = "floor_code")
	private String floorCode;
	
	@NotNull
	@Column(name = "min_x")
	private int minX;
	
	@NotNull
	@Column(name = "min_y")
	private int minY;
	
	@NotNull
	@Column(name = "max_x")
	private int maxX;
	
	@NotNull
	@Column(name = "max_y")
	private int maxY;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "floor", orphanRemoval=true)
	@Cascade({SAVE_UPDATE, DELETE})
	private List<Table> tables;

	public Floor() {
		super();
	}


	public Floor(int minX,int minY, int maxX, int maxY){
		this.minX=minX;
		this.minY=minY;
		this.maxX=maxX;
		this.maxY=maxY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

}

