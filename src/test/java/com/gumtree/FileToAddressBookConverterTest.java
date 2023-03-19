package com.gumtree;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileToAddressBookConverterTest {

    @Test
    public void givenCorrectFile_whenConvertLineToAddressBook_thenReturnArrayListOfAddressBook() {
        File inputFile = new File("src/test/resources/addressBook.txt");
        FileReader fileReader = new FileReader();
        FileToAddressBookConverter converter = new FileToAddressBookConverter(fileReader);

        List<AddressBook> addressBookList = converter.convertLineToAddressBook(inputFile);

        assertNotNull(addressBookList);
        assertEquals(addressBookList.get(0).getFullName(), "Bill McKnight");
        assertEquals(addressBookList.get(1).getFullName(), "Paul Robinson");
        assertEquals(addressBookList.get(2).getFullName(), "Gemma Lane");
        assertEquals(addressBookList.get(3).getFullName(), "Sarah Stone");
        assertEquals(addressBookList.get(4).getFullName(), "Wes Jackson");

        assertEquals(addressBookList.get(0).getGender(), "Male");
        assertEquals(addressBookList.get(1).getGender(), "Male");
        assertEquals(addressBookList.get(2).getGender(), "Female");
        assertEquals(addressBookList.get(3).getGender(), "Female");
        assertEquals(addressBookList.get(4).getGender(), "Male");

        assertEquals(addressBookList.get(0).getDateOfBirth(),
                LocalDate.parse("1977-03-16"));
        assertEquals(addressBookList.get(1).getDateOfBirth(),
                LocalDate.parse("1985-01-15"));
        assertEquals(addressBookList.get(2).getDateOfBirth(),
                LocalDate.parse("1991-11-20"));
        assertEquals(addressBookList.get(3).getDateOfBirth(),
                LocalDate.parse("1980-09-20"));
        assertEquals(addressBookList.get(4).getDateOfBirth(),
                LocalDate.parse("1974-08-14"));
    }

    @Test
    public void givenMalformedFile_whenConvertLineToAddressBook_thenThrowException() {
        File inputFile = new File("src/test/resources/addressBookMalformed.txt");
        FileReader fileReader = new FileReader();
        FileToAddressBookConverter converter = new FileToAddressBookConverter(fileReader);

        ArrayIndexOutOfBoundsException thrown = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            List<AddressBook> addressBookList = converter.convertLineToAddressBook(inputFile);

        }, "ArrayIndexOutOfBoundsException was expected");

        assertEquals("Index 2 out of bounds for length 2", thrown.getMessage());

    }
}
