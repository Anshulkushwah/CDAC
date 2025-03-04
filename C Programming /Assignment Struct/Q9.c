#include <stdio.h>

enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE
};

int performOperation(int a, int b, enum Operation op) {
    switch (op) {
        case ADD:
            return a + b;
        case SUBTRACT:
            return a - b;
        case MULTIPLY:
            return a * b;
        case DIVIDE:
            if (b != 0) {
                return a / b;
            } else {
                printf("Error: Division by zero\n");
                return 0;
            }
        default:
            printf("Error: Unknown operation\n");
            return 0;
    }
}

int main() {
    int num1 = 10;
    int num2 = 5;

    int sum = performOperation(num1, num2, ADD);
    int difference = performOperation(num1, num2, SUBTRACT);
    int product = performOperation(num1, num2, MULTIPLY);
    int quotient = performOperation(num1, num2, DIVIDE);

    printf("Addition: %d + %d = %d\n", num1, num2, sum);
    printf("Subtraction: %d - %d = %d\n", num1, num2, difference);
    printf("Multiplication: %d * %d = %d\n", num1, num2, product);
    printf("Division: %d / %d = %d\n", num1, num2, quotient);

    return 0;
}
