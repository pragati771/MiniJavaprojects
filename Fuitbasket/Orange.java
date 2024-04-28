package task1;

public class Orange extends Fruit {
	public Orange(String c,double w,String n,boolean f) {
		super(c,w,n,f);
	}
	
	public void juice(){
		System.out.println(super.getName()+"which weights "+super.getWeight()+"can give you fresh juice");
	} 
	@Override
	public void taste(){
		 System.out.println("Orange is sour");
	 }
	@Override
	public String toString() {
		return super.toString();
	}
}
