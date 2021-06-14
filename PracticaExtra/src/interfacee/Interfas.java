package interfacee;

import Exenciones.*;

public interface Interfas<T> {
	public boolean addComposicion(T composicion);
	public boolean existeComposicion(T composicion);
	public T getComposicion(int pos);
	public int getSize();
	public boolean delete (T composicion);
	public boolean isFree();
	public boolean isFull();

}
