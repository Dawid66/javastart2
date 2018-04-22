package pl.sda.javastart2.files;

import com.google.common.collect.Maps;
import pl.sda.javastart2.homework1.Customer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SuperProgram {

    public static void main(String[] args) {

        Map<Integer, Customer> deserialized = readDataFromFile();
        Map<Integer, Customer> map = deserialized.isEmpty() ? populateNewMap() : deserialized;
        writeToFile(map);
    }

    private static void writeToFile(Map<Integer, Customer> map) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("c:\\projects\\customers"));
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Map<Integer, Customer> readDataFromFile() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream =
                    new ObjectInputStream(new FileInputStream("c:\\projects\\customers"));
            return (Map<Integer, Customer>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Maps.newHashMap();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static HashMap<Integer, Customer> populateNewMap() {
        HashMap<Integer, Customer> map = Maps.newHashMap();
        map.put(1, new Customer("Magda", "Nowak", 23, 1023));
        return map;
    }
}
