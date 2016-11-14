package fsm.service.middleLayer.impl;

import fsm.dao.DeskDao;
import fsm.domain.Desk;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeskServiceImpl implements DeskDao {

	@Autowired
	private DeskDao dao;

	public Integer addDesk(Desk desk) {
		return dao.addDesk(desk);
	}

	public void removeDesk(int deskId) {
		dao.removeDesk(deskId);
	}

	public void updateDesk(Desk desk) {
		dao.updateDesk(desk);
	}

	public Desk getDeskById(int deskId) {
		return dao.getDeskById(deskId);
	}

	public List<Desk> getAllDesks() {
		return dao.getAllDesks();
	}

}
