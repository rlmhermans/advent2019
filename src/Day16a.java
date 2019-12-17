import java.util.ArrayList;
import java.util.Arrays;

public class Day16a {


    public static void main(String[] args) {
        String input = "59766977873078199970107568349014384917072096886862753001181795467415574411535593439580118271423936468093569795214812464528265609129756216554981001419093454383882560114421882354033176205096303121974045739484366182044891267778931831792562035297585485658843180220796069147506364472390622739583789825303426921751073753670825259141712329027078263584903642919122991531729298497467435911779410970734568708255590755424253797639255236759229935298472380039602200033415155467240682533288468148414065641667678718893872482168857631352275667414965503393341925955626006552556064728352731985387163635634298416016700583512112158756656289482437803808487304460165855189";
        input = input.repeat(10000);
        char[] chars = input.toCharArray();
        int[] numbers = new int[chars.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        int index = 0;
        for (int i = 0; i < 7; i++) {
            index *= 10;
            index += numbers[i];
        }

        int[] pattern = {0, 1, 0, -1};

        for (int i = 0; i < 100; i++) {
            int[] newArray = new int[numbers.length];

            for (int m = 1; m <= numbers.length; m++) {
                ArrayList<Integer> al = new ArrayList();
                boolean secondPass = false;
                while (al.size() != numbers.length) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < m; k++) {
                            if ((!(j == 0 && k == 0)) || secondPass) {
                                if (al.size() != numbers.length) {
                                    al.add(pattern[j]);
                                }
                            } else {
                                secondPass = true;
                            }
                        }
                    }
                }

                int[] tempArray = new int[numbers.length];

                for (int j = 0; j < numbers.length; j++) {

                    tempArray[j] = numbers[j] * al.get(j);
                    newArray[m-1] = Math.abs(Arrays.stream(tempArray).sum()) % 10;
                }
            }

            numbers = newArray;
        }

        for (int i = index; i < index + 8; i++) {
            System.out.print(numbers[i]);
        }
    }
}
