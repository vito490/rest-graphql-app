package com.ibm.demo.restgraphqlapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Student {
    @Id
    private int id;
    private String name;

    public Student(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object thisname = this.getName();
        final Object othername = other.getName();
        if (!Objects.equals(thisname, othername)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object name = this.getName();
        result = result * PRIME + (name == null ? 43 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Student(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
