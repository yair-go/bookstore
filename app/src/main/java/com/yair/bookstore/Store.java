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
