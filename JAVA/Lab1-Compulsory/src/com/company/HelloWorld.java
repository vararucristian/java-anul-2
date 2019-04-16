package com.company; /**
 * authors
*Turcu Ana Maria
*Vararu Cristian
*/
import java.util.Vector;

public class HelloWorld {
public
    String languages[];
    int n;
    HelloWorld()
    {
        languages= new String[]{"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};
        n=(int) (Math.random() * 1_000_000);
    }
    int calculate()
    {
        n=(n*3+0b10101+0xFF)*6;
        return n;
    }
    int SumOFDigits(int n)
    {
        int sumOfDigits=0;
        do {
            sumOfDigits=0;
            while (n > 0) {
                sumOfDigits = n % 10 + sumOfDigits;
                n = n / 10;
            }
            n=sumOfDigits;
        } while (n>9);
    return sumOfDigits;
    }
}
