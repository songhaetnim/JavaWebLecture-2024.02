package ch14_el_jstl;

public class Member {
	private int id;
	private String name;
	private Address addr;
	
	public Member() { }
	public Member(int id, String name, Address addr) {
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}
	
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
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
}