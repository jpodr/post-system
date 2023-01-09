package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Packages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PACKAGE_ID")
    private BigInteger packageId;
    @Basic
    @Column(name = "Size")
    private String size;
    @Basic
    @Column(name = "PRIORITY")
    private String priority;
    @Basic
    @Column(name = "WEIGHT")
    private byte weight;
    @Basic
    @Column(name = "TO_ADDRESS_ID")
    private BigInteger toAddressId;
    @Basic
    @Column(name = "FROM_ADDRESS_ID")
    private BigInteger fromAddressId;
    @Basic
    @Column(name = "SERVICE_PLACE_ID")
    private BigInteger servicePlaceId;
    @Basic
    @Column(name = "RECEIVER_ID")
    private BigInteger receiverId;
    @Basic
    @Column(name = "SENDER_ID")
    private BigInteger senderId;

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public BigInteger getToAddressId() {
        return toAddressId;
    }

    public void setToAddressId(BigInteger toAddressId) {
        this.toAddressId = toAddressId;
    }

    public BigInteger getFromAddressId() {
        return fromAddressId;
    }

    public void setFromAddressId(BigInteger fromAddressId) {
        this.fromAddressId = fromAddressId;
    }

    public BigInteger getServicePlaceId() {
        return servicePlaceId;
    }

    public void setServicePlaceId(BigInteger servicePlaceId) {
        this.servicePlaceId = servicePlaceId;
    }

    public BigInteger getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(BigInteger receiverId) {
        this.receiverId = receiverId;
    }

    public BigInteger getSenderId() {
        return senderId;
    }

    public void setSenderId(BigInteger senderId) {
        this.senderId = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packages packages = (Packages) o;

        if (weight != packages.weight) return false;
        if (packageId != null ? !packageId.equals(packages.packageId) : packages.packageId != null) return false;
        if (size != null ? !size.equals(packages.size) : packages.size != null) return false;
        if (priority != null ? !priority.equals(packages.priority) : packages.priority != null) return false;
        if (toAddressId != null ? !toAddressId.equals(packages.toAddressId) : packages.toAddressId != null)
            return false;
        if (fromAddressId != null ? !fromAddressId.equals(packages.fromAddressId) : packages.fromAddressId != null)
            return false;
        if (servicePlaceId != null ? !servicePlaceId.equals(packages.servicePlaceId) : packages.servicePlaceId != null)
            return false;
        if (receiverId != null ? !receiverId.equals(packages.receiverId) : packages.receiverId != null) return false;
        if (senderId != null ? !senderId.equals(packages.senderId) : packages.senderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (int) weight;
        result = 31 * result + (toAddressId != null ? toAddressId.hashCode() : 0);
        result = 31 * result + (fromAddressId != null ? fromAddressId.hashCode() : 0);
        result = 31 * result + (servicePlaceId != null ? servicePlaceId.hashCode() : 0);
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        return result;
    }
}
