import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Replicator  {

    private Field field;
    private Color color;

    private double x;// корд верхнего угола прямоугольника
    private double y;

    private int radius=80;

   // private double height=100;
    //private double width=150;
   public double getX() {
       return x;
   }

    public double getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
    public Replicator(Field field){
        this.field=field;
        color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        x =350; //Math.random() * (field.getSize().getWidth() );
        y =250;// Math.random() * (field.getSize().getHeight() );



    }

    public void paint(Graphics2D canvas) {
        canvas.setColor(color);
        canvas.setPaint(color);
        Ellipse2D.Double replicator = new Ellipse2D.Double(x, y,2*radius,2*radius);
        canvas.draw(replicator);
        canvas.fill(replicator);
    }
}