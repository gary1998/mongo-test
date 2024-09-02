package com.edge.college.student;

import java.util.concurrent.ConcurrentHashMap;

public class Student {
    private String name;
    private int id;
    private String dob;

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    private static final ConcurrentHashMap<Integer, Student> students = new ConcurrentHashMap<>();

    public static synchronized void registerStudent(int id, String name, String dob) throws Exception{
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setDob(dob);
        if (students.containsKey(id)){
            throw new Exception("already registered student with this id");
        } else {
            students.put(id, s);
        }
    }

    public static Student getStudent(int id) {
        return students.get(id);
    }

    @Override
    public String toString() {
        return String.format("Student [id=%d name=%s dob=%s]", this.id, this.name, this.dob);
    }

}
