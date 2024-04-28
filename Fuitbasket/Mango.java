package task1;

public  class Mango extends Fruit {
	
	public Mango(String c,double w,String n,boolean f) {
		super(c,w,n,f);
	}
	public void pulp(){
		System.out.println(super.getName()+" can give a very tasty pulp");
	}
	
	@Override
	public void taste(){
		 System.out.println("Mango is sweet");
	 }
	@Override
	public String toString() {
		return super.toString();
	}
}
