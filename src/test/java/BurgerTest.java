import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Ingredient mockIngredient1;

    @Mock
    Ingredient mockIngredient2;

    @Mock
    Ingredient mockIngredient3;

    @Mock
    Bun mockBun;


    @Test
    public void addIngredientTest() {
        Assert.assertTrue("Список ингредиентов не пустой", burger.ingredients.isEmpty());
        burger.addIngredient(mockIngredient1);
        Assert.assertEquals("Количество ингредиентов в списке !=1", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Assert.assertTrue("Список ингредиентов не пустой", burger.ingredients.isEmpty());
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
        Assert.assertEquals("Количество ингредиентов в списке !=3", 3, burger.ingredients.size());
        burger.removeIngredient(2);
        Assert.assertEquals("Количество ингредиентов в списке !=2", 2, burger.ingredients.size());
    }


    @Test
    public void moveIngredientTest() {
        Assert.assertTrue("Список ингредиентов не пустой", burger.ingredients.isEmpty());
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
        Assert.assertEquals("Количество ингредиентов в списке !=3", 3, burger.ingredients.size());
        burger.moveIngredient(0, 2);
        Assert.assertEquals("Положение ингредиента 1 в списке неверное", 2, burger.ingredients.indexOf(mockIngredient1));
        Assert.assertEquals("Положение ингредиента 2 в списке неверное", 0, burger.ingredients.indexOf(mockIngredient2));
        Assert.assertEquals("Положение ингредиента 3 в списке неверное", 1, burger.ingredients.indexOf(mockIngredient3));
    }

    @Test
    public void getPriceTest() {
        Assert.assertTrue("Список ингредиентов не пустой", burger.ingredients.isEmpty());
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(300f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(200f);
        Mockito.when(mockIngredient3.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
        Assert.assertEquals("Цена Burger выведена неверно", 800f, burger.getPrice(), 0.00001f);
    }

    @Test
    public void getReceiptTest() {
        Assert.assertTrue("Список ингредиентов не пустой", burger.ingredients.isEmpty());
        // mockBun
        Mockito.when(mockBun.getPrice()).thenReturn(200f);
        Mockito.when(mockBun.getName()).thenReturn("white bun");
        // mockIngredient1
        Mockito.when(mockIngredient1.getType()).thenReturn(FILLING);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(300f);
        Mockito.when(mockIngredient1.getName()).thenReturn("sausage");
        // mockIngredient2
        Mockito.when(mockIngredient2.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(300f);
        Mockito.when(mockIngredient2.getName()).thenReturn("chili sauce");
        // mockIngredient3
        Mockito.when(mockIngredient3.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient3.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient3.getName()).thenReturn("hot sauce");

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
        burger.getReceipt();
        System.out.println(burger.getReceipt());
        String expectedGetReceipt =
                "(==== white bun ====)\n" +
                        "= filling sausage =\n" +
                        "= sauce chili sauce =\n" +
                        "= sauce hot sauce =\n" +
                        "(==== white bun ====)\n" +
                        "\nPrice: 1100,000000\n";

        Assert.assertEquals("Чек выведен неверно", expectedGetReceipt, burger.getReceipt());
    }
}

