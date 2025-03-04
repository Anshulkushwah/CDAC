// Online C++ compiler to run C++ program online
#include <iostream>

int main() {
    int n;
    printf("Enter number : ");
    scanf("%d",&n);
    int ans;
    do{
        int modVal = n%10;
        ans*=10;
        ans+=modVal;
        n /=10;
    }while(n>0);
    
    printf("Ans is : %d",ans);

    return 0;
}
