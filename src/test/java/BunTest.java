import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.Bun;
import org.junit.Assert;

public class BunTest {
    Bun bun = new Bun("black bun", 100f);

    @Test
    @DisplayName("Проверка: имя булки")
    public void getBunNameTest() {
        Assert.assertEquals("Имя Bun выведено неверно", "black bun", bun.getName());
    }
    @Test
    @DisplayName("Проверка: цена булки")
    public void getBunPriceTest() {
        Assert.assertEquals("Цена Bun выведена неверно", 100f, bun.getPrice(), 0.00001f);
    }
}