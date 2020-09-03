package Database;

import java.util.List;

public interface InterfaceDAO<T> {
	
	public void adicionar(T referencia);

	public List<T> todos();

}