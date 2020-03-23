package kata5;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Ziggurat {
    public static List<Point> rideOfFortune(String[] artifact, int[] explorers) {
        ArrayList<Point> list = new ArrayList<>();
        for (int explorer : explorers) {
            Point point = new Point(0, explorer);
            Point pointLast = new Point(point.x - 1, point.y);
            while (point.x >= 0 && point.x < artifact[0].length() && point.y >= 0 && point.y < artifact.length) {
                char c = artifact[point.y].charAt(point.x);
                switch (c) {
                    case 'A':
                        stepA(pointLast, point);
                        artifact[pointLast.y] = artifact[pointLast.y].substring(0, pointLast.x) + 'B' + artifact[pointLast.y].substring(pointLast.x + 1);
                        break;
                    case 'B':
                        stepB(pointLast, point);
                        artifact[pointLast.y] = artifact[pointLast.y].substring(0, pointLast.x) + 'A' + artifact[pointLast.y].substring(pointLast.x + 1                                        );
                        break;
                    case ' ':
                        stepEmpty(pointLast, point);
                        break;
                }
            }
            if (point.x >= 0) {
                point.x = pointLast.y;
                point.y = pointLast.x;
                list.add(point);
            } else {
                list.add(null);
            }
        }
        return list;
    }

    private static void stepA(Point pointLast, Point point) {
        if (pointLast.x < point.x) {
            point.y++;
            pointLast.x = point.x;
            return;
        }
        if (pointLast.x > point.x){
            point.y--;
            pointLast.x = point.x;
            return;
        }
        if (pointLast.y < point.y) {
            point.x++;
            pointLast.y = point.y;
            return;
        }
        if (pointLast.y > point.y){
            point.x--;
            pointLast.y = point.y;
        }
    }

    private static void stepB(Point pointLast, Point point) {
        if (pointLast.x < point.x) {
            point.y--;
            pointLast.x = point.x;
            return;
        }
        if (pointLast.x > point.x){
            point.y++;
            pointLast.x = point.x;
            return;
        }
        if (pointLast.y < point.y) {
            point.x--;
            pointLast.y = point.y;
            return;
        }
        if (pointLast.y > point.y){
            point.x++;
            pointLast.y = point.y;
        }
    }

    private static void stepEmpty(Point pointLast, Point point) {
        if (pointLast.x < point.x) {
            pointLast.x++;
            point.x++;
        }
        if (pointLast.x > point.x){
            pointLast.x--;
            point.x--;
        }
        if (pointLast.y < point.y) {
            pointLast.y++;
            point.y++;
        }
        if (pointLast.y > point.y){
            pointLast.y--;
            point.y--;
        }
    }
}
