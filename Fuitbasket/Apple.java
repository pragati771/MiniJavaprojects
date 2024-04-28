package task1;

public class Apple extends Fruit{
	public Apple(String c,double w,String n,boolean f) {
		super(c,w,n,f);
	}
	public void jam(){
		System.out.println(super.getName()+" is a greatly used for making jam");
	}
	
	@Override
	public void taste(){
		 System.out.println("Apple is sweet and sour");
	 }
	@Override
	public String toString() {
		return super.toString();
	}

}
