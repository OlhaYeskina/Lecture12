package com.epam.olha_yeskina.java.lesson_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer{
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("C:\\Users\\Dreyk\\Desktop\\example.txt")); //create a scanner
//
//
//        Map<String, Integer> statistics = new HashMap<>();
//        while (scanner.hasNext()) {
//            String word = scanner.useDelimiter("\\s+").next();
//            Integer count = statistics.get(word);
//            if (count == null) {
//                count = 0;
//            }
//            statistics.put(word, ++count);
//        }
//        System.out.println("Words in the file and their number:\n" + statistics);
        //System.out.println(operation1(scanner, (HashMap<String, Integer>) statistics));

        //System.out.println(operation2(scanner, (HashMap<String, Integer>) statistics));

        List<String> list = new LinkedList<>();

        Scanner scan = new Scanner(new File("C:\\Users\\Dreyk\\Desktop\\example.txt"));
        String word = "";
        while (scan.hasNext()) {
            word = scan.useDelimiter("\\s+").next();
            list.add(word);
        }
//        System.out.println(list);

 //       operation2(list);

        Scanner scanner = new Scanner(new File("C:\\Users\\Dreyk\\Desktop\\example.txt"));
        Map<String, Integer> statistics = new HashMap<>();
        while (scanner.hasNext()) {
            String word3 = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word3);
            if (count == null) {
                count = 0;
            }
            statistics.put(word3, ++count);
        }

//        operation1(statistics);
        operation3(statistics);
    }

    //Вывести два наиболее встречаемых слова, слова отсортировать их в алфавитном порядку по убыванию, и вывести сколько раз слово встречается в тексте.
    public static void operation1(Map<String, Integer> items) {

        Map<String, Integer> sortedMap = items.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
       // System.out.println(sortedMap);
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()){
        if (count < 2) {
                System.out.println(entry.getKey() + "->" + entry.getValue());
                count++;
            }
        }
    }


    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }


    public static void operation2(List<String> list) {

        String[] longestWord = {"", "", ""};
        for (int i = 0; i < 3; i++) {
            for (String l : list
            ) {
                if (l.length() > longestWord[i].length()) {
                    longestWord[i] = l;
                }
            }

            list.remove(longestWord[i]);

        }
        Arrays.sort(longestWord);
        for (int i = 0; i < 3; i++) {
            System.out.println(longestWord[i] + "->" + longestWord[i].length());
        }
    }

    public static void operation3(Map<String, Integer> items) {
        System.out.println(items);
        Map<String, Integer> sortedMap = items.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedMap);

      //  List<String> list = new ArrayList<String>(sortedMap.values());

// or you may use
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
        {
            list.add(entry.getKey());
        }
        List<String> list2 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if(!list.get(list.size() - i).isEmpty())
            list2.add(list.get(list.size() - i));
        }
//        list2.add(list.get(list.size() - 1));
//        list2.add(list.get(list.size() - 2));
//        list2.add(list.get(list.size() - 3));
        System.out.println(list2);
        List<String> upped = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upped);



        List<String> reverse = new ArrayList<>();
       // String str = "абвгдеёжзи";
       // String reverse = new StringBuffer(str).reverse().toString();
        for (String str: upped) {
            reverse.add(new StringBuffer(str).reverse().toString());
        }
        System.out.println(reverse);
    }



}
