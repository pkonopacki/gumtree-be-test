package com.gumtree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressBookServiceTest {

    private final int NUMBER_OF_MALES = 3;
    private static AddressBookService addressBookService;

    @BeforeAll
    public static void init() {
        addressBookService = new AddressBookService();
    }

    @Test
    public void givenCorrectFile_whenCallingHowManyMalesInAddressBook_thenReturnNumberOfMales() {

        long numberOfMalesInAddressBook = this.addressBookService.howManyMalesAreInAddressBook();

        assertFalse(numberOfMalesInAddressBook == 0);
        assertEquals(numberOfMalesInAddressBook, NUMBER_OF_MALES);
    }

    @Test
    public void givenCorrectFile_whenCallingWhoIsTheOldestInAddressBook_thenReturnNameAndSurnameOfOldestPerson() {

        String nameAndSurnameOfTheOldest = this.addressBookService.whoIsTheOldestPersonInTheAddressBook();

        assertNotNull(nameAndSurnameOfTheOldest);
        assertEquals(nameAndSurnameOfTheOldest, "Wes Jackson");
    }

    @Test
    public void givenCorrectFile_whenCallingHowManyDaysOlderIsBillThanPaul_thenReturnTheDifferenceInDays() {

        long differenceInDays = this.addressBookService.howManyDaysOlderIsBillThanPaul();

        assertNotNull(differenceInDays);
        assertEquals(differenceInDays, 2862);
    }

}
