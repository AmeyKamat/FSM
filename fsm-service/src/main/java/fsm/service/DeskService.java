package fsm.service;

import fsm.model.domain.Desk;

import java.util.Collection;
import java.util.List;

public interface DeskService {

	public Integer addDesk(Desk desk);

	public void addAllDesks(Collection<Desk> desks);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public List<Desk> getAllDesks();

}
