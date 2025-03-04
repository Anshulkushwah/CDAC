#include <stdio.h>

struct Student {
    int rollNumber;
    char name[50];
    int standard;
    float percentage;
};

void inputStudentDetails(struct Student *student) {
    printf("Enter Roll Number: ");
    scanf("%d", &student->rollNumber);
    printf("Enter Name: ");
    scanf("%s", student->name);
    printf("Enter Standard: ");
    scanf("%d", &student->standard);
    printf("Enter Percentage: ");
    scanf("%f", &student->percentage);
}

void printStudentDetails(struct Student student) {
    printf("\nStudent Details:\n");
    printf("Roll Number: %d\n", student.rollNumber);
    printf("Name: %s\n", student.name);
    printf("Standard: %d\n", student.standard);
    printf("Percentage: %.2f\n", student.percentage);
}

int main() {
    struct Student student;
    inputStudentDetails(&student);
    printStudentDetails(student);
    
    return 0;
}
