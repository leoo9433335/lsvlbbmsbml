package dados;

public abstract interface Iterador {

	public abstract void reset();

	public abstract boolean hasNext();

	public abstract Object next();

}
