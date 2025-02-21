import org.junit.Test;
import praktikum.Bun;
import org.junit.Assert;

public class BunTest {
    Bun bun = new Bun("black bun", 100f);

    @Test
    public void getBunNameTest() {
        Assert.assertEquals("Имя Bun выведено неверно", "black bun", bun.getName());
    }

    public void getBunPriceTest() {
        Assert.assertEquals("Цена Bun выведена неверно", 100f, bun.getPrice());
    }
}