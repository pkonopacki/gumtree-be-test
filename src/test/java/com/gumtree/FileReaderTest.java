package com.gumtree;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {

    @Test
    public void givenCorrectFile_whenReadLines_thenReturnArrayOfLines() {
        File inputFile = new File("src/test/resources/addressBook.txt");
        FileReader fileReader = new FileReader();

        List<String> stringList = fileReader.readLines(inputFile);

        assertNotNull(stringList);
        assertEquals(stringList.size(), 5);
        assertEquals(stringList.get(0), "Bill McKnight, Male, 16/03/77");
        assertEquals(stringList.get(1), "Paul Robinson, Male, 15/01/85");
        assertEquals(stringList.get(2), "Gemma Lane, Female, 20/11/91");
        assertEquals(stringList.get(3), "Sarah Stone, Female, 20/09/80");
        assertEquals(stringList.get(4), "Wes Jackson, Male, 14/08/74");
    }

    @Test
    public void givenEmptyFile_whenReadLines_thenReturnEmptyArray() {
        File inputFile = new File("src/test/resources/addressBookEmpty.txt");
        FileReader fileReader = new FileReader();

        List<String> stringList = fileReader.readLines(inputFile);

        assertNotNull(stringList);
        assertEquals(stringList.size(), 0);
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