package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigInteger;

public class SpPacksHistoryPK implements Serializable {
    @Column(name = "PACKAGE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger packageId;
    @Column(name = "SERVICE_PLACE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger servicePlaceId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpPacksHistoryPK that = (SpPacksHistoryPK) o;

        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (servicePlaceId != null ? !servicePlaceId.equals(that.servicePlaceId) : that.servicePlaceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (servicePlaceId != null ? servicePlaceId.hashCode() : 0);
        return result;
    }
}
