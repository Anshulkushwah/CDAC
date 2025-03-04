#include <stdio.h>

struct Person{
    char name[50];
    int age;
};

void printPerson(struct Person p) {
    printf("Name: %s\n", p.name);
    printf("Age: %d\n", p.age);
}

int main() {
    struct Person Rahul;
    
    printf("Enter the name: ");
    scanf(" %49s", &Rahul.name);
    printf("Enter the age: ");
    scanf(" %d", &Rahul.age);
    
    printPerson(Rahul);

    return 0;
}
