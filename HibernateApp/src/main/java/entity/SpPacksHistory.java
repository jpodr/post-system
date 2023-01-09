package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "SP_PACKS_HISTORY", schema = "Z02", catalog = "")
@IdClass(SpPacksHistoryPK.class)
public class SpPacksHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PACKAGE_ID")
    private BigInteger packageId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SERVICE_PLACE_ID")
    private BigInteger servicePlaceId;
    @Basic
    @Column(name = "IN_DATETIME")
    private Date inDatetime;
    @Basic
    @Column(name = "ID_STATUS")
    private BigInteger idStatus;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "OUT_DATETIME")
    private Date outDatetime;

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public BigInteger getServicePlaceId() {
        return servicePlaceId;
    }

    public void setServicePlaceId(BigInteger servicePlaceId) {
        this.servicePlaceId = servicePlaceId;
    }

    public Date getInDatetime() {
        return inDatetime;
    }

    public void setInDatetime(Date inDatetime) {
        this.inDatetime = inDatetime;
    }

    public BigInteger getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(BigInteger idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOutDatetime() {
        return outDatetime;
    }

    public void setOutDatetime(Date outDatetime) {
        this.outDatetime = outDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpPacksHistory that = (SpPacksHistory) o;

        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (servicePlaceId != null ? !servicePlaceId.equals(that.servicePlaceId) : that.servicePlaceId != null)
            return false;
        if (inDatetime != null ? !inDatetime.equals(that.inDatetime) : that.inDatetime != null) return false;
        if (idStatus != null ? !idStatus.equals(that.idStatus) : that.idStatus != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (outDatetime != null ? !outDatetime.equals(that.outDatetime) : that.outDatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (servicePlaceId != null ? servicePlaceId.hashCode() : 0);
        result = 31 * result + (inDatetime != null ? inDatetime.hashCode() : 0);
        result = 31 * result + (idStatus != null ? idStatus.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (outDatetime != null ? outDatetime.hashCode() : 0);
        return result;
    }
}
