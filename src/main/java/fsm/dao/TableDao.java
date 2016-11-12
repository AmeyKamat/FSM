package fsm.dao;

import java.util.List;

import fsm.domain.Table;

public interface TableDao {

	public void add(Table table);

	public void remove(int id);

	public void update(Table table);

	public void get(int id);

	public List<Table> getAll();

}
