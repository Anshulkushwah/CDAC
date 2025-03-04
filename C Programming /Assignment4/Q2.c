#include <stdio.h>

int main() {
    int n;

    // Input size of array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    // Declare array and input elements
    int arr[n];
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Initialize variables to hold the largest and smallest elements
    int largest = arr[0];
    int smallest = arr[0];

    // Loop through the array to find the largest and smallest elements
    for (int i = 1; i < n; i++) {
        if (arr[i] > largest) {
            largest = arr[i];
        }
        if (arr[i] < smallest) {
            smallest = arr[i];
        }
    }

    // Print the results
    printf("Largest element: %d\n", largest);
    printf("Smallest element: %d\n", smallest);

    return 0;
}
