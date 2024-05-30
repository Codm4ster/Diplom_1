package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeSauceTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkIngredientTypeFillingTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
