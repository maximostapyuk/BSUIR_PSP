package sample;

public class Student {
    private String name;
    private String surname;
    private int group;

    public Student() {
    }

    public Student(String name, String surname, int group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString(){
        return this.surname+" "+this.name+" "+this.group+".";
    }
}
