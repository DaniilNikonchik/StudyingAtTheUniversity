package Laba2;

import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Print the size: ");
        int sizeOfArr = Integer.parseInt(in.nextLine());
        System.out.println("Print numbers: ");
        int[] array = new int[sizeOfArr];
        for(int i = 0; i < sizeOfArr; i++) {
            array[i] = in.nextInt();
        }
        System.out.println("Numbers in words: ");
        for(int i = 0; i < sizeOfArr; i++) {
            System.out.println(ConvertNumberToWords.convertToWords(array[i]));
        }
    }
}
class ConvertNumberToWords {
    private static final String digitalOneToNine[] = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String digitalTenToNineteen[]  = {"десять","одиннадцать", "двенадцать",
            "тринадцать","четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String digitalTwentyToNinety[]  = {"двадцать", "тридцать", "сорок", "пятьдесят","шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String digitalHundredToNineHundred[] =    {"сто","двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    private static final int TEN = 10;
    private static final int HUNDREDS = 100;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = (long) 1E12;

    private static String getNumInWords(short number) {
        StringBuilder result = new StringBuilder(100);
        if (number == 0) {
            return "ноль";
        }
        int hundreds = number / HUNDREDS;
        int thousand = number % HUNDREDS;
        int decimals = thousand / TEN;
        int one = thousand % TEN;
        switch(hundreds) {
            case 0: break;
            default:result.append(" ").append(digitalHundredToNineHundred[hundreds - 1]);
        }
        switch(decimals) {
            case 0: break;
            case 1:
                result.append(" ").append(digitalTenToNineteen[one]);
                return result.toString().trim();
            default:result.append(" ").append(digitalTwentyToNinety[decimals - 2]);
        }
        switch(one) {
            case 0:
                break;
            case 1:result.append(" ").append(digitalOneToNine[0]);
                break;
            case 2:result.append(" ").append(digitalOneToNine[1]);
                break;
            default:result.append(" ").append(digitalOneToNine[one - 1]);
        }
        return result.toString().trim();
    }

    private  static short[] getDigits(long number) {
        long number1 = number;
        long num = TRILLION;
        short [] arr = new short [5];
        for (byte i = 4; i >= 0; i--) {
            short nInDigital = (short) (number1 / num);
            arr[i] = nInDigital;
            number1 = number1 - nInDigital * num;
            num = num / THOUSAND;
        }
        return arr;
    }

    public static String convertToWords(long number) {
        if (number < -1000 || number > 1000)
            throw new IllegalArgumentException("Заданное число больше 1000 или меньше -1000");
        StringBuilder result = new StringBuilder(1000);
        if (number == 0) {
            return "ноль";
        }
        long negativeNumber = number;
        if( number < 0) {
            negativeNumber =- number;
            result.append("минус ");
        }
        short arr [] = getDigits(negativeNumber);
        for (int i = 4; i >= 0; i--) {
            if (arr[i] > 0) {
                result.append(getNumInWords(arr[0]));
            }
        }
        return result.toString().trim();
    }
}
