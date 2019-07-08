package com.sunzhouyu.design.Flyweight;

/**
 * 享元类
 *
 * @author Administrator
 */
public interface ChessFlyWeight {
    void setColor(String c);

    String getColor();

    ChessFlyWeight display(Coordinate c);

    Coordinate show();
}

class ConcreteChess implements ChessFlyWeight {

    private String color;

    private Coordinate coordinate;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }

    @Override
    public ChessFlyWeight display(Coordinate c) {
        System.out.println("棋子颜色：" + color);
        this.coordinate = c;
        System.out.println("棋子位置：" + c.getX() + "----" + c.getY());
        ConcreteChess cc = new ConcreteChess(color);
        cc.coordinate = c;
        return cc;
    }

    @Override
    public Coordinate show() {
        return coordinate;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }

}
