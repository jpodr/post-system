create table packages
(
    packageId NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    senderId NUMBER REFERENCES persons (personId),
    receiverId NUMBER REFERENCES persons (personId),
    senderAddressId NUMBER REFERENCES addresses (addressId),
    receiverAddressId NUMBER REFERENCES addresses (addressId),
    "size" VARCHAR2(40 char) NOT NULL,
    priority VARCHAR2(40 char) NOT NULL
);

create table persons
(
    personId NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) PRIMARY KEY,
    name VARCHAR2(40 char) NOT NULL,
    surname VARCHAR2(40 char) NOT NULL,
    email VARCHAR2(40 char) NOT NULL,
    phoneNumber NUMBER(9) NOT NULL
);

create table addresses
(
    addressId      NUMBER GENERATED ALWAYS as IDENTITY (START with 1 INCREMENT by 1) PRIMARY KEY,
    city           VARCHAR2(40 char) NOT NULL,
    street         VARCHAR2(40 char) NOT NULL,
    buildingNumber VARCHAR2(40 char) NOT NULL,
    postalCode     VARCHAR2(40 char) NOT NULL
);
