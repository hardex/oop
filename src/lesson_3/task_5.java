package lesson_3;

/*
5. ��������� �������� ������� �������� � ������ ������ �
        ������������. � ������� ������ ������ ������ ����
        ����� �������� �������. ������� ������ �����. �������
        ������� ���� ����� �� �����.
*/

import figure.Circle;
import figure.Figure;
import figure.Rectangle;

public class task_5 {

    public static void main(String[] args) {

        Figure[] figures = {
                new Circle(23),
                new Rectangle(5, 6)
        };

        System.out.println("������� ����� = "+ figures[0].getS());
        System.out.println("������� �������������� = "+ figures[1].getS());

    }
}
