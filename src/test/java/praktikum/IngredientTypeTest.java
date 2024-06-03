package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkIngredientTypeFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
