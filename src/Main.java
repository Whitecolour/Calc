import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //1. Чтение строки из консоли
        System.out.print("Enter arithmetic expression: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //2. Вычисление результата
        String result = calc(input);

        //3. Вывод результата
        System.out.println("Result = " + result);
        // System.out.println(calc(input)); //Вычисление и вывод

    }

    private static String calc(String input) {
        //1. Разбить строчку на части
        String[] parts = input.split(" ");

        //2. Валидация

        //2А. Колличество частей равно трем
        if (parts.length != 3) {
            throw new RuntimeException("Expression parts number must = 3 but = " + parts.length);
        }
        //2Б. 1,3 части число от 1 до 10 включительно
        int left = Integer.parseInt(parts[0]);
        int right = Integer.parseInt(parts[2]);
        if (left < 1 || left > 10) {
            throw new RuntimeException("Left argument must be in range 1..10 but = " + left);
        }
        if (right < 1 || right > 10) {
            throw new RuntimeException("Right argument must be in range 1..10 but = " + right);
        }

        //2В. 2 часть оператор
        //3. Вычисление, валидация
        String operator = parts[1];
        int result;
        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
            default:
                throw new RuntimeException("Operator must be one of +,-,*,/ but = '" + operator + "'");
        }
        //4. Конвертация в строку и возврат

        return String.valueOf(result);
    }

}
