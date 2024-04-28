package task1;

public abstract class Fruit {
	 private String color;
	 private double weight;
	 private String name;
	 private boolean fresh;

	 public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFresh() {
		return fresh;
	}
	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	public Fruit(String c,double w,String n,boolean f) {
		 this.color=c;
		 this.weight=w;
		 this.name=n;
		 this.fresh=f;
	 }
	 public abstract void taste();
	 @Override
	 public String toString() {
		 return "name: "+name+" color: "+color+" weight: "+weight;
	 }
}
