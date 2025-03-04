#include <stdio.h>

enum ShapeType {
    CIRCLE,
    RECTANGLE,
    SQUARE,
    TRIANGLE
};

void printShapeDescription(enum ShapeType shape) {
    switch (shape) {
        case CIRCLE:
            printf("CIRCLE: A round shape\n");
            break;
        case RECTANGLE:
            printf("RECTANGLE: A shape with four right angles\n");
            break;
        case SQUARE:
            printf("SQUARE: A shape with four equal sides and four right angles\n");
            break;
        case TRIANGLE:
            printf("TRIANGLE: A shape with three sides\n");
            break;
        default:
            printf("Unknown shape\n");
            break;
    }
}

int main() {
    enum ShapeType shape1 = CIRCLE;
    enum ShapeType shape2 = RECTANGLE;
    enum ShapeType shape3 = SQUARE;
    enum ShapeType shape4 = TRIANGLE;

    printShapeDescription(shape1);
    printShapeDescription(shape2);
    printShapeDescription(shape3);
    printShapeDescription(shape4);

    return 0;
}
