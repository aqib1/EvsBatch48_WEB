
public class MyList<T,V> {
private T value;
private V secondValue;
public V getSecondValue() {
	return secondValue;
}
public void setSecondValue(V secondValue) {
	this.secondValue = secondValue;
}
public T getValue() {
	return value;
}
public void setValue(T value) {
	this.value = value;
}
}
