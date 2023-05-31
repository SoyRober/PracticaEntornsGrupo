import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NumbersCatTest {
/*
    1. Zero
    2. Unitats (1-9)
    3. Negatius
    4. Decenes
        4.1 30-99
        4.2 20-29
        4.3 10-19
 */

    @Test
    public void donat_0_retorna_Zero() {
        Assertions.assertEquals("Zero", NumbersCat.say(0L));
    }

    @Test
    public void donat_1_retorna_Un() {
        Assertions.assertEquals("Un", NumbersCat.say(1L));
    }

    @Test
    public void donat_2_retorna_Dos() {
        Assertions.assertEquals("Dos", NumbersCat.say(2L));
    }

    @Test
    public void donat_9_retorna_Nou() {
        Assertions.assertEquals("Nou", NumbersCat.say(9L), "Donat el 9 retorna Nou");
    }

    @Test
    public void donat_Menys3() {
        Assertions.assertEquals("Menys tres", NumbersCat.say(-3));
    }

    @Test
    public void donat_30() {
        Assertions.assertEquals("Trenta", NumbersCat.say(30));
    }

    @Test
    public void donat_31() {
        Assertions.assertEquals("Trenta-un", NumbersCat.say(31));
    }

    @Test
    public void donat_41_retorna_Quaranta_un() {
        Assertions.assertEquals("Quaranta-un", NumbersCat.say(41L));
    }

    @Test
    public void donat_39() {
        Assertions.assertEquals("Trenta-nou", NumbersCat.say(39));
    }

    @Test
    public void donat_41() {
        Assertions.assertEquals("Quaranta-un", NumbersCat.say(41));
    }

    @Test
    public void donat_40() {
        Assertions.assertEquals("Quaranta", NumbersCat.say(40));
    }

    @Test
    public void donat_99_retorna_Noranta_nou() {
        Assertions.assertEquals("Noranta-nou", NumbersCat.say(99L));
    }

    @Test
    public void donat_20_retorna_Vint() {
        Assertions.assertEquals("Vint", NumbersCat.say(20L));
    }

    @Test
    public void donat_21_retorna_Vint_i_un() {
        Assertions.assertEquals("Vint-i-un", NumbersCat.say(21L));
    }

    @Test
    public void donat_100_retorna_Cent() {
        Assertions.assertEquals("Cent", NumbersCat.say(100L));
    }

    @Test
    public void donat_999_retorna_Nou_cents_noranta_nou() {
        Assertions.assertEquals("Nou-cents noranta-nou", NumbersCat.say(999L));
    }

    @Test
    public void donat_1000_retorna_Mil() {
        Assertions.assertEquals("Mil", NumbersCat.say(1000L));
    }

    @Test
    public void donat_1057_retorna_Mil_cinquanta_set() {
        Assertions.assertEquals("Mil cinquanta-set", NumbersCat.say(1057L));
    }

    @Test
    public void donat_1237() {
        Assertions.assertEquals("Mil dos-cents trenta-set", NumbersCat.say(1237L));
    }

    @Test
    public void donat_5123() {
        Assertions.assertEquals("Cinc mil cent vint-i-tres", NumbersCat.say(5123L));
    }

    @Test
    public void donat_323191() {
        Assertions.assertEquals("Tres-cents vint-i-tres mil cent noranta-un", NumbersCat.say(323191L));
    }

    @Test
    public void donat_1000000() {
        Assertions.assertEquals("Milió", NumbersCat.say(1000000L));
    }

    @Test
    public void donat_1_023_983() {
        Assertions.assertEquals("Milió vint-i-tres mil nou-cents vuitanta-tres", NumbersCat.say(1_023_983L));
    }

    @Test
    public void donat_6_204_323() {
        Assertions.assertEquals("Sis milions dos-cents quatre mil tres-cents vint-i-tres", NumbersCat.say(6_204_323L));
    }
}
