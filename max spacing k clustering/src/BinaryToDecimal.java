public class BinaryToDecimal {
    public static void main(String[] args) {
        String binaryString = "101111100110000100001110";
        int decimalNumber = Integer.parseInt(binaryString, 2);

        System.out.println("Binary: " + binaryString);
        System.out.println("Decimal: " + decimalNumber);
    }
}