class Rectangle {

   int length;
   int width;

   int calcArea() {
     int returnValue;
     returnValue = length * width;
     return returnValue;
   }

   int calcPerimeter() {
     int returnValue;
     returnValue = 2 * (length + width);
     return returnValue;
   }

}