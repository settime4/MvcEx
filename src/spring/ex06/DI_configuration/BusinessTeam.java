package spring.ex06.DI_configuration;


public class BusinessTeam implements Department{
	String name;
	public void work(){
		System.out.println("����Ͻ�");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
