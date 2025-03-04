#include <stdio.h>

int main() {
    char str[100];
    int length = 0;

    // Prompt the user to enter a string
    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    // Calculate the length of the string
    while (str[length] != '\0') {
        length++;
    }

    // Since fgets includes the newline character, we subtract 1 if there is a newline
    if (str[length - 1] == '\n') {
        length--;
    }

    // Print the length of the string
    printf("The length of the string is: %d\n", length);

    return 0;
}
