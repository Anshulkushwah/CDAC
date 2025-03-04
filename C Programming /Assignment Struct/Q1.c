#include <stdio.h>

struct Rectangle{
    float length;
    float width;
};

void printRectangle(struct Rectangle rect) {
    printf("Rectangle:\n");
    printf("Length: %.2f\n", rect.length);
    printf("Width: %.2f\n", rect.width);
}

int main() {
    struct Rectangle rect;
    
    printf("Enter the length of the rectangle: ");
    scanf("%f", &rect.length);
    printf("Enter the width of the rectangle: ");
    scanf("%f", &rect.width);
    
    printRectangle(rect);

    return 0;
}
