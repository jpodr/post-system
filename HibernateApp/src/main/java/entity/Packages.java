package entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Packages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PACKAGEID")
    private BigInteger packageid;
    @Basic
    @Column(name = "SENDERID")
    private BigInteger senderid;
    @Basic
    @Column(name = "RECEIVERID")
    private BigInteger receiverid;
    @Basic
    @Column(name = "SENDERADDRESSID")
    private BigInteger senderaddressid;
    @Basic
    @Column(name = "RECEIVERADDRESSID")
    private BigInteger receiveraddressid;
    @Basic
    @Column(name = "PACKAGESIZE")
    private String packagesize;
    @Basic
    @Column(name = "PRIORITY")
    private String priority;

    public BigInteger getPackageid() {
        return packageid;
    }

    public void setPackageid(BigInteger packageid) {
        this.packageid = packageid;
    }

    public BigInteger getSenderid() {
        return senderid;
    }

    public void setSenderid(BigInteger senderid) {
        this.senderid = senderid;
    }

    public BigInteger getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(BigInteger receiverid) {
        this.receiverid = receiverid;
    }

    public BigInteger getSenderaddressid() {
        return senderaddressid;
    }

    public void setSenderaddressid(BigInteger senderaddressid) {
        this.senderaddressid = senderaddressid;
    }

    public BigInteger getReceiveraddressid() {
        return receiveraddressid;
    }

    public void setReceiveraddressid(BigInteger receiveraddressid) {
        this.receiveraddressid = receiveraddressid;
    }

    public String getPackagesize() {
        return packagesize;
    }

    public void setPackagesize(String size) {
        this.packagesize = size;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packages packages = (Packages) o;

        if (packageid != null ? !packageid.equals(packages.packageid) : packages.packageid != null) return false;
        if (senderid != null ? !senderid.equals(packages.senderid) : packages.senderid != null) return false;
        if (receiverid != null ? !receiverid.equals(packages.receiverid) : packages.receiverid != null) return false;
        if (senderaddressid != null ? !senderaddressid.equals(packages.senderaddressid) : packages.senderaddressid != null)
            return false;
        if (receiveraddressid != null ? !receiveraddressid.equals(packages.receiveraddressid) : packages.receiveraddressid != null)
            return false;
        if (packagesize != null ? !packagesize.equals(packages.packagesize) : packages.packagesize != null) return false;
        if (priority != null ? !priority.equals(packages.priority) : packages.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageid != null ? packageid.hashCode() : 0;
        result = 31 * result + (senderid != null ? senderid.hashCode() : 0);
        result = 31 * result + (receiverid != null ? receiverid.hashCode() : 0);
        result = 31 * result + (senderaddressid != null ? senderaddressid.hashCode() : 0);
        result = 31 * result + (receiveraddressid != null ? receiveraddressid.hashCode() : 0);
        result = 31 * result + (packagesize != null ? packagesize.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Packages{" +
                "packageid=" + packageid +
                ", senderid=" + senderid +
                ", receiverid=" + receiverid +
                ", senderaddressid=" + senderaddressid +
                ", receiveraddressid=" + receiveraddressid +
                ", packagesize='" + packagesize + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
