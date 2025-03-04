#include <stdio.h>

struct Course {
    char courseName[100];
    int credits;
};

struct Student {
    char name[50];
    int age;
    struct Course courses[10];
    int numCourses;
};

void printStudentDetails(struct Student *student) {
    printf("Student Name: %s\n", student->name);
    printf("Age: %d\n", student->age);
    printf("Enrolled Courses:\n");
    for (int i = 0; i < student->numCourses; i++) {
        printf("Course Name: %s, Credits: %d\n", student->courses[i].courseName, student->courses[i].credits);
    }
}

int main() {
    struct Student student = {
        "Anshul",  // Name
        20,  // Age
        {  // Courses
            {"Mathematics", 4},
            {"Physics", 3},
            {"Computer Science", 4}
        },
        3  // Number of courses
    };

    printStudentDetails(&student);

    return 0;
}
