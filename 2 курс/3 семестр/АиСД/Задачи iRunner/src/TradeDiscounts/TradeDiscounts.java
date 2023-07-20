package TradeDiscounts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TradeDiscounts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int b = Integer.parseInt(br.readLine());
        TD.product(b);
    }
}
class TD {
    public static int firstPrice;
    public static int secondPrice;
    public static int thirdPrice;
    public static int fourthPrice ;
    public static int fifthPrice ;
    public static int endStr;
    public static int endCol;
    public static int endLeft;
    public static int endRight;
    public static int end;
    public static int constant = 20;
    public static int discounts;
    public static int rebate;

    public static void product(int value) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");
        String[] str;
        ArrayList<String> prices = new ArrayList<>();
        ArrayList<String> tradeDiscounts = new ArrayList<>();
        int n = 0;
        int b = Integer.parseInt(br.readLine());
        while (n < b) {
            str = br.readLine().split(" ");
            if (Integer.parseInt(str[1]) >= 1 && Integer.parseInt(str[1]) <= 5 &&
                    Integer.parseInt(str[0]) >= 1 && Integer.parseInt(str[0]) <= 999 &&
                    Integer.parseInt(str[2]) >= 1 && Integer.parseInt(str[2]) <= 9999) {
                prices.addAll(Arrays.asList(str).subList(0, 3));
            } else {
                tradeDiscounts.add(str[0]);
                value--;
            }
            n++;
        }
        if (value == 0) {
            fw.write(String.valueOf(0));
            fw.close();
        } else if (value == 1) {
            int[] arr = new int[Integer.parseInt(String.valueOf(prices.get(1))) + 1];
            assigment(value, prices);
            for (int strInt = 0; strInt <= endStr; strInt++) {
                arr[strInt] = strInt * firstPrice;
            }
            discounts = Integer.parseInt(br.readLine());
            rebate = 0;
            int[] array;
            if (rebate < discounts) {
                do {
                    array = discount(br, prices, 1, tradeDiscounts);
                    if (array == null) {
                        rebate++;
                    } else {
                        arr[array[0]] = Math.min(array[1], arr[array[0]]);
                        for (int strInt = array[0]; strInt <= endStr; strInt++) {
                            arr[strInt] = Math.min(arr[strInt], arr[array[0]] + arr[strInt - array[0]]);
                        }
                        rebate++;
                        array[0] = 0;
                    }
                } while (rebate < discounts);
            }
            fw.write(String.valueOf(arr[endStr]));
            fw.close();
        } else if (value == 2) {
            int[][] matrix = new int[Integer.parseInt(String.valueOf(prices.get(1))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(4))) + 1];
            assigment(value, prices);
            {
                int strInt = 0;
                while (strInt <= endStr) {
                    int colums = 0;
                    while (colums <= endCol) {
                        matrix[strInt][colums] = strInt * firstPrice + colums * secondPrice;
                        colums++;
                    }
                    strInt++;
                }
            }
            discounts = Integer.parseInt(br.readLine());
            constant *= 4;
            rebate = 0;
            int[] array;
            if (rebate < discounts) {
                do {
                    constant = constant + 35;
                    array = discount(br, prices, 2, tradeDiscounts);
                    if (array != null) {
                        if (array[0] <= endStr && array[1] <= endCol) {
                            matrix[array[0]][array[1]] = Math.min(matrix[array[0]][array[1]], array[2]);
                            int strInt = array[0];
                            while (strInt <= endStr) {
                                int colums = array[1];
                                while (colums <= endCol) {
                                    matrix[strInt][colums] = Math.min(matrix[strInt][colums],
                                            matrix[array[0]][array[1]] + matrix[strInt - array[0]][colums - array[1]]);
                                    colums++;
                                }
                                strInt++;
                            }
                        }
                        int i = 0;
                        while (i < 2) {
                            array[i] = 0;
                            i++;
                        }
                    }
                    rebate++;
                } while (rebate < discounts);
            }
            fw.write(String.valueOf(matrix[endStr][endCol]));
            fw.close();
        } else if (value == 3) {
            int[][][] cube = new int[Integer.parseInt(String.valueOf(prices.get(1))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(4))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(7))) + 1];
            assigment(value, prices);
            {
                int strInt = 0;
                while (strInt <= endStr) {
                    int colums = 0;
                    while (colums <= endCol) {
                        int left = 0;
                        while (left <= endCol) {
                            cube[strInt][colums][left] = strInt * firstPrice + colums * secondPrice + left * thirdPrice;
                            left++;
                        }
                        colums++;
                    }
                    strInt++;
                }
            }

            discounts = Integer.parseInt(br.readLine());
            rebate = 0;
            int[] array;
            if (rebate < discounts) {
                do {
                    array = discount(br, prices, 3, tradeDiscounts);
                    if (array == null) {
                        rebate++;
                    } else {
                        if (array[0] <= endStr && array[1] <= endCol && array[2] <= endCol) {
                            cube[array[0]][array[1]][array[2]] = Math.min(cube[array[0]][array[1]][array[2]], array[3]);
                            int strInt = array[0];
                            while (strInt <= endStr) {
                                int colums = array[1];
                                while (colums <= endCol) {
                                    int left = array[2];
                                    while (left <= endCol) {
                                        cube[strInt][colums][left] = Math.min(cube[strInt][colums][left],
                                        Math.min(cube[array[0]][array[1]][array[2]] +
                                        cube[strInt - array[0]][colums - array[1]][left - array[2]],
                                        cube[array[0]][array[1]][array[2]] + cube[strInt - array[0]][0][0] +
                                        cube[0][colums - array[1]][0] + cube[0][0][left - array[2]]));
                                        left++;
                                    }
                                    colums++;
                                }
                                strInt++;
                            }
                        }
                        rebate++;
                        int i = 0;
                        while (i < 3) {
                            array[i] = 0;
                            i++;
                        }
                    }
                } while (rebate < discounts);
            }
            fw.write(String.valueOf(cube[endStr][endCol][endLeft]));
            fw.close();
        } else if (value == 4) {
            int[][][][] fourDimensionalArr = new int[Integer.parseInt(String.valueOf(prices.get(1))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(4))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(7))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(10))) + 1];
            assigment(value, prices);
            {
                int strInt = 0;
                while (strInt <= endStr) {
                    int colums = 0;
                    while (colums <= endCol) {
                        int left = 0;
                        while (left <= endLeft) {
                            int right = 0;
                            while (right <= endRight) {
                                fourDimensionalArr[strInt][colums][left][right] =
                                        strInt * firstPrice + colums * secondPrice + left * thirdPrice + fourthPrice * right;
                                right++;
                            }
                            left++;
                        }
                        colums++;
                    }
                    strInt++;
                }
            }
            discounts = Integer.parseInt(br.readLine());
            rebate = 0;
            int[] array;
            if (rebate < discounts) {
                do {
                    array = discount(br, prices, 4, tradeDiscounts);
                    if (array == null) {
                        rebate++;
                    } else {
                        if (array[0] <= endStr && array[1] <= endCol && array[2] <= endLeft && array[3] <= endRight) {
                            fourDimensionalArr[array[0]][array[1]][array[2]][array[3]] =
                                    Math.min(array[4], fourDimensionalArr[array[0]][array[1]][array[2]][array[3]]);
                            int strInt = array[0];
                            while (strInt <= endStr) {
                                int colums = array[1];
                                while (colums <= endCol) {
                                    int left = array[2];
                                    while (left <= endLeft) {
                                        int right = array[3];
                                        while (right <= endRight) {
                                            fourDimensionalArr[strInt][colums][left][right] = Math.min(fourDimensionalArr[strInt][colums][left][right],
                                                    fourDimensionalArr[array[0]][array[1]][array[2]][array[3]] +
                                                            fourDimensionalArr[strInt - array[0]][colums - array[1]][left - array[2]][right - array[3]]);
                                            right++;
                                        }
                                        left++;
                                    }
                                    colums++;
                                }
                                strInt++;
                            }
                        }
                        rebate++;
                        int i = 0;
                        while (i < 4) {
                            array[i] = 0;
                            i++;
                        }
                    }
                } while (rebate < discounts);
            }
            fw.write(String.valueOf(fourDimensionalArr[endStr][endCol][endLeft][endRight]));
            fw.close();
        } else if (value == 5) {
            int[][][][][] fiveDimensionalArr = new int[Integer.parseInt(String.valueOf(prices.get(1))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(4))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(7))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(10))) + 1]
                    [Integer.parseInt(String.valueOf(prices.get(13))) + 1];
            assigment(value, prices);
            {
                int strInt = 0;
                while (strInt <= endStr) {
                    int colums = 0;
                    while (colums <= endCol) {
                        int left = 0;
                        while (left <= endLeft) {
                            int right = 0;
                            while (right <= endRight) {
                                int last = 0;
                                while (last <= end) {
                                    fiveDimensionalArr[strInt][colums][left][right][last] =
                                            strInt * firstPrice + colums * secondPrice +
                                                    left * thirdPrice + fourthPrice * right + fifthPrice * last;
                                    last++;
                                }
                                right++;
                            }
                            left++;
                        }
                        colums++;
                    }
                    strInt++;
                }
            }
            discounts = Integer.parseInt(br.readLine());
            rebate = 0;
            int[] array;
            if (rebate < discounts) {
                do {
                    array = discount(br, prices, 5, tradeDiscounts);
                    if (array == null) {
                        rebate++;
                    } else {
                        if (array[0] <= endStr && array[1] <= endCol &&
                                array[2] <= endLeft && array[3] <= endRight && array[4] <= end) {
                            fiveDimensionalArr[array[0]][array[1]][array[2]][array[3]][array[4]] =
                                    Math.min(fiveDimensionalArr[array[0]][array[1]][array[2]][array[3]][array[4]], array[5]);
                            int strInt = array[0];
                            while (strInt <= endStr) {
                                int colums = array[1];
                                while (colums <= endCol) {
                                    int left = array[2];
                                    while (left <= endLeft) {
                                        int right = array[3];
                                        while (right <= endRight) {
                                            int last = array[4];
                                            while (last <= end) {
                                                fiveDimensionalArr[strInt][colums][left][right][last] =
                                                Math.min(fiveDimensionalArr[strInt][colums][left][right][last],
                                                fiveDimensionalArr[array[0]][array[1]][array[2]][array[3]][array[4]] +
                                                fiveDimensionalArr[strInt - array[0]][colums - array[1]][left - array[2]][right - array[3]][last - array[4]]);
                                                last++;
                                            }
                                            right++;
                                        }
                                        left++;
                                    }
                                    colums++;
                                }
                                strInt++;
                            }
                        }
                        rebate++;
                        for (int i = 0; i < 5; i++) {
                            array[i] = 0;
                        }
                    }
                } while (rebate < discounts);
            }
            fw.write(String.valueOf(fiveDimensionalArr[endStr][endCol][endLeft][endRight][end]));
            fw.close();
        }
    }

    public static void assigment(int value, ArrayList<String> arrayList) {
        if (value == 1 || value == 2 || value == 3 || value == 4 || value == 5) {
            firstPrice = Integer.parseInt(String.valueOf(arrayList.get(2)));
            endStr = Integer.parseInt(String.valueOf(arrayList.get(1)));
        }
        if (value == 2 || value == 3 || value == 4 || value == 5) {
            secondPrice = Integer.parseInt(String.valueOf(arrayList.get(5)));
            endCol = Integer.parseInt(String.valueOf(arrayList.get(4)));
        }
        if (value == 3|| value == 4 || value == 5) {
            thirdPrice = Integer.parseInt(String.valueOf(arrayList.get(8)));
            endLeft = Integer.parseInt(String.valueOf(arrayList.get(7)));
        }
        if (value == 4|| value == 5) {
            fourthPrice = Integer.parseInt(String.valueOf(arrayList.get(11)));
            endRight = Integer.parseInt(String.valueOf(arrayList.get(10)));
        }
        if (value == 5) {
            fifthPrice = Integer.parseInt(String.valueOf(arrayList.get(14)));
            end = Integer.parseInt(String.valueOf(arrayList.get(13)));
        }
    }

    static int[] discount(BufferedReader br, ArrayList<String> prices, int discounts, ArrayList<String> tradeDiscounts) throws IOException {
        int[] arr = new int[discounts + 3];
        String discount = br.readLine();
        String[] allowance = discount.split(" ");
        int k = 0;
        for (String o : tradeDiscounts) {
            for (int discc = 1; discc < allowance.length - 1; discc = discc + 2) {
                if (Integer.parseInt(o) == Integer.parseInt(allowance[discc])) {
                    return null;
                }
            }
        }
        int i = 0;
        int iDiscount = 1;
        int iAllowance = 2;
        while (i < Integer.parseInt(allowance[0])) {
            int key = 0;
            while (key < prices.size()) {
                if (Integer.parseInt(String.valueOf(prices.get(key))) == Integer.parseInt(allowance[iDiscount])) {
                    arr[k] = Integer.parseInt(allowance[iAllowance]);
                }
                k++;
                key = key + 3;
            }
            k = 0;
            i++;
            iDiscount += 2;
            iAllowance += 2;
        }
        arr[discounts] = Integer.parseInt(allowance[allowance.length - 1]);
        return arr;
    }
}
