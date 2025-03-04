#include <stdio.h>

// Function prototypes
void getInput(double *num1, double *num2);
double addNumbers(double num1, double num2);
void displayResult(double result);

int main() {
    double num1, num2, result;

    // Get input from user
    getInput(&num1, &num2);

    // Add the numbers
    result = addNumbers(num1, num2);

    // Display the result
    displayResult(result);

    return 0;
}

// Function to get input from user
void getInput(double *num1, double *num2) {
    printf("Enter the first number: ");
    scanf("%lf", num1);
    printf("Enter the second number: ");
    scanf("%lf", num2);
}

// Function to add the numbers
double addNumbers(double num1, double num2) {
    return num1 + num2;
}

// Function to display the result
void displayResult(double result) {
    printf("The sum of the two numbers is: %.2lf\n", result);
}
