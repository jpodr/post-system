package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public class DBManager {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public DBManager (){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
    public BigInteger addPerson(String firstName, String lastName, String email, int phoneNumber){
//        try {
//            transaction.begin();
//            Persons person = new Persons();
//            person.setFirstname(firstName);
//            person.setLastname(lastName);
//            person.setEmail(email);
//            person.setPhonenumber(phoneNumber);
//            entityManager.persist(person);
//            transaction.commit();
//            return person.getPersonid();
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//        }
    }
    public BigInteger addAddress(String city, String street, String buildingNumber, String postalCode){
//        try {
//            transaction.begin();
//            Addresses address = new Addresses();
//            address.setCity(city);
//            address.setStreet(street);
//            address.setBuildingnumber(buildingNumber);
//            address.setPostalcode(postalCode);
//            entityManager.persist(address);
//            transaction.commit();
//            return address.getAddressid();
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//        }
    }
    public BigInteger addPackage(
            BigInteger senderId, BigInteger receiverId,
            BigInteger senderAddressId, BigInteger receiverAddressId,
            String packageSize, String priority){
//        try {
//            transaction.begin();
//            Packages parcel = new Packages();
//            parcel.setPriority(priority);
//            parcel.setReceiveraddressid(receiverAddressId);
//            parcel.setSenderaddressid(senderAddressId);
//            parcel.setReceiverid(receiverId);
//            parcel.setSenderid(senderId);
//            parcel.setPackagesize(packageSize);
//            entityManager.persist(parcel);
//            transaction.commit();
//            return parcel.getPackageid();
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//        }
    }
    public Packages getPackageById(BigInteger id){
//        String s = "SELECT p FROM Packages p WHERE p.packageid = :id";
//        TypedQuery<Packages> packageById = entityManager.createQuery(s, Packages.class);
//        packageById.setParameter("id", id);
//        return packageById.getSingleResult();
    }
    public List<Packages> getAllPackages(){
//        String s = "SELECT p FROM Packages p";
//        TypedQuery<Packages> allPackages = entityManager.createQuery(s, Packages.class);
//        return allPackages.getResultList();
    }
    public List getFullPackageInfo(BigInteger id){
//        String s = "SELECT p.packageid, p.packagesize, p.priority, a.street, a.buildingnumber, a.city, a.postalcode, per.firstname, per.lastname, per.phonenumber FROM Packages p JOIN Persons per ON (p.receiverid = per.personid) JOIN Addresses a ON (p.receiveraddressid = a.addressid) WHERE p.packageid = :id";
//        Query q = entityManager.createQuery(s);
//        q.setParameter("id", id);
//        return q.getResultList();
    }
    public List getAllPackagesInfo(){
//        String s = "SELECT p.id, per.firstname, per.lastname FROM Packages p JOIN Persons per ON (p.senderid=per.personid)";
//        Query q = entityManager.createQuery(s);
//        return q.getResultList();
    }
    public static void main(String[] args) {
//        DBManager db = new DBManager();
//        List l = db.getFullPackageInfo(BigInteger.valueOf(1));
    }
}
