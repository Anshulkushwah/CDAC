#include <stdio.h>

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    printf("Multiplication table for %d:\n", num);
    for (int i = 1; i <= num; i++) {
        printf("%d Table is : ", i);
        for (int j = 1; j <= 10; j++) {
            printf("%d * %d = %d\t", i, j, i * j);
        }
        printf("---------------------------------------------------------------------------\n");
    }

    return 0;
}
