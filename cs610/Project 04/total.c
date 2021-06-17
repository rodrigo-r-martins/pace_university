/*
Complete the function: total. 
This function has one or more parameters of type: int. This function returns the sum of all its parameters.

Note: Always we add argument zero as the last argument. This argument acts as a flag.
*/

#include <stdio.h>
#include <stdarg.h>

int total(int arg, ...) {
   va_list ap;
   va_start(ap, arg);
   int i = 0;
   int sum = 0; 
   for (i=arg; i!=0; i=va_arg(ap, int)) {
      sum += i;
   }
   va_end(ap);
   return sum;
}

int main() {
   int a, b, c, d, e;
   printf("Enter 5 non-zero integers: \n");
   scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
   printf("%d\n", total(a, b, c, d, e, 0));
   printf("%d\n", total(a, b, c, d, 0));
   printf("%d\n", total(a, b, c, 0));
   printf("%d\n", total(a, b, 0));
   return 0;
}
