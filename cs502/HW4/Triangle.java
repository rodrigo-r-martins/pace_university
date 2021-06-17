public class Triangle {
	int side1;
	int side2;
	int side3;

	boolean isEquilateral() {
		if (side1 == side2 && side2 == side3) {
			return true;
		} else {
			return false;
		}
	}

	boolean isScalene() {
		if (side1 != side2 && side2 != side3 && side1 != side3) {
			return true;
		} else {
			return false;
		}
	}

	boolean isIsosceles() {
		if (isEquilateral() || isScalene()) {
			return false;
		} else {
			return true;
		}
	}

	int calculatePerimeter() {
		int perimeter;
		perimeter = side1 + side2 + side3;
		return perimeter;
	}
}
