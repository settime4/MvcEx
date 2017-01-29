package spring.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Member {
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", message="���̵� ������ Ʋ��")
	private String id;
	@Size(min=4, max=10, message="����Ʋ��")
	private String password;
	@Email(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", message="�̸��� ������ �ƴ�")
	private String email;
	
	
	@Override
    public String toString() {
	    return "User [id=" + id + ", password=" + password + ", email=" + email + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
