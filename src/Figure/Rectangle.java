package figure;

/**
 * Created by odogryk on 05.04.2015.
 */
public class Rectangle extends Figure {
    private int height, width;

    public Rectangle(int h, int w) {
        height = h;
        width = w;
    }

    public float getS() {
        return height * width;
    }

    public void print_rec () {
        StringBuilder sb = new StringBuilder();
        char ch;

            for (int i = 1; i < height; i++) {

                switch (i) {
                    case 1: {
                        // ������ ������
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {
                                    sb.append('?'); //
                                    break;
                                }
                                default: {
                                    sb.append('?'); // �������� ������ ������
                                    break;
                                }
                            }
                        }
                        sb.append('?'); // ��������� ������ ������ ������
                        break;
                    }
                    default: {
                        // ������� ������
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {

                                    sb.append('?'); //
                                    break;
                                }
                                default: {
                                    sb.append(' '); // �������� ������� ������
                                    break;
                                }
                            }
                        }
                        sb.append('?'); // ��������� ������ ������� ������
                        break;
                    }
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
            // ��������� ������
            for (int j = 1; j < width; j++) {
                switch (j) {
                    case 1: {
                        sb.append('?');
                        break;
                    }
                    default: {
                        sb.append('?'); // �������� ��������� ������
                        break;
                    }
                }
            }
            sb.append('?'); // ��������� ������ ��������� ������
            System.out.println(sb.toString());
            sb.setLength(0);

        }
//        ??????
//        ?
    }
