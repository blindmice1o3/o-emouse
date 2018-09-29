package HeadFirst.DesignPatterns.Ch03DecoratorPattern.DecoratorIOExample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestClassInputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in =
                    new LowerCaseInputStream (
                            new BufferedInputStream(
                                    new FileInputStream("src/HeadFirst/DesignPatterns/Ch03DecoratorPattern/DecoratorIOExample/test.txt")));
            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
