public class Bean {
    private String name;

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String toString() {
	return String.format("[%s] %s",
		    this.getClass().getName(),
		    getName()
	       );
    }
}