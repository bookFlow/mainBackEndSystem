package com.wkzhng.entity;

/**
 * PeopleDetails entity. @author MyEclipse Persistence Tools
 */

public class PeopleDetails  implements java.io.Serializable {
    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String peopleUserName;
     private String name;
     private Boolean sex;
     private Integer age;
     private Integer reputation;
     private Double money;


    // Constructors

    /** default constructor */
    public PeopleDetails() {
    }

    
    /** full constructor */
    public PeopleDetails(String peopleUserName, String name, Boolean sex, Integer age, Integer reputation, Double money) {
        this.peopleUserName = peopleUserName;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.reputation = reputation;
        this.money = money;
    }

   
    // Property accessors

    public String getPeopleUserName() {
        return this.peopleUserName;
    }
    
    public void setPeopleUserName(String peopleUserName) {
        this.peopleUserName = peopleUserName;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return this.sex;
    }
    
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getReputation() {
        return this.reputation;
    }
    
    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Double getMoney() {
        return this.money;
    }
    
    public void setMoney(Double money) {
        this.money = money;
    }
   








}