package CodeForces;
import java.util.Scanner;

public class LongComp {

    static StringBuilder getFinalNumber(String num, int zeros) {
        StringBuilder result = new StringBuilder(num);
        for (int i = 0; i < zeros; i++) {
            result.append('0');
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t--;
            String num1 = sc.next();
            int n1 = sc.nextInt();
            String num2 = sc.next();
            int n2 = sc.nextInt();

            int len1 = num1.length();
            int len2 = num2.length();

            // Adjust lengths based on trailing zeros
            len1 += n1;
            len2 += n2;

            if (len1>len2){
                System.out.println(">");
            }else if (len1<len2){
                System.out.println("<");
            }else{
                int min_zeros = Math.min(n1, n2);
                n1 = n1-min_zeros;
                n2 = n2-min_zeros;
                StringBuilder _1 = getFinalNumber(num1, n1);
                StringBuilder _2 = getFinalNumber(num2, n2);
                int comp = _1.toString().compareTo(_2.toString());
                if (comp == 0){
                    System.out.println("=");
                }else if (comp > 0){
                    System.out.println(">");
                }else{
                    System.out.println("<");
                }
            }
        }
        sc.close();
    }
}
