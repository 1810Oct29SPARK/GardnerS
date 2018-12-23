package revature.beans;

public class BearType {

	public BearType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BearType() {
	}
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BearType [id=" + id + ", name=" + name + "]";
	}

}