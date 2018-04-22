package pl.sda.javastart2.files;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperations {

    private static String filePath = "C:\\projects\\pan.txt";

    public static void main(String[] args) {

//        rewriteFilesFromOneToAnotherNewWay();
//        readFileWithBufferedREader();
//        readFileWithBufferedREaderWithTryWithResources();
        countWords();
//        splitLine();

    }

    private static void splitLine() {
        String invocation = "    Litwo! Ojczyzno moja! ty jesteś jak zdrowie:";
        String[] splittedBySpacebar = invocation.split(" ");
        System.out.println(Arrays.toString(splittedBySpacebar));
        String[] splittedByS = invocation.split("\\s+");
        System.out.println(Arrays.toString(splittedByS));
        String[] splittedByNonWords = invocation.split("[^\\p{L}]+"); //polish words included
        System.out.println(Arrays.toString(splittedByNonWords));

    }

    private static void countWords() {
        File file = Paths.get(filePath).toFile();
        try {
            List<String> words = Lists.newArrayList();
            List<String> lines = Files.readLines(file, Charset.forName("UNICODE"));
            for (String line : lines) {
                if (StringUtils.isBlank(line)) {
                    continue; //omijamy puste linijki
                }
                words.addAll(Arrays.asList(line.split("[^\\p{L}]+")));
            }
            Map<String, Long> wordCountMap = words.stream()
                    .filter(e -> StringUtils.isNotBlank(e))
                    .collect(Collectors.groupingBy(
                            e -> e,
                            Collectors.counting()
                    ));
            System.out.println(wordCountMap);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithBufferedREaderWithTryWithResources() {
        try (FileReader fileReader = new FileReader(filePath);) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithBufferedREader() { //u góry jest przykład z try with resources
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void rewriteFilesFromOneToAnotherNewWay() {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             FileOutputStream fileOutputStream =
                     new FileOutputStream(filePath.replace("pan.txt", "pan-kopia.txt"));) {
            int b;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
