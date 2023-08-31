public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            System.out.println(x);
            x = x + 1;
        }
    }
}


/*
1. Before Java variables can be used, they must be declared.
2. Java variables must have a specific type.
3. Java variable types can never change.
    ex. x = "horse"; 시 error 발생
4. Types are verified before the code even runs!!!
    - 파이썬과 달리 static code : debug 하기 쉬움
 */