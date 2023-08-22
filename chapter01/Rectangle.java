/**
 * EXERCISE 1.18 Design a class to represent a geometric rectangle with a given length and width,
 * such that it is capable of calculating the area and the perimeter of the rectangle.
 */


package chapter01;

public class Rectangle {
    private float height, width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float calculateArea() {
        return this.height * this.width;
    }

    public float calculatePerimeter() {
        return (this.height * 2) + (this.width * 2);
    }
}
