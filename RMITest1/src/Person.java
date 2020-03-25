import java.io.Serializable;

public class Person implements Serializable {
    private String name, surname, address;
    private int age;

    public Person(String name, String surname, String address, int age) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("name=\"%s\" surname=\"%s\" address=\"%s\" age=%d", name, surname, address, age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String s) {
        this.surname = s;
    }

    public void setAddress(String s) {
        this.address = s;
    }

    public void setAge(int n) {
        this.age = n;
    }

}