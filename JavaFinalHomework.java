import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaFinalHomework {
    public static void main(String[] args) {
        double degreeBasis;
        double degreeIndicator;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {                                                                  
                try {
                    System.out.print("Введите основание степени: ");
                    degreeBasis = scanner.nextDouble();
                    calculatePower(degreeBasis, 1);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }

            while (true) {                                                                   
                try {
                    System.out.print("Введите показатель степени: ");
                    degreeIndicator = scanner.nextInt();
                    calculatePower(1, degreeIndicator);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: введенные данные не являются цифрой.\n");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s ** %s = %s", degreeBasis, degreeIndicator,        
                    String.format("%.2f", calculatePower(degreeBasis, degreeIndicator)));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        } finally {
            scanner.close();                                                                 
        }
    }
    
    public static double calculatePower(double a, double b) throws InvalidInputException {
        if (a == 0) {
            throw new InvalidInputException("введено некорректное основание (ноль).");
        }
        if (b < 0) {
            throw new InvalidInputException("введен некорректный показатель (отрицательная степень).");
        }
        return Math.pow(a, b);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}