#include <stdio.h>

int main() {
    int n, ans=1;

    printf("Enter a positive integer: ");
    scanf("%d", &n);

    if (n < 1) {
        printf("Please enter a positive integer greater than 0.\n");
    } else {
        // Using a for loop to calculate
        for (int i = 0; i < n; i++) {
            ans *= (n-i);
        }

        printf("factorial of  %d is: %d\n", n, ans);
    }

    return 0;
}
