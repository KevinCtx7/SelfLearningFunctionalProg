import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    //Chapter 2 Lesson 1
    protected static class C2L1MyMath {
        public static Integer Triple(Integer x) {
            return x * 3;
        }
    }

    //Chapter 2 Lesson 4
    protected static class C2L4Person {
        private String name;
        private Integer age;

        public C2L4Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {
        public final C2L3NoArgFunction<C2L4Person> loadPerson;

        protected DataLoader(boolean isDevelopment) {
            this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }

        private C2L4Person loadPersonReal() {
            System.out.println("Loading.....");
            return new C2L4Person("Real Person", 30);

        }

        private C2L4Person loadPersonFake() {
            System.out.println("Return Fake Person....");
            return new C2L4Person("Fake Person", 77);


        }
    }


    public static void main(String[] args) {
        streams_Collect();

    }

    public static void FirtClassFunction() {
        //Chapter 2 Lesson 1 : Function Interface
        //First is the type of argument, Second is the return type
//        Function<Integer,Integer> myTriple = C2L1MyMath::Triple;
//        Integer x = myTriple.apply(3);
//        System.out.println(x);


        //Chapter 2 Lesson 2 : Lambda Expression
//        Function<Integer,Integer> absoluteValue = (x)-> x < 0 ? -x : x;
//        System.out.println(absoluteValue.apply(-100));

        //Chapter 2 Lesson 3 : Bi Functions and Beyond
//        BiFunction<Integer,Integer,Integer> add = (x,y) -> x + y;
//        System.out.println(add.apply(32,32));
//
//        C2L3TriFunction<Integer,Integer,Integer,Integer> triAdd = (x,y,z) -> x + y + z;
//        System.out.println(triAdd.apply(1,2,3));
//
//        C2L3NoArgFunction<String> sayHello = () -> "Hello";
//        System.out.println(sayHello.apply());


        //Chapter 2 Lesson 4 : Function as Data
//        final Boolean IS_DEVELOPMENT = true;
//
//        DataLoader dataLoader = new DataLoader(true);
//        System.out.println(dataLoader.loadPerson.apply());

        //Chapter 2 Lesson 5 : Passing function as Argument
//        System.out.println(C2L5MyMath.combine(C2L5MyMath::add));
//        System.out.println(C2L5MyMath.combine(C2L5MyMath::subtract));
//        System.out.println(C2L5MyMath.combine((x,y)-> 2*y + 2*x));

        //Chapter 2 Lesson 6 : Returning Function
//        C2L3NoArgFunction<C2L3NoArgFunction<String>> createGreeter = () -> () -> "Hello Functional!";
//        C2L3NoArgFunction<String> greeter = createGreeter.apply();
//        System.out.println(greeter.apply());
//
//        Function<Integer,Integer> timesTwo =  C2L6MyMath.createMultiplier(2);
//        Function<Integer,Integer> timesTree =  C2L6MyMath.createMultiplier(3);
//        Function<Integer,Integer> timesFour =  C2L6MyMath.createMultiplier(4);
//
//
//
//        System.out.println(timesTwo.apply(6));
//        System.out.println(timesTree.apply(6));
//        System.out.println(timesFour.apply(6));

        //Chapter 2 Lesson 7
//        C2L3NoArgFunction<C2L3NoArgFunction<String>> createGreeter = () -> {
//            String name = "Test";
//            return () -> "Hello, " + name;
//        };
//
//        //It is able to still access name string even though it is at another function
//        C2L3NoArgFunction<String> greeter = createGreeter.apply();
//        System.out.println(greeter.apply());
//
//        //Chapter 2 Lesson 8
//        BiFunction<Float, Float, Float> divide = (x,y) -> x/y;
//
//
//        Function<BiFunction<Float, Float, Float> , BiFunction<Float, Float, Float>> secondDivide=
//                (func) -> (x,y) -> {
//                    if(y == 0f){
//                        System.out.println("Error ");
//                        return 0f;
//                    }
//                    return func.apply(x,y);
//                };
//
//        BiFunction<Float, Float, Float> divideSafe = secondDivide.apply(divide);
//
//        System.out.println(divideSafe.apply(10f,10f));


    }

    public static void streams_Map() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Function<Integer, Integer> timesTwo = x -> x * 2;

        //listOfIntegers.stream().map(timesTwo).toList();
        List<Integer> doubled = listOfIntegers.stream().map(timesTwo).collect(Collectors.toList());

        System.out.println(doubled);
    }

    public static void streams_Filter() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        List<Integer> evens = listOfIntegers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println(evens);

        String[] wordsArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));
        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan10 = createLengthTest.apply(10);

        List<String> longWords = words.stream().filter(isLongerThan10).collect(Collectors.toList());
        System.out.println(longWords);

    }

    public static void streams_Reduce() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc : " + acc + ", x: " + x + " result: " + result);
            return result;
        };

        Integer sum = listOfIntegers.stream().reduce(0, getSum);

        System.out.println(sum);

    }

    public static void streams_Collect() {
        String[] wordsArr = {"hello","apple", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));


        //String longWords = words.stream().filter( (str) -> str.length() > 5).collect(Collectors.joining(", "));
        // longWords = words.stream().filter( (str) -> str.length() > 5).collect(Collectors.counting());
        Map<Integer, List<String>> worldLengthMap = words.stream().collect(Collectors.groupingBy(
                (word) -> word.length()
        ));

        //true or false
        Map<Boolean, List<String>> worldHalfMap = words.stream().collect(Collectors.partitioningBy(
                (word) -> word.length() > 5
        ));


        System.out.println(worldHalfMap);
    }
}