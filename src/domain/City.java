package domain;

public class City {
	private int id;
	private String name;
	private int pid;
	public City() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public City(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

}
