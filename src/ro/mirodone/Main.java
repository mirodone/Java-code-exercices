package ro.mirodone;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

      double result;
    // result = evaluate("2 + 5");

     result = evaluate("3 * 2 + 3 / 4 + 2");

        System.out.println(result);

    }

    private static Double evaluate (String expression) {

        String [] splitEx = expression.split(" ");
        Stack<Double> s = new Stack<>();

        for ( int i =0; i< splitEx.length; i=i+2) {
            if (i ==0 || splitEx[i-1].equals("+")){
                s.push(Double.valueOf(splitEx[i]));
            }else if(splitEx[i-1].equals("-")){
                s.push(-Double.valueOf(splitEx[i]));
            }else if(splitEx[i-1].equals("*")){
                s.push(s.pop()*Double.valueOf(splitEx[i]));
            }else if (splitEx[i-1].equals("/")){
                s.push(s.pop()/Double.valueOf(splitEx[i]));
            }
        }
        double r = 0.0;
        while (!s.isEmpty()){
            r = r +s.pop();
        }

        return r;
    }

}
