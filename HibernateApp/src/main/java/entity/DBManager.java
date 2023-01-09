package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import org.springframework.security.crypto.password.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class DBManager {
    public Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("PW is my favorite uni", 13, 65536, 128);
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public DBManager (){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
    public BigInteger addClient(String firstName, String lastName, String email, String phoneNumber, BigInteger addressId, LocalDate birthDate, BigInteger loginId){
        try {
            transaction.begin();
            Clients client = new Clients();
            client.setName(firstName);
            client.setSurname(lastName);
            client.setEmail(email);
            client.setPhoneNumber(phoneNumber);
            client.setAddressesAddressId(addressId);
            client.setBirthDate(birthDate);
            client.setLoginDataId(loginId);
            entityManager.persist(client);
            transaction.commit();
            return client.getClientId();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    public BigInteger addAddress(String town, String street, String buildingNumber, String postalCode, BigInteger countryId){
        try {
            transaction.begin();
            Addresses address = new Addresses();
            address.setTown(town);
            address.setStreet(street);
            address.setBuildingNumber(buildingNumber);
            address.setPostalCode(postalCode);
            address.setCountryId(countryId);
            entityManager.persist(address);
            transaction.commit();
            return address.getAddressId();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    public BigInteger addPackage(
            BigInteger senderId, BigInteger receiverId,
            BigInteger senderAddressId, BigInteger receiverAddressId,
            String packageSize, String priority, Double weight){
        try {
            transaction.begin();
            Packages parcel = new Packages();
            parcel.setPriority(priority);
            parcel.setToAddressId(receiverAddressId);
            parcel.setFromAddressId(senderAddressId);
            parcel.setReceiverId(receiverId);
            parcel.setSenderId(senderId);
            parcel.setSize(packageSize);
            parcel.setWeight(weight);
            entityManager.persist(parcel);
            transaction.commit();
            return parcel.getPackageId();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    public Packages getPackageById(BigInteger id){
        String s = "SELECT p FROM Packages p WHERE p.packageId = :id";
        TypedQuery<Packages> packageById = entityManager.createQuery(s, Packages.class);
        packageById.setParameter("id", id);
        return packageById.getSingleResult();
    }
    public List<Packages> getAllPackages(){
        String s = "SELECT p FROM Packages p";
        TypedQuery<Packages> allPackages = entityManager.createQuery(s, Packages.class);
        return allPackages.getResultList();
    }
    public List getFullPackageInfo(BigInteger id){
        String s = "SELECT p.packageId, p.size, p.priority, a.street, a.buildingNumber, a.town, a.postalCode, " +
                "per.name, per.surname, per.phoneNumber " +
                "FROM Packages p " +
                "JOIN Clients per ON (p.receiverId = per.clientId) " +
                "JOIN Addresses a ON (p.toAddressId = a.addressId) WHERE p.packageId = :id";
        Query q = entityManager.createQuery(s);
        q.setParameter("id", id);
        return q.getResultList();
    }
    public List getAllPackagesInfo(){
        String s = "" +
                "SELECT p.id, cl.name, cl.surname, cl2.name, cl2.surname " +
                "FROM Packages p " +
                "JOIN Clients cl ON (p.senderId=cl.clientId) " +
                "JOIN Clients cl2 ON (p.receiverId=cl2.clientId)";
        Query q = entityManager.createQuery(s);
        return q.getResultList();
    }

    public BigInteger addLoginData(String login, String password){
        try {
            transaction.begin();
            LoginData ld = new LoginData();
            ld.setLogin(login);
            String pbkdf2CryptedPassword = passwordEncoder.encode(password);
//            boolean passwordIsValid = passwordEncoder.matches(password, pbkdf2CryptedPassword);
            ld.setPassword(pbkdf2CryptedPassword);
            entityManager.persist(ld);
            transaction.commit();
            return ld.getLoginId();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public static void main(String[] args) {
        DBManager db = new DBManager();
    }

    public BigInteger getCountryIdByName(String countryName) {
        String s = "SELECT distinct c FROM Countries c WHERE name = :countryName";
        TypedQuery<Countries> countryByName = entityManager.createQuery(s, Countries.class);
        countryByName.setParameter("countryName", countryName);
        return countryByName.getSingleResult().getCountryId();
    }

    public Clients getClient(BigInteger clientId) {
        String s = "SELECT distinct cl FROM Clients cl WHERE cl.clientId = :id";
        TypedQuery<Clients> clientById = entityManager.createQuery(s, Clients.class);
        clientById.setParameter("id", clientId);
        return clientById.getSingleResult();
    }

    public String getPasswordByLogin(String login) {
        String s = "SELECT distinct l FROM LoginData l WHERE login = :login";
        TypedQuery<LoginData> passwordByLogin = entityManager.createQuery(s, LoginData.class);
        passwordByLogin.setParameter("login", login);
        return passwordByLogin.getSingleResult().getPassword();
    }
}
