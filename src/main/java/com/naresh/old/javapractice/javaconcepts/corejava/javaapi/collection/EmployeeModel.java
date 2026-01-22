package com.naresh.old.javapractice.javaconcepts.corejava.javaapi.collection;

public class EmployeeModel  implements Comparable{

    public String name;
    public int age;
        
    
    public EmployeeModel(String name, Integer age) {
	super();
	this.name = name;
	this.age = age;
	
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
	if(this.getAge() == ((EmployeeModel) o).getAge()) {
	    	  
	    return (int)this.getName().compareTo(((EmployeeModel) o).getName());    
	    
	}else if(this.getAge() < ((EmployeeModel) o).getAge()) {
	    return -1;
	}else {
	    return 1;
	}
    }
    @Override
    public String toString() {
	return "EmployeeModel [name=" + name + ", age=" + age + "]";
    }
    
   
    

}