package com.Adil.Entity;

public class ThealeMember {

   
	
	public int id;

    public String name;

    public String surname;

    public int age;

    public String job_role;

      
    public ThealeMember(int id,String name, String surname, int age, String job_role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.job_role = job_role;
    }

    public ThealeMember(){
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

    public void setName(String name){
        this.name = name;
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) { this.surname = surname; }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getJobrole() {
        return job_role;
    }

    public void setJobrole(String job_role) {
        this.job_role = job_role;
    }    
}
