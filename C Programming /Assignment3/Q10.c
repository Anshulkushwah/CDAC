#include <stdio.h>

int main() {
    double num1, num2, result;
    char operation;

    // Input from user
    printf("Enter first number: ");
    scanf("%lf", &num1);
    printf("Enter second number: ");
    scanf("%lf", &num2);
    printf("Enter an arithmetic operation (+, -, *, /): ");
    scanf(" %c", &operation);

    // Perform the arithmetic operation
    switch (operation) {
        case '+':
            result = num1 + num2;
            printf("Result: %.2lf\n", result);
            break;
        case '-':
            result = num1 - num2;
            printf("Result: %.2lf\n", result);
            break;
        case '*':
            result = num1 * num2;
            printf("Result: %.2lf\n", result);
            break;
        case '/':
            if (num2 != 0)
                result = num1 / num2;
            else {
                printf("Error: Division by zero is not allowed.\n");
                return 1;
            }
            printf("Result: %.2lf\n", result);
            break;
        default:
            printf("Error: Invalid operation.\n");
            return 1;
    }

    return 0;
}
