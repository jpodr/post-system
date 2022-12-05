package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Persons {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PERSONID")
    private BigInteger personid;
    @Basic
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "PHONENUMBER")
    private int phonenumber;

    public BigInteger getPersonid() {
        return personid;
    }

    public void setPersonid(BigInteger personid) {
        this.personid = personid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persons persons = (Persons) o;

        if (phonenumber != persons.phonenumber) return false;
        if (personid != null ? !personid.equals(persons.personid) : persons.personid != null) return false;
        if (firstname != null ? !firstname.equals(persons.firstname) : persons.firstname != null) return false;
        if (lastname != null ? !lastname.equals(persons.lastname) : persons.lastname != null) return false;
        if (email != null ? !email.equals(persons.email) : persons.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personid != null ? personid.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + phonenumber;
        return result;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "personid=" + personid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}
