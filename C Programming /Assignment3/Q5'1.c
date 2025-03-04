// Online C++ compiler to run C++ program online
#include <iostream>

int main() {
    int n;
    long long int Ans;
    printf("Enter any positive number upto 20 : ");
    scanf("%d",&n);
    
    for(int i = 0; i<n; i++){
        Ans *= n-i;
    }
    printf("Answer is : %lld",Ans );

    return 0;
}
