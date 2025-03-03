// Online C compiler to run C program online
#include <stdio.h>

void minimum(){
    int a, b;
    printf("Give 1st number : ");
    scanf(" %d", &a);
    printf("Give 2nd number : ");
    scanf(" %d", &b);
    
    printf(" Min is %d\n", a>b? b : a);
    
}

void maximum(){
    int a, b;
    printf("Give 1st number : ");
    scanf(" %d", &a);
    printf("Give 2nd number : ");
    scanf(" %d", &b);
    
    printf(" Max is %d\n", a<b? b : a);
    
}

int main() {
    printf("You want to check max or min, Press 1 for max and 0 for min: ");
    int check;
    scanf(" %d", &check);
    
    check == 1 ? maximum() : minimum();
    

    return 0;
}
