// Online C compiler to run C program online
#include <stdio.h>

void maximum(){
    int a, b, c;
    printf("Give 1st number : ");
    scanf(" %d", &a);
    printf("Give 2nd number : ");
    scanf(" %d", &b);
    
    printf("Give 3nd number : ");
    scanf(" %d", &c);
    
    int result = a>b? a :b;
    
    printf(" Max is %d\n", result>c? result :c);
    
}

int main() {
    maximum();
    return 0;
}
