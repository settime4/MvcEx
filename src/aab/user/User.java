package aab.user;

public class User {
	private long no;
	private String id, password;
	
	
	@Override
    public String toString() {
	    return "User [no=" + no + ", id=" + id + ", password=" + password + "]";
    }
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
