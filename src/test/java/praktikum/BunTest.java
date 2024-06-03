package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"white bun", 200},
                {"black bun", 100},
                {"red bun", 300},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        float actual  = bun.getPrice();
        assertEquals(price, actual, 0);
    }
}
