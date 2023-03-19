package com.gumtree;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBookService {

    private final String MALE = "Male";
    private final String GEMMA_LANE = "Gemma Lane";
    private final String SARAH_STONE = "Sarah Stone";
    private final String WES_JACKSON = "Wes Jackson";
    private final File inputFile = new File("src/main/resources/addressBook.txt");
    private final FileReader fileReader = new FileReader();
    private final FileToAddressBookConverter fIleToAddressBookConverter = new FileToAddressBookConverter(fileReader);
    private final List<AddressBook> addressBookList = fIleToAddressBookConverter.convertLineToAddressBook(inputFile);

    public AddressBookService() {
    }

    public long howManyMalesAreInAddressBook() {
        return this.addressBookList.stream()
                .filter(addressBook -> addressBook.getGender().equals(MALE))
                .count();

    }

    public String whoIsTheOldestPersonInTheAddressBook() {
        AddressBook addressBook = this.addressBookList.stream()
                .min(Comparator.comparing(AddressBook::getDateOfBirth))
                .get();

        return addressBook.getFullName();
    }

    public long howManyDaysOlderIsBillThanPaul() {

        List<AddressBook> addressBooks = this.addressBookList.stream()
                .filter(Predicate.not(addressBook -> addressBook.getFullName().equalsIgnoreCase(GEMMA_LANE)))
                .filter(Predicate.not(addressBook -> addressBook.getFullName().equalsIgnoreCase(SARAH_STONE)))
                .filter(Predicate.not(addressBook -> addressBook.getFullName().equalsIgnoreCase(WES_JACKSON)))
                .collect(Collectors.toList());

        List<LocalDate> billAndPaulBirthdays = addressBooks.stream()
                .map(addressBook -> addressBook.getDateOfBirth())
                .collect(Collectors.toList());

        long diff = ChronoUnit.DAYS.between(billAndPaulBirthdays.get(0), billAndPaulBirthdays.get(1));
        return diff;
    }
}
