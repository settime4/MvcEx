package spring.ex01.DI_proto;

public class Zoo {
	private volatile static Zoo uniqInstance;
	private Zoo(){	}
	public static Zoo getInstance(){
		if( uniqInstance == null){
			synchronized (Zoo.class){
				if( uniqInstance == null){
					uniqInstance = new Zoo();
				}
			}
		}
		return uniqInstance;
	}
	public void clean(){
		System.out.println("û�� ��");
	}
	public void open(){
		System.out.println("������ ����");
	}
	public void close(){
		System.out.println("������ ����");
	}
}
