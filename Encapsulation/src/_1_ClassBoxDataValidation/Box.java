package _1_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if(length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative");
        } else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative");
        } else {
            this.height = height;
        }
    }

    public double calculateSurfaceArea() {
        return 2*length*width + 2*length*height + 2*width*height;
    }

    public double calculateLateralSurfaceArea() {
        return 2*length*height + 2*width*height;
    }

    public double calculateVolume() {
        return height*length*width;
    }
}
