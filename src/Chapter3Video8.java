import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter3Video8 {

    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        List<String> processedWords = words.parallelStream().map((word)->{
            System.out.println("Uppercasing word: "+ word);
            return word.toUpperCase();
        })
                .map((word) ->{
                    System.out.println("Adding exclamation word: "+ word);
                    return word + "!";
                })
                .collect(Collectors.toList());


        System.out.println(processedWords);

    }
}
