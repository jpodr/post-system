import entity.Addresses;
import entity.Packages;
import entity.Persons;
import jakarta.persistence.*;

import java.math.BigInteger;
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
    public void addPerson(String firstName, String lastName, String email, int phoneNumber){
        try {
            transaction.begin();
            Persons person = new Persons();
            person.setFirstname(firstName);
            person.setLastname(lastName);
            person.setEmail(email);
            person.setPhonenumber(phoneNumber);
            entityManager.persist(person);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public void addAddress(String city, String street, String buildingNumber, String postalCode){
        try {
            transaction.begin();
            Addresses address = new Addresses();
            address.setCity(city);
            address.setStreet(street);
            address.setBuildingnumber(buildingNumber);
            address.setPostalcode(postalCode);
            entityManager.persist(address);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public void addPackage(int senderId, int receiverId, int senderAddressId, int receiverAddressId, String packageSize, String priority){
        try {
            transaction.begin();
            Packages parcel = new Packages();
            parcel.setPriority(priority);
            parcel.setReceiveraddressid(BigInteger.valueOf(receiverAddressId));
            parcel.setSenderaddressid(BigInteger.valueOf(senderAddressId));
            parcel.setReceiverid(BigInteger.valueOf(receiverId));
            parcel.setSenderid(BigInteger.valueOf(senderId));
            parcel.setPackagesize(packageSize);
            entityManager.persist(parcel);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public Packages getPackageById(BigInteger id){
        String s = "SELECT p FROM Packages p WHERE p.packageid = :id";
        TypedQuery<Packages> packageById = entityManager.createQuery(s, Packages.class);
        packageById.executeUpdate();
        return packageById.getSingleResult();
    }
    public List<Packages> getAllPackages(){
        String s = "SELECT p FROM Packages p";
        TypedQuery<Packages> allPackages = entityManager.createQuery(s, Packages.class);
        allPackages.executeUpdate();
        return allPackages.getResultList();
    }
    public static void main(String[] args) {
        DBManager db = new DBManager();
    }
}
