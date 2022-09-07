package lesson10.hs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTester {
    public static void main(String[] args) {
        // если мы планируем использовать хэшированные контейнеры, то нужно в нашем классе
        // заимплементить equal() и hashCode().
        // Object.hashCode() есть контакт:
        // 1. На протяжении жизни объекта hashCode() для него должен выдавать один и тот же int
        // 2. Если o1.equals(o2), то o1.hashCode() == o2.hashCode()
        // равенство хэш кодов o1.hashCode() == o2.hashCode() НЕ означает, что o1.equals(o2) !!!
        // Petya -> 10
        // Masha -> 10

        // У класса, экземпляры которого сохраняются в хэш-контейнерах
        // должны быть определены hashCode() и equals()
        Set<Point> points = new HashSet<>();
        points.add(new Point(10, 20));
        points.add(new Point(10, 20));
        System.out.println(points);

        // Нельзя менять состояние объектов, хранящихся в хэш-кодах
        Set<Point> newPoints = new HashSet<>();
        Point p = new Point(10, 20);
        newPoints.add(p);
        p.setX(1000);
        p.setY(1000);
        newPoints.add(p);
        System.out.println(newPoints);

        points.add(new Point(2, 2));
        points.add(new Point(2000, 2000));
        System.out.println(points);  // при использовании HashSet никакой порядок обхода не гарантируется

        System.out.println(points.contains(new Point(2000, 2000)));

        // в LinkedHashSet гарантируется возвращение объектов в порядке вставки
        Set<Point> linkedPoints = new LinkedHashSet<>();
        linkedPoints.add(new Point(10, 20));
        linkedPoints.add(new Point(2,2));
        linkedPoints.add(new Point(2000,2000));
        System.out.println(linkedPoints);

        // TreeSet гарантирует возвращение объектов в порядке сортировки
        // определенном для классов либо через Comparable, либо через Comparator
        Set<Point> treePoints = new TreeSet<>(/* new Point Comparator*/);
        treePoints.add(new Point(10, 20));
        treePoints.add(new Point(2,2));
        treePoints.add(new Point(2000,2000));
        System.out.println(treePoints);



    }
}
