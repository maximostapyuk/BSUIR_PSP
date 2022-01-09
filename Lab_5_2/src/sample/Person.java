package sample;

import java.io.Serializable;

public class Person implements Serializable {
    private String surname;
    private String name;
    private String sex;
    private String hobby;
    private String study;

    public Person() {
    }

    public Person(String surname, String name, String sex, String hobby, String study) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.hobby = hobby;
        this.study = study;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getHobby() {
        return hobby;
    }

    public String getStudy() {
        return study;
    }
}
