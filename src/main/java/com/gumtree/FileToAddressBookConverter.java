package com.gumtree;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FileToAddressBookConverter {

    private final FileReader fileReader;

    public FileToAddressBookConverter(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<AddressBook> convertLineToAddressBook(File file) {
        List<String> addressBookStringList = fileReader.readLines(file);

        return addressBookStringList.stream()
                .map(this::mapStringsToAddressBook)
                .collect(Collectors.toList());
    }

    private AddressBook mapStringsToAddressBook(String raw) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        AddressBook addressBook = new AddressBook();
        String[] separatedRaw = raw.split(",");
        addressBook.setFullName(separatedRaw[0]);
        addressBook.setGender(separatedRaw[1].trim());
        LocalDate date = LocalDate.parse(separatedRaw[2].trim(), formatter);
        addressBook.setDateOfBirth(date.minusYears(100L));

        return addressBook;
    }

}
