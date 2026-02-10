import Medium.*;
import Easy.*;
import Hard.*;
import Misc.*;
import Misc.Graph.UnionFind;

public class Main {
    public static void main(String[] args) {

        // q283.testSample();

        Misc.Graph.UnionFind driver = new UnionFind(8);
        driver.join(1,8);
        driver.join(3,8);
        driver.join(1, 7);
        driver.join(8, 5);

        System.out.println(driver);
    }
}