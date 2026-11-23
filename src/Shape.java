import java .util.Scanner;
abstract class Area {
    abstract double calculateArea();
}

class Rectange extends Area{
    double length, breadth;

    Rectange(double length, double breadth){
        this.length =length;
        this.breadth =breadth;
    }
    double calculateArea(){
        return length*breadth;
    }
}

class Circle extends Area{
    double radius;
    Circle(double radius){
        this.radius =radius;
    }
    double calculateArea(){
        return Math.PI*radius*radius;
    }
}

class Triangle extends Area{
    double len,base;

    Triangle(double len,double base){
        this.len =len;
        this.base=base;
    }

    double calculateArea() {
        return 0.5*len*base;
    }
}

class Square extends Area{
    double side;
    Square(double side){
        this.side=side;
    }
    double calculateArea(){
        return side*side;
    }
}

public class Shape{
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter Length and breadth of Rectangle :");
        Area r=new Rectange(sc.nextDouble(),sc.nextDouble());

        System.out.println("Enter the Radius of Circle :");
        Area c=new Circle(sc.nextDouble());

        System.out.println("Enter the height and Base of Triangle: ");
        Area t= new Triangle(sc.nextDouble(),sc.nextDouble());

        System.out.println("Enter the Side of Square: ");
        Area s= new Square(sc.nextDouble());

        System.out.println("------ Result-------");
        System.out.println("Area of Rectangle: " +r.calculateArea()+"cm²");
        System.out.println("Area of Triangle: "+t.calculateArea()+"cm²");
        System.out.println("Area of Circle : "+c.calculateArea()+"cm²");
        System.out.println("Area of Square: "+s.calculateArea()+"cm²");
        sc.close();
    }

}

