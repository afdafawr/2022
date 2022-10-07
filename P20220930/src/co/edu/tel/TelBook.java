package co.edu.tel;

public class TelBook {
	private int tel;
	private String name;
	private String gender;
	private int bdy;
	public TelBook(int tel, String name, String gender, int bdy) {
		super();
		this.tel = tel;
		this.name = name;
		this.gender = gender;
		this.bdy = bdy;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getBdy() {
		return bdy;
	}
	public void setBdy(int bdy) {
		this.bdy = bdy;
	}
	@Override
	public String toString() {
		return "TelBook [tel=" + tel + ", name=" + name + ", gender=" + gender + ", bdy=" + bdy + "]";
	}
}
