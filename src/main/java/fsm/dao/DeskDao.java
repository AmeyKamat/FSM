package fsm.dao;

import java.util.List;
import java.util.Set;

import fsm.domain.Desk;
import org.springframework.stereotype.Repository;

//@Repository
public interface DeskDao {

	public Integer addDesk(Desk desk);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public Set<Desk> getAllDesks();

    Integer addAllDesk(Set<Desk> desk);
}
