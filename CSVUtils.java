package br.com.sefin.service.utils;

import br.com.sefin.service.dto.csv.ExportCSV;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.InputStreamResource;

public class CSVUtils {

    private static final String DELIMITER = ",";

    public static InputStreamResource toCSV(List<ExportCSV> list, Class clazz)
        throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Path tempFile = Files.createTempFile("data_analitycs_", ".csv");
        Writer writer = Files.newBufferedWriter(tempFile);

        writer.append(buildHeader(clazz));

        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(list);

        writer.flush();
        writer.close();

        InputStream inputStream = new FileInputStream(tempFile.toFile());
        return new InputStreamResource(inputStream);
    }

    private static String buildHeader(Class clazz) {
        return (
            Arrays
                .stream(clazz.getDeclaredFields())
                .filter(f -> f.getAnnotation(CsvBindByPosition.class) != null && f.getAnnotation(CsvBindByName.class) != null)
                .sorted(Comparator.comparing(f -> f.getAnnotation(CsvBindByPosition.class).position()))
                .map(f -> f.getAnnotation(CsvBindByName.class).column())
                .collect(Collectors.joining(DELIMITER)) +
            "\n"
        );
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
