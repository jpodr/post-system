package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Addresses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ADDRESSID")
    private BigInteger addressid;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "STREET")
    private String street;
    @Basic
    @Column(name = "BUILDINGNUMBER")
    private String buildingnumber;
    @Basic
    @Column(name = "POSTALCODE")
    private String postalcode;

    public BigInteger getAddressid() {
        return addressid;
    }

    public void setAddressid(BigInteger addressid) {
        this.addressid = addressid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingnumber() {
        return buildingnumber;
    }

    public void setBuildingnumber(String buildingnumber) {
        this.buildingnumber = buildingnumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Addresses addresses = (Addresses) o;

        if (addressid != null ? !addressid.equals(addresses.addressid) : addresses.addressid != null) return false;
        if (city != null ? !city.equals(addresses.city) : addresses.city != null) return false;
        if (street != null ? !street.equals(addresses.street) : addresses.street != null) return false;
        if (buildingnumber != null ? !buildingnumber.equals(addresses.buildingnumber) : addresses.buildingnumber != null)
            return false;
        if (postalcode != null ? !postalcode.equals(addresses.postalcode) : addresses.postalcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressid != null ? addressid.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (buildingnumber != null ? buildingnumber.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "addressid=" + addressid +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingnumber='" + buildingnumber + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }
}
