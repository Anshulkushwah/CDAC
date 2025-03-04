#include <stdio.h>

// Function prototypes
void getInput(double *height, double *weight);
double calculateBMI(double height, double weight);
void displayBMI(double bmi);

int main() {
    double height, weight, bmi;

    // Get input from user
    getInput(&height, &weight);

    // Calculate BMI
    bmi = calculateBMI(height, weight);

    // Display BMI
    displayBMI(bmi);

    return 0;
}

// Function to get input from user
void getInput(double *height, double *weight) {
    printf("Enter your height in meters: ");
    scanf("%lf", height);
    printf("Enter your weight in kilograms: ");
    scanf("%lf", weight);
}

// Function to calculate BMI
double calculateBMI(double height, double weight) {
    return weight / (height * height);
}

// Function to display BMI
void displayBMI(double bmi) {
    printf("Your BMI is: %.2lf\n", bmi);
}
