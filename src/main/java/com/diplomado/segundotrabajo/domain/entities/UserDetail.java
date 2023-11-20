package com.diplomado.segundotrabajo.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "user_detail")
public class UserDetail  implements Serializable {

    private static final long serialVersionUID = 8799656478674712001L;
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_detail_sequence")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;

    @Column(name = "birth_day")
    private LocalDate birthDay;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Users users;



    public UserDetail(String firstName, String lastName, Integer age, LocalDate birthDay, Users users) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.users = users;
    }

    public UserDetail() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", users=" + users +
                '}';
    }
}
