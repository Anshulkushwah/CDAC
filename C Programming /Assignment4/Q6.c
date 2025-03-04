#include <stdio.h>

int main() {
    char str[100];

    // Prompt the user to enter a string
    printf("Enter a string: ");
    
    // Use gets() to read the string input by the user
    gets(str);
    
    // Print the string using puts()
    printf("You entered: ");
    puts(str);

    return 0;
}
