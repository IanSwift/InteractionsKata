package main.com.anarcode.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new MyParser(), new MyAdder(), new FileLogger("output.txt"), new MyWebService());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("Enter an expression:");
            try {
                String in = br.readLine();
                int sum = calculator.add(in);
                System.out.println("sum = " + sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
