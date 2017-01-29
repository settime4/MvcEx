package aab.user;

public class Login {
	private String id, password;

	@Override
    public String toString() {
	    return "Login [id=" + id + ", password=" + password + "]";
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
