package com.gumtree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readLines(File file) {
        try {
            List<String> addressBookList = Files.readAllLines(
                    file.toPath(), StandardCharsets.UTF_8);
            return addressBookList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

}
