package com.Adil.Entity;


public class Member {

    public int id;

    public String name;

    public String surname;

    public int age;

    private String jobrole;

    public Member(int id,String name, String surname, int age, String jobrole) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobrole = jobrole;
    }

    public Member(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) { 
    		this.surname = surname; 
    	}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }
}
