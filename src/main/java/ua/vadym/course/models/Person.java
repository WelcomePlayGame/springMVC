package ua.vadym.course.models;


import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Email;

public class Person {
    private int id;

    @NotEmpty(message = "Can not be empty")
    @Size(min = 2, max = 10, message = "Beetwen from 2 to 10")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 70, message = "Age should be less 70")
    private int age;

    @NotEmpty(message = "Can not be empty")
    @Email(message = "Email should be valid")
    private String email;


    public Person(int id, String name, int age, String mail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = mail;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
