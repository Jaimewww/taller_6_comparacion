package main.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static int[] readColumn(String filePath, String columnName) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreSurroundingSpaces(true)
                .build();
        List<Integer> intList = new ArrayList<>();
        try(Reader reader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(reader, csvFormat)){
                for (CSVRecord csvRecord : csvParser) {
                    String value = csvRecord.get(columnName);
                    String cleanedValue = value.replaceAll("[^0-9]", "");
                    if(!cleanedValue.isEmpty()){
                        try{
                            int intValue = Integer.parseInt(cleanedValue);
                            intList.add(intValue);
                        } catch (NumberFormatException e){
                            System.err.println("Advertencia: No se pudo convertir '" + value +
                                    "' (limpio: '" + cleanedValue + "') a entero y será omitido.");
                        }
                    }
                }
            }
        return intList.stream().mapToInt(i -> i).toArray();
    }
}
