package fsm.service;

import fsm.domain.Desk;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface DeskService {

	public Integer addDesk(Desk desk);

	public Integer addAllDesk(Set<Desk> desk);

	public void removeDesk(int deskId);

	public void updateDesk(Desk desk);

	public Desk getDeskById(int deskId);

	public Set<Desk> getAllDesks();

}
