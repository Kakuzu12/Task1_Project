import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main
{
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your array:");
            String[] integersInString = bufferedReader.readLine().split(" ");
            int array[] = new int[integersInString.length];
            for (int i = 0; i < integersInString.length; i++) {
                array[i] = Integer.parseInt(integersInString[i]);
            }
            System.out.println("Enter what number you would like to find:");
            int desiredNumber = Integer.parseInt(bufferedReader.readLine());
            array=bubbleSort(array);
            System.out.print("Sorted array: ");
            System.out.println(Arrays.toString(array));
            int initialFirstIndex = 0;
            int initialLastIndex = array.length - 1;
            int resultedIndex = findNumber(array, desiredNumber, initialFirstIndex, initialLastIndex);
            System.out.print("Index of your number is ");
            System.out.print(resultedIndex);
        }
        catch(IOException e){
            System.out.println("Mistake!");
        }
        catch (NumberFormatException e) {
            System.out.println("Incorrect input! Only integers are allowed!");
        }
    }
    public static int findNumber (int[] array, int desiredNumber, int leastIndex, int highestIndex) {
        int indexOfDesiredNumber = -1;
        while (leastIndex <= highestIndex) {
            int middleIndex = (leastIndex + highestIndex) / 2;
            if (array[middleIndex] < desiredNumber) {
                leastIndex = middleIndex + 1;
            } else if (array[middleIndex] > desiredNumber) {
                highestIndex = middleIndex - 1;
            } else if (array[middleIndex] == desiredNumber) {
                indexOfDesiredNumber = middleIndex;
                break;
            }
        }
        return indexOfDesiredNumber;
    }
    public static int[] bubbleSort (int[] array) {
        boolean check = false;
        int variableToChangeValues;
        while (!check) {
            check = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    check = false;
                    variableToChangeValues = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = variableToChangeValues;
                }
            }
        }
        return array;
    }
}

