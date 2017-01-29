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
		System.out.println("강아지가 잠을 잔다.");
	}
	
	public void eat(){
		System.out.println("강아지가 밥을 먹습니다.");
	}
	
	public void bow(){
		System.out.println(name+"가 "+food+" 달라고 소리칩니다.\n"+cat+"도 같이 옆에서 소리지릅니다.");
	}
}
