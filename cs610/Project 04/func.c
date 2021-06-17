/*
Complete the function: func in the following program. 
This function has three parameters: 
- The first and second parameters are of type: int. 
- The third one is a function that has two parameters of type: int and returns a value of type: int. 
In the body of function call its third parameter (which is a function) passing the first and second parameter of: func.
*/

#include <stdio.h>

int pow1(int m, int n) {
   int i, ans = 1;
   for (i=1; i<=n; i++) {
      ans = ans * m;
   }
   return ans;
}

int max(int m, int n) {
   if (m > n) {
     return m;
   }
   return n;
}

int min(int m, int n) {
   if (m < n) {
      return m;
   }
   return n;
}

void func (int x, int y, int (*f)(int, int)) {
   int result = f(x, y);
   printf("%d\n", result);
}

int main () {
   int x, y;
   printf("Enter two positive integers: ");
   scanf("%d %d", &x, &y);
   func(x, y, pow1);
   func(x, y, max);
   func(x, y, min);
   return 0;
}
