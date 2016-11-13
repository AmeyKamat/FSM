package fsm.dao;

import java.util.List;

import fsm.domain.Table;

public interface TableDao {

	public Integer add(Table table);

	public void remove(int id);

	public void update(Table table);

	public Table get(int id);

	public List<Table> getAll();

}
