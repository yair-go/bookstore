package com.yair.bookstore;

import java.io.Serializable;

/**
 * Created by USER on 09/12/2015.
 */
public class Store  implements Serializable{
        private long StoreID;
        private String StoreName;
        private String StoreAddress;
        private String TelephoneNumber;
        private String Email;
        private static int StoreIDCounter = 0;

    public Store(Store s){
        StoreID = s.StoreID;
        StoreName = s.StoreName;
        StoreAddress = s.StoreAddress;
        TelephoneNumber = s.TelephoneNumber;
        Email = s.Email;
    }

    public Store(long storeID, String storeName, String storeAddress, String telephoneNumber, String email) {
        StoreID = storeID;
        StoreName = storeName;
        StoreAddress = storeAddress;
        TelephoneNumber = telephoneNumber;
        Email = email;
    }

    public static int getStoreIDCounter() {
        return StoreIDCounter;
    }

    public long getStoreID() {
        return StoreID;
    }

    public String getStoreName() {
        return StoreName;
    }

    public String getStoreAddress() {
        return StoreAddress;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public String getEmail() {
        return Email;
    }




}
