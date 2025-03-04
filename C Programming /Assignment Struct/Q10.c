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
    int num1, num2;
    enum Operation op;

    // Taking input from the user
    printf("Enter the first integer: ");
    scanf("%d", &num1);
    printf("Enter the second integer: ");
    scanf("%d", &num2);

    printf("Choose the operation (0 for ADD, 1 for SUBTRACT, 2 for MULTIPLY, 3 for DIVIDE): ");
    int opChoice;
    scanf("%d", &opChoice);

    op = (enum Operation)opChoice;

    int result = performOperation(num1, num2, op);
    printf("Result: %d\n", result);

    return 0;
}
