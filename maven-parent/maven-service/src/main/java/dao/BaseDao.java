package dao;

import java.util.List;

public interface BaseDao<T,PK> {

	public List<T> getAll();
}
