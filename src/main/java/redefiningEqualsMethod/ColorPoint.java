package redefiningEqualsMethod;

import java.awt.*;
import java.util.Objects;

class ColorPoint{
    //inheritance over composition!
    private final Point point;
    private final Color color;

    ColorPoint(int x, int y, Color color) {
        point = new Point(x,y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
