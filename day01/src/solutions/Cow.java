package solutions;


public class Cow {

    String name;
    int age;
    String color;

    public Cow(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public boolean equals(Object o){
        Cow other = (Cow)o;
        return other.name.equals(name) && other.age == age && other.color.equals(color);
    }

}
