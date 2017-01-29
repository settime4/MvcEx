package aaa.rest.ver2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


//@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.NONE) // none타입인 경우 @XmlAttribute @XmlElement 가 붙은 녀석만 가서 달라 붙는다
public class Employee {
	@XmlAttribute
	String name;
	
	@XmlElement
	String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
