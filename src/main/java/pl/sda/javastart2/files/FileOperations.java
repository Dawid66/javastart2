package pl.sda.javastart2.files;

import java.io.*;

public class FileOperations {

    private static String filePath = "C:\\projects\\pan.txt";

    public static void main(String[] args) {

//        rewriteFilesFromOneToAnotherNewWay();
//        readFileWithBufferedREader();
//        readFileWithBufferedREaderWithTryWithResources();


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
