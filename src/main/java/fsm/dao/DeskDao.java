package fsm.dao;

import java.util.Collection;
import java.util.List;

import fsm.model.domain.Desk;

public interface DeskDao {

	public Integer addDesk(Desk desk);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public List<Desk> getAllDesks();

    public void addAllDesks(Collection<Desk> desks);
}
