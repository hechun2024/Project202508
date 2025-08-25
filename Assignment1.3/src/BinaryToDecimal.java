import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) { //interating from left to right 0,1,2,3.....
            char bit = binary.charAt(i); // 取出每一位

            if (bit == '1') {
                // 计算对应的2的幂次方
                decimal += Math.pow(2, binary.length() - 1 - i);
            } else if (bit != '0') {
                System.out.println("Wrong input: only allowed 0 or 1");
                return;
            }
        }

        System.out.println("decimal equivalent : " + decimal);

        //scanner.close();
    }
}