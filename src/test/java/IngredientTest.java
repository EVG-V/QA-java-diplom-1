import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Assert;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)

public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientData() {
        return new Object[][]{
                {SAUCE, "chili sauce", 300f},
                {FILLING, "dinosaur", 200f},
        };
    }

    @Test
    @DisplayName("Проверка: цена ингредиента")
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Цена Ingredient выведена неверно", price, ingredient.getPrice(), 0.00001f);
    }

    @Test
    @DisplayName("Проверка: тип ингредиента")
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тип Ingredient выведен неверно", type, ingredient.getType());
    }

    @Test
    @DisplayName("Проверка: название ингредиента")
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Название Ingredient выведено неверно", name, ingredient.getName());
    }
}


