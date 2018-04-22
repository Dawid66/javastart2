package pl.sda.javastart2.homework1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Collections1 {
    //Napisz metodę przetwarzającą podaną tablicę animals na set
    // z zachowaniem kolejności elementów z oryginalnej tablicy
    // + należy zapewnić poprawne wyelimowanie duplikatów (" dog" "dog")
    public static void main(String[] args) {
        String[] animals = new String[]{"cat", "dog ", "mouse", "rat",
                "pig", "rabbit", "hamster", " ", "parrot", "cat", "",
                "dog", "cat", "  pig", "dog",null};
        changeToSet(animals);
        changeToSetWithStream(animals);
        Lists.newArrayList("cat", "dog");
        Sets.newHashSet("cat", "dog");
        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();

    }

    private static Set<String> changeToSetWithStream(String[] animals) {
        return Arrays.stream(animals)
                .filter(e->StringUtils.isNotBlank(e))
                .map(e->e.trim())
                .collect(Collectors.toCollection(() -> new LinkedHashSet<>()));
    }

    private static Set<String> changeToSet(String[] animals) {
        Set<String> result = new LinkedHashSet<>();
        for (String animal : animals) {
            if(StringUtils.isBlank(animal)) {
                continue;
            }
            result.add(animal.trim());
        }
        return result;
    }
}
