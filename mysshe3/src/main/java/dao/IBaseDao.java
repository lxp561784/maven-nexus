package dao;

import java.util.List;

public interface IBaseDao<T> {
	
	public T get(Class<T> t,Integer id);
	
	public List<T> getAll();
}
