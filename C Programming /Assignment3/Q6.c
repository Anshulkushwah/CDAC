// Online C++ compiler to run C++ program online
#include <iostream>

int main() {
    int n,i=0;
    printf("Enter any positive number Upto 40 : ");
    scanf("%d",&n);
    
    if(n == 0) {
        printf("Answer is : 0" );
        return 0;
    }
    if(n == 1) {
        printf("Answer is : 0,1 ");
        return 0;
    }
    
    int prev1 = 1, prev2 = 0;
    printf("Answer is : " );
    while(i<n){
        if(i==0) printf("%d,",prev2 );
        else if(i == 1)  printf("%d,",prev1);
        else {
            int Temp = prev1+prev2;
            printf("%d,",Temp);
            prev2 = prev1;
            prev1 = Temp;
        }
        i++;
    }

    return 0;
}
