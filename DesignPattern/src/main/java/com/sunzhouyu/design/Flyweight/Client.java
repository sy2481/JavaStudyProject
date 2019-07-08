package com.sunzhouyu.design.Flyweight;

public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println(chess1.show());
        System.out.println(chess2.show());

        System.out.println("增加外部状态的处理===========");
        chess1.display(new Coordinate(10, 10));
        chess2.display(new Coordinate(20, 20));
        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println(chess1.show().getX()+"----"+chess1.show().getX());
        System.out.println(chess2.show().getX()+"----"+chess2.show().getX());

    }
}
