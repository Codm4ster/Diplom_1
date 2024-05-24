package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeSauceTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void checkIngredientTypeFillingTest() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
