#include <stdio.h>

int main() {
    char ch;

    // Prompt the user to input a single character
    printf("Enter a single character: ");
    
    // Use getchar() to read the character input by the user
    ch = getchar();
    
    // Print the character using putchar()
    printf("You entered: ");
    putchar(ch);
    printf("\n");

    return 0;
}
