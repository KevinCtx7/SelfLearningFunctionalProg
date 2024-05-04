public class RecursionChallenge {

    //1 1 2 3 5 8 13
    static int fibonacci(int x){
        if( x <= 2){
            return 1;
        }

        return fibonacci(x - 1) + fibonacci(x - 2);


    }

    public static void main(String[] args){
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(17));

    }
}
