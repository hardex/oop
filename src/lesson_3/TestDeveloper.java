package lesson_3;

/**
 * Created by odogryk on 29.03.2015.
 */
public class TestDeveloper extends Developer {

    public TestDeveloper(String name, double basicSalary, int experience) {
            super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
            return (basicSalary * 1.5)+ (experience > 0 ? basicSalary * experience * 0.1 : 0);
        }

}

