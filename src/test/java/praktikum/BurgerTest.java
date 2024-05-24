package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient, ingredient2, ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);
        assertEquals(ingredient, burger.ingredients.get(2));
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getPrice()).thenReturn(300F);
        when(ingredient2.getPrice()).thenReturn(100F);

        float expectedPrice = bun.getPrice() * 2 + (ingredient.getPrice() + ingredient2.getPrice());
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200F);

        when(ingredient.getName()).thenReturn("chili sauce");
        when(ingredient.getPrice()).thenReturn(300F);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(100F);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
