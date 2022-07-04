/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

    private HashMap<String, List<String>> dict = new HashMap<>();
    private List<String> wordList = new ArrayList<>();

    public Anagrams(String list){
        try {
            Stream<String> stringStream = Files.lines(Paths.get(list));
            stringStream.forEach(word -> wordList.addAll(Arrays.asList(word.split("\\s"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String word :
                wordList) {
            char[] testChar = word.toCharArray();
            Arrays.sort(testChar);
            String test = new String(testChar);

            if (!dict.containsKey(test))
                dict.put(test, new ArrayList<>());
            dict.get(test).add(word);
        }

    }

    public Collection<List<String>> getSortedByAnQty(){
        Map<String, List<String>> res = dict.entrySet()
                .stream()
                .sorted(((o1, o2) -> {
                    int o11 = o1.getValue().size();
                    int o22 = o2.getValue().size();
                    if (o11 > o22)
                        return -1;
                    else return 1;
//                    return Integer.compare(o22, o11);
                }))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o1,o2) -> o1,
                        LinkedHashMap::new
                ));

        return res.values();

    }

    public String getAnagramsFor(String word){
        char[] testChar = word.toCharArray();
        Arrays.sort(testChar);
        String test = new String(testChar);

        String out = word + ": [" + dict.get(test).stream().filter(w -> !w.equals(word)).collect(Collectors.joining(",")) + "]";
        return out;
    }

}  
