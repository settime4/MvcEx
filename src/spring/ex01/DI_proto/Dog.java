package spring.ex01.DI_proto;

class Dog {
	String name;
	String food;
	Cat cat;
	
	public Dog(){}
	public Dog(String str){
		this.name = str;
	}
	public Dog(String name, String food){
		this.name = name;
		this.food = food;
	}
	public Dog(String name, String food, Cat cat){
		this.name = name;
		this.food = food;
		this.cat = cat;
	}
	
	public void sleep(){
		System.out.println("�������� ���� �ܴ�.");
	}
	
	public void eat(){
		System.out.println("�������� ���� �Խ��ϴ�.");
	}
	
	public void bow(){
		System.out.println(name+"�� "+food+" �޶�� �Ҹ�Ĩ�ϴ�.\n"+cat+"�� ���� ������ �Ҹ������ϴ�.");
	}
}
