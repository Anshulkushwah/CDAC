#include <stdio.h>

int main() {
    int n;
    double sum = 0.0, average;

    // Input size of array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    // Declare array and input elements
    int arr[n];
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i]; // Add each element to sum
    }

    // Calculate average
    average = sum / n;

    // Print the result
    printf("Average of the entered numbers: %.2lf\n", average);

    return 0;
}
