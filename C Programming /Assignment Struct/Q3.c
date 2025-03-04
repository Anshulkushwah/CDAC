#include <stdio.h>

struct Circle {
    float radius;
    char color[20];
};

void updateRadiusandPrint(struct Circle *A) {
    printf("ENTER VALUE OF radius : ");
    scanf("%f", &A->radius);

    // Clear the input buffer to avoid interference
    while (getchar() != '\n');

    printf("ENTER VALUE OF color : ");
    scanf("%19s", A->color);
    
    printf("Radius is : %f, color is : %s\n", A->radius, A->color);
}

int main() {
    struct Circle A;
    updateRadiusandPrint(&A);

    return 0;
}

// What happens:
// When scanf reads input, it leaves the newline character \n (produced by pressing Enter) in the input buffer. This can cause issues when you read subsequent inputs, especially strings. The while (getchar() != '\n'); loop ensures that the input buffer is cleared of any remaining characters, including the newline character.
