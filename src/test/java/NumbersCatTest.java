import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.NumbersCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NumbersCatTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new NumbersCat();
    }

    @Test
    public void donat_0_retorna_Zero() {
        Assertions.assertEquals("Zero", numbers.say(0L));
    }

    @Test
    public void donat_1_retorna_Un() {
        Assertions.assertEquals("Un", numbers.say(1L));
    }

    @Test
    public void donat_2_retorna_Dos() {
        Assertions.assertEquals("Dos", numbers.say(2L));
    }

    @Test
    public void donat_9_retorna_Nou() {
        Assertions.assertEquals("Nou", numbers.say(9L), "Donat el 9 retorna Nou");
    }

    @Test
    public void donat_Menys3() {
        Assertions.assertEquals("Menys tres", numbers.say(-3));
    }

    @Test
    public void donat_30() {
        Assertions.assertEquals("Trenta", numbers.say(30));
    }

    @Test
    public void donat_31() {
        Assertions.assertEquals("Trenta-un", numbers.say(31));
    }

    @Test
    public void donat_41_retorna_Quaranta_un() {
        Assertions.assertEquals("Quaranta-un", numbers.say(41L));
    }

    @Test
    public void donat_39() {
        Assertions.assertEquals("Trenta-nou", numbers.say(39));
    }

    @Test
    public void donat_41() {
        Assertions.assertEquals("Quaranta-un", numbers.say(41));
    }

    @Test
    public void donat_40() {
        Assertions.assertEquals("Quaranta", numbers.say(40));
    }

    @Test
    public void donat_99_retorna_Noranta_nou() {
        Assertions.assertEquals("Noranta-nou", numbers.say(99L));
    }

    @Test
    public void donat_20_retorna_Vint() {
        Assertions.assertEquals("Vint", numbers.say(20L));
    }

    @Test
    public void donat_21_retorna_Vint_i_un() {
        Assertions.assertEquals("Vint-i-un", numbers.say(21L));
    }

    @Test
    public void donat_100_retorna_Cent() {
        Assertions.assertEquals("Cent", numbers.say(100L));
    }

    @Test
    public void donat_999_retorna_Nou_cents_noranta_nou() {
        Assertions.assertEquals("Nou-cents noranta-nou", numbers.say(999L));
    }

    @Test
    public void donat_1000_retorna_Mil() {
        Assertions.assertEquals("Mil", numbers.say(1000L));
    }

    @Test
    public void donat_1057_retorna_Mil_cinquanta_set() {
        Assertions.assertEquals("Mil cinquanta-set", numbers.say(1057L));
    }

    @Test
    public void donat_1237() {
        Assertions.assertEquals("Mil dos-cents trenta-set", numbers.say(1237L));
    }

    @Test
    public void donat_5123() {
        Assertions.assertEquals("Cinc mil cent vint-i-tres", numbers.say(5123L));
    }

    @Test
    public void donat_323191() {
        Assertions.assertEquals("Tres-cents vint-i-tres mil cent noranta-un", numbers.say(323191L));
    }

    @Test
    public void donat_1000000() {
        Assertions.assertEquals("Milió", numbers.say(1000000L));
    }

    @Test
    public void donat_1_023_983() {
        Assertions.assertEquals("Milió vint-i-tres mil nou-cents vuitanta-tres", numbers.say(1_023_983L));
    }

    @Test
    public void donat_6_204_323() {
        Assertions.assertEquals("Sis milions dos-cents quatre mil tres-cents vint-i-tres", numbers.say(6_204_323L));
    }
}
