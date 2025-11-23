package main;

import main.util.CsvReader;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static final String PATH_CSV = "src/main/resources/citas_100.csv";
    public static final String COLUMN_NAME = "fechaHora";

    public static void main(String[] args) {
        try {
            int[] result = CsvReader.readColumn(PATH_CSV, COLUMN_NAME);
            System.out.println(Arrays.toString(result));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
