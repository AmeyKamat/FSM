package fsm.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsm.dao.DeskDao;
import fsm.model.domain.Desk;
import fsm.service.DeskService;

@Service
public class DeskServiceImpl implements DeskService {

	@Autowired
	private DeskDao deskDao;

	@Override
	@Transactional
	public Integer addDesk(Desk desk) {
		return deskDao.addDesk(desk);
	}

	@Override
	@Transactional
	public void addAllDesks(Collection<Desk> desk) {
		deskDao.addAllDesks(desk);
	}

	@Override
	@Transactional
	public void removeDesk(int deskId) {
		deskDao.removeDesk(deskId);
	}

	@Override
	@Transactional
	public void updateDesk(Desk desk) {
		deskDao.updateDesk(desk);
	}

	@Override
	@Transactional
	public Desk getDeskById(int deskId) {
		return deskDao.getDeskById(deskId);
	}

	@Override
	@Transactional
	public List<Desk> getAllDesks() {
		return deskDao.getAllDesks();
	}

}
