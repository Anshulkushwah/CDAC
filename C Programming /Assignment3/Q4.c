#include <stdio.h>

int main() {
    int n, sum = 0;

    printf("Enter a positive integer: ");
    scanf("%d", &n);

    if (n < 1) {
        printf("Please enter a positive integer greater than 0.\n");
    } else {
        // Using a for loop to calculate the sum
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        // Output the result
        printf("The sum of the first %d positive integers is: %d\n", n, sum);
    }

    return 0;
}
