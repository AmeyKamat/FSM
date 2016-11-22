package fsm.service.impl;

import fsm.dao.DeskDao;
import fsm.domain.Desk;
import fsm.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class DeskServiceImpl implements DeskService {

	@Autowired
	private DeskDao dao;

	@Transactional
	public Integer addDesk(Desk desk) {
		return dao.addDesk(desk);
	}

	@Transactional
	public Integer addAllDesk(Set<Desk> desk) {
		return dao.addAllDesk(desk);
	}

	@Transactional
	public void removeDesk(int deskId) {
		dao.removeDesk(deskId);
	}

	@Transactional
	public void updateDesk(Desk desk) {
		dao.updateDesk(desk);
	}

	@Transactional
	public Desk getDeskById(int deskId) {
		return dao.getDeskById(deskId);
	}

	@Transactional
	public Set<Desk> getAllDesks() {
		return dao.getAllDesks();
	}

}
