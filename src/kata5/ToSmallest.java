package kata5;

public class ToSmallest {
    public static long[] smallest(long n) {
        int[] numbers = translateTheNumberIntoAnArrayOfNumbers(n);
        long[] firstResult = new long[3];
        if (numbers[0] > 0) {
            checkTheFirstNumber(firstResult, numbers);
        }
        int indexSmallerNumber = findSmallerNumber(numbers, -1);
        long[] secondResult = formTheResultingArray(numbers, indexSmallerNumber);
        if (firstResult[0] > 0 && firstResult[0] < secondResult[0]) {
            return firstResult;
        } else {
            return secondResult;
        }
    }

    private static void checkTheFirstNumber(long[] firstResult, int[] numbers) {
        int indexTook = 0;
        int indexInsert = numbers.length - 1;
        int digit = numbers[indexTook];
        for (int i = 1; i < numbers.length; i++) {
            if (digit < numbers[i]) {
                indexInsert = i - 1;
                break;
            }
            if (i == numbers.length - 1){
                indexInsert = i;
            }
        }
        int[] newNumbers = new int[numbers.length];
        System.arraycopy(numbers, 0, newNumbers, 0, newNumbers.length);
        System.arraycopy(numbers, indexTook + 1, newNumbers, indexTook, indexInsert - indexTook);
        newNumbers[indexInsert] = digit;
        StringBuilder str = new StringBuilder();
        for (int number : newNumbers) {
            str.append(number);
        }
        firstResult[0] = Long.parseLong(str.toString());
        firstResult[1] = indexTook;
        firstResult[2] = indexInsert;
    }

    private static long[] formTheResultingArray(int[] numbers, int indexSmallerNumber) {
        int indexDigitTook;
        boolean rearrangeTheFirstDigit = false;
        if (indexSmallerNumber == 1) {
            indexDigitTook = 0;
            rearrangeTheFirstDigit = true;
        } else {
            indexDigitTook = indexSmallerNumber;
        }
        int indexDigitInsert = getIndexDigitInsert(numbers, indexDigitTook, rearrangeTheFirstDigit);
        long resultNumber = rearrangeTheDigit(numbers, indexDigitTook, indexDigitInsert);
        return new long[]{resultNumber, indexDigitTook, indexDigitInsert};
    }

    private static long rearrangeTheDigit(int[] numbers, int indexDigitTook, int indexDigitInsert) {
        int digit = numbers[indexDigitTook];
        if (indexDigitTook < indexDigitInsert) {
            System.arraycopy(numbers, indexDigitTook + 1, numbers, indexDigitTook, indexDigitInsert - indexDigitTook);
        } else {
            if (indexDigitTook - indexDigitInsert >= 0)
                System.arraycopy(numbers, indexDigitInsert, numbers, indexDigitInsert + 1, indexDigitTook - indexDigitInsert);
        }
        numbers[indexDigitInsert] = digit;
        StringBuilder str = new StringBuilder();
        for (int number : numbers) {
            str.append(number);
        }
        return Long.parseLong(str.toString());
    }

    private static int getIndexDigitInsert(int[] numbers, int indexDigitTook, boolean rearrangeTheFirstDigit) {
        int digitTook;
        digitTook = numbers[indexDigitTook];
        int indexDigitInsert = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (digitTook <= numbers[i] || i == numbers.length - 1) {
                if (rearrangeTheFirstDigit) {
                    indexDigitInsert = i - 1;
                } else {
                    indexDigitInsert = i;
                }
                if (rearrangeTheFirstDigit && i == 0) {
                    continue;
                }
                break;
            }
        }
        return indexDigitInsert;
    }

    private static int findSmallerNumber(int[] numbers, int startNumber) {
        int indexMinNumber = 0;
        int minNumber = 9;
        boolean numbersInARow;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= minNumber && numbers[i] > startNumber) {
                numbersInARow = i != 0 && numbers[i] == numbers[i - 1];
                if (!numbersInARow) {
                    minNumber = numbers[i];
                    indexMinNumber = i;
                }
            }
        }
        if (indexMinNumber != 0) {
            return indexMinNumber;
        } else {
            return findSmallerNumber(numbers, numbers[indexMinNumber]);
        }
    }

    private static int[] translateTheNumberIntoAnArrayOfNumbers(long n) {
        String str = n + "";
        char[] chars = str.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = Integer.parseInt(chars[i] + "");
        }
        return result;
    }
}
