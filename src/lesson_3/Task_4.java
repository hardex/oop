package lesson_3;

import java.util.Scanner;

/**
 * Created by odogryk on 04.04.2015.
 * РќР°РїРёСЃР°С‚СЊ РїСЂРѕРіСЂР°РјРјСѓ, РєРѕС‚РѕСЂР°СЏ Р±СѓРґРµС‚ СЂРёСЃРѕРІР°С‚СЊ РЅР° РєРѕРЅСЃРѕР»Рё РїСЂСЏРјРѕСѓРіРѕР»СЊРЅРёРє СЃ Р·Р°РґР°РЅРЅС‹РјРё РґР»РёРЅР°РјРё СЃС‚РѕСЂРѕРЅ.
 */
abstract class Figure {
    public abstract int getS();
}

class Rectangle extends Figure {
    private int height, width;

    public Rectangle(int h, int w) {
        height = h;
        width = w;
    }

    public int getS() {
        return height * width;
    }

    public void print_rec () {
        StringBuilder sb = new StringBuilder();

            for (int i = 1; i < height; i++) {

                switch (i) {
                    case 1: {
                        // РїРµСЂРІР°СЏ СЃС‚СЂРѕРєР°
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {
                                    sb.append('в”Џ');
                                    break;
                                }
                                default: {
                                    sb.append('в”Ѓ'); // СЃРµСЂРµРґРёРЅР° РїРµСЂРІРѕР№ СЃС‚СЂРѕРєРё
                                    break;
                                }
                            }
                        }
                        sb.append('в”“'); // РїРѕСЃР»РµРґРЅРёР№ СЃРёРјРІРѕР» РїРµСЂРІРѕР№ СЃС‚СЂРѕРєРё
                        break;
                    }
                    default: {
                        // СЃСЂРµРґРЅРёРµ СЃС‚СЂРѕРєРё
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {
                                    sb.append('в”‚');
                                    break;
                                }
                                default: {
                                    sb.append(' '); // СЃРµСЂРµРґРёРЅР° СЃСЂРµРґРЅРµР№ СЃС‚СЂРѕРєРё
                                    break;
                                }
                            }
                        }
                        sb.append('в”‚'); // РїРѕСЃР»РµРґРЅРёР№ СЃРёРјРІРѕР» СЃСЂРµРґРЅРµР№ СЃС‚СЂРѕРєРё
                        break;
                    }
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
            // РїРѕСЃР»РµРґРЅСЏСЏ СЃС‚СЂРѕРєР°
            for (int j = 1; j < width; j++) {
                switch (j) {
                    case 1: {
                        sb.append('в”—');
                        break;
                    }
                    default: {
                        sb.append('в”Ѓ'); // СЃРµСЂРµРґРёРЅР° РїРѕСЃР»РµРґРЅРµР№ СЃС‚СЂРѕРєРё
                        break;
                    }
                }
            }
            sb.append('в”›'); // РїРѕСЃР»РµРґРЅРёР№ СЃРёРјРІРѕР» РїРѕСЃР»РµРґРЅРµР№ СЃС‚СЂРѕРєРё
            System.out.println(sb.toString());
            sb.setLength(0);

        }
//        в”Џв”—в”‚в”Ѓв”“в”›
//        в–•
    }

public class Task_4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int height, width;

        System.out.print("РЁРёСЂРёРЅР° РїСЂСЏРјРѕСѓРіРѕР»СЊРЅРёРєР° :");
        width = scan.nextInt();
        scan.nextLine();
        System.out.print("Р’С‹СЃРѕС‚Р° РїСЂСЏРјРѕСѓРіРѕР»СЊРЅРёРєР° :");
        height = scan.nextInt();
        scan.nextLine();

        Rectangle r = new Rectangle(height, width);
        r.print_rec();
    }
}
