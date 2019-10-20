
public class Engine {
private Catogery catogery;
public Engine() {
	catogery= new BCatogery();
}
public void setCatogery(Catogery catogery) {
	this.catogery = catogery;
}
public Catogery getCatogery() {
	return catogery;
}
}
