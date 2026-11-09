class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // Add each pair of digit products into its place.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                result[i + j + 1] += digit1 * digit2;
            }
        }

        // Propagate carries from right to left.
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }

        StringBuilder answer = new StringBuilder();
        int i = 0;

        // Skip any leading zero in the result array.
        while (i < result.length && result[i] == 0) i++;

        for (; i < result.length; i++) {
            answer.append(result[i]);
        }

        return answer.toString();
    }
}
