package com.epam.olha_yeskina.java.lesson_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer{
    public static void main (String [] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Dreyk\\Desktop\\example.txt")); //create a scanner

     //   welcome(); //print welcome message

      //  String line= console.nextLine(); //store first line in variable line

        int docNumber=0; //create variable docNumber, start at 0

        Map<String, Integer> statistics = new HashMap<>();
        while(scanner.hasNext()){
            String word = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word);
            if(count ==null){
                count = 0;
            }
            statistics.put(word, ++count);
        }
        System.out.println(statistics);
        System.out.println(operation1(scanner, (HashMap<String, Integer>) statistics));
        //System.out.println(statistics);
    }

//Вывести два наиболее встречаемых слова, слова отсортировать их в алфавитном порядку по убыванию, и вывести сколько раз слово встречается в тексте.
//
//good -> 23
//allow -> 2
public static HashMap<String,Integer> operation1(Scanner scanner, HashMap<String, Integer> statistics){
    Map<String, Integer> map = new HashMap<>();
    Map.Entry<String,Integer> maxEntry1 = null;
    Map.Entry<String,Integer> maxEntry2 = null;
    for (Map.Entry<String,Integer> entry : statistics.entrySet())
    {
        if (maxEntry1 == null || entry.getValue().compareTo(maxEntry1.getValue()) > 0)
        {
            maxEntry1 = entry;
        }
    }
    System.out.println(maxEntry1);
    statistics.remove(maxEntry1.getKey());
    map.put(maxEntry1.getKey(), maxEntry1.getValue());
    for (Map.Entry<String,Integer> entry : statistics.entrySet())
    {
        if (maxEntry2 == null || entry.getValue().compareTo(maxEntry2.getValue()) > 0)
        {
            maxEntry2 = entry;
        }
    }
    System.out.println(maxEntry2);
    statistics.remove(maxEntry2.getKey());
    map.put(maxEntry2.getKey(), maxEntry2.getValue());
    System.out.println("After sorting descending order......");
    Map<String, Integer> sortedMapDesc = sortByValue(map, false);
    System.out.println(sortedMapDesc);
        return statistics;
}

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    //method for printing welcome statement
}
