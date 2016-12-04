public class Chicken {

	String name;
	int age;
	String color;

	public Chicken(String name, int age, String color){
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public boolean equals(Object o){
		Chicken other = (Chicken)o;
		return other.name.equals(name) && other.age == age && other.color.equals(color);
	}

}
