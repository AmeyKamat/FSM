package fsm.dao;

import java.util.List;

import fsm.domain.Desk;

public interface DeskDao {

	public Integer addDesk(Desk desk);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public List<Desk> getAllDesks();

}
