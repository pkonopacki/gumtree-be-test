package com.gumtree;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AddressBookService addressBookService = new AddressBookService();

        long malesCount = addressBookService.howManyMalesAreInAddressBook();
        String theOldestPersonInAddressBook = addressBookService.whoIsTheOldestPersonInTheAddressBook();
        long daysBillOlderThanPaul = addressBookService.howManyDaysOlderIsBillThanPaul();

        System.out.println(String.format("There are %d males in the AddressBook", malesCount));
        System.out.println(String.format("%s is the oldest person in the AddressBook", theOldestPersonInAddressBook));
        System.out.println(String.format("Bill is older than Paul by %d days", daysBillOlderThanPaul));
    }

}
