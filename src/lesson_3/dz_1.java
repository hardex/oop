package lesson_3;

/**
 * Created by odogryk on 05.04.2015.
 * Написать метод разбора списка параметров в формате URL:
 para1=value1&param2=value2&param3=value3. В случае ошибки в
 формате бросать исключение.
 */

public class dz_1 {
    static StringBuffer paramString = new StringBuffer("para1=value1&param2=value2&param3=value3");

    public static void main(String[] args) {

        String[][] params = new String[10][2];
        String st;

        int paramsCount = 0;

        while ( paramString.length() > 0) {
            try {

                st = paramString.substring(0, paramString.indexOf("&") > 0 ? paramString.indexOf("&") : paramString.length());

                if (st.indexOf("=") == -1)
                    throw new ValueException(st);
                if (st.indexOf("=", st.indexOf("=")+1) != -1)
                    throw new SeparException(st);

                params[paramsCount][0] = st.substring(0, st.indexOf("="));
                params[paramsCount][1] = st.substring(st.indexOf("=") + 1, st.length());
                System.out.println(params[paramsCount][0] + "..." + params[paramsCount][1]);

                paramString.delete(0, st.length()+1);
                paramsCount++;
// Java 7 don't work
            } catch (SeparException|ValueException e) {
                System.out.println(e.getMessage());
                break;
            }
/*
            } catch (SeparException e) {
                System.out.println(e.getMessage());
                break;
            }
            catch (ValueException e) {
                System.out.println(e.getMessage());
                break;
            }
*/

        }
    }

}
