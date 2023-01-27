package Entities;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String job;

    // Instructions: I created a User class that includes:
    // - Constructor method with 2 parameters (name and job) to initialize the "User" object attributes
    // - Setter and Getter methods to access private attribute values from external files
    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
