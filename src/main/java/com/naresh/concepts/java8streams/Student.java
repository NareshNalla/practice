package com.naresh.concepts.java8streams;

public class Student implements Comparable<Student> {
    Integer id; // int compareToIgnoreCase get error
    int age;
    String name;

    public Student(int id, String name, int age) {
	super();
	this.id = id;
	this.age = age;
	this.name = name;
    }

    public Integer getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Student [id=" + id + ", age=" + age + ", name=" + name + "]";
    }

    @Override
    public int compareTo(final Student o) {
	if (o == null || o.getId() == 0) {
	    return 1;
	}
	return getId().compareTo(o.getId());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Student other = (Student) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	
	return true;
    }

}