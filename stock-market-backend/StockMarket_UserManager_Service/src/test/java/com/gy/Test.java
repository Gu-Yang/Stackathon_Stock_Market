package com.gy;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo(o2.getName());
                if (o1.equals(o2)){
                    return 0;
                } else {
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });

        Person person1 = new Person("GuYang", "29", "001");
        Person person2 = new Person("gy", "33", "002");
        Person person3 = new Person("GuYang", "26", "003");
        Person person4 = new Person("GuYang", "65", "004");

        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);

        System.out.println(set);
    }
}

class Person {
    String name;
    String age;
    String id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Person(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                age.equals(person.age) &&
                id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}