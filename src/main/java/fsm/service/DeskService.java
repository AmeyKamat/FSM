package fsm.service;

import fsm.domain.Desk;

import java.util.List;

public interface DeskService {

	public Integer addDesk(Desk desk);

	public Integer addAllDesk(List<Desk> desk);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public List<Desk> getAllDesks();

}
