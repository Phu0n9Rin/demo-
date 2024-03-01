/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Nguyen Dang Thao Phuong - CE180246
 */
public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle( String id, String color,double width, double height) {
        super(id, color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width+height)*2;
    }

    @Override
    public String entryData() {
        String str = String.format("Add Rectangle: %s - %s - %.1f - %.1f",getId(),getColor(),width,height);
        return str;
    }

    @Override
    public String printData() {
        String str = String.format("Rectangle: %s - %s - %.1f - %.1f - %.1f - %.1f",getId(),getColor(),width,height,getArea(),getPerimeter());
        return str;
}
}
