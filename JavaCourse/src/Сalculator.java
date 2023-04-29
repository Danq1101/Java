import java.util.Scanner;

public class Сalculator {
    public static void main(String[] args) {
        String[] expression = new String[3];
        Scanner s = new Scanner(System.in);
        int firstNumber, secondNumber, result;
        String action;
        boolean flag = true;
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};


        System.out.print("Enter ur expression - ");
        for (int i = 0; i < expression.length; i++) {
            expression[i] = s.next();
        }

        int check = 0;
        try {
            for (String romanNumber : romanNumbers) {
                if (romanNumber.equals(expression[0]))
                    check++;
                if (romanNumber.equals(expression[2]))
                    check++;
            }
                if (check == 2)
                    flag = false;
                else if (check == 1 || check == 0)
                    throw new ExpressionException("Expression incorrect");
        }catch (ExpressionException e){
            throw new RuntimeException(e);
        }

        action = expression[1];
        if (flag) {
            try {
                System.out.println("Arabic numbers");
                firstNumber = Integer.parseInt(expression[0]);
                secondNumber = Integer.parseInt(expression[2]);
                if (!((firstNumber >= 1 && firstNumber <= 10) || (secondNumber >= 1 && secondNumber <= 10)))
                    throw new ExpressionException("Expression incorrect");
            }catch (ExpressionException e){
                throw new RuntimeException(e);
            }
            System.out.println("First number = " + firstNumber + "\nSecond number = " + secondNumber);
        }else {
            System.out.println("Roman numbers");
            firstNumber = romanToArabic(expression[0]);
            secondNumber = romanToArabic(expression[2]);
            System.out.println("First number = " + firstNumber + "\nSecond number = " + secondNumber);
        }
        System.out.println("Action - " + action);
        result = switch (action) {
            case "*" -> firstNumber * secondNumber;
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> 0;
        };

        if (flag)
            System.out.println("Result = " + result);
        else {
            try {
                if (result < 0)
                    throw new ExpressionException("Expression incorrect");
                String romanResult = arabicToRoman(result);
                System.out.println("Result = " + romanResult);
            }catch (ExpressionException e){
                throw new RuntimeException(e);
            }
        }
    }

    private static String arabicToRoman (int result) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[result];
    }

    private static  int romanToArabic (String string){
        int number;
        switch (string) {
            case "I" -> number = RomanNumbers.I.value;
            case "II" -> number = RomanNumbers.II.value;
            case "III" -> number = RomanNumbers.III.value;
            case "IV" -> number = RomanNumbers.IV.value;
            case "V" -> number = RomanNumbers.V.value;
            case "VI" -> number = RomanNumbers.VI.value;
            case "VII" -> number = RomanNumbers.VII.value;
            case "VIII" -> number = RomanNumbers.VIII.value;
            case "IX" -> number = RomanNumbers.IX.value;
            case "X" -> number = RomanNumbers.X.value;
            default -> number = 0;
        }
        return number;
    }
}



