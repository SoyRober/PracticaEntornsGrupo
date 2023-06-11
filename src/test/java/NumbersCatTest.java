import net.esliceu.numbers.Numbers;
import net.esliceu.numbers.NumbersCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NumbersCatTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new NumbersCat();
    }

    @Test
    void donat_0_retorna_Zero() {
        Assertions.assertEquals("Zero", numbers.say(0L));
    }

    @Test
    void donat_1_retorna_Un() {
        Assertions.assertEquals("Un", numbers.say(1L));
    }

    @Test
    void donat_2_retorna_Dos() {
        Assertions.assertEquals("Dos", numbers.say(2L));
    }

    @Test
    void donat_9_retorna_Nou() {
        Assertions.assertEquals("Nou", numbers.say(9L), "Donat el 9 retorna Nou");
    }

    @Test
    void donat_Menys3() {
        Assertions.assertEquals("Menys tres", numbers.say(-3));
    }

    @Test
    void donat_30() {
        Assertions.assertEquals("Trenta", numbers.say(30));
    }

    @Test
    void donat_31() {
        Assertions.assertEquals("Trenta-un", numbers.say(31));
    }

    @Test
    void donat_41_retorna_Quaranta_un() {
        Assertions.assertEquals("Quaranta-un", numbers.say(41L));
    }

    @Test
    void donat_39() {
        Assertions.assertEquals("Trenta-nou", numbers.say(39));
    }

    @Test
    void donat_41() {
        Assertions.assertEquals("Quaranta-un", numbers.say(41));
    }

    @Test
    void donat_40() {
        Assertions.assertEquals("Quaranta", numbers.say(40));
    }

    @Test
    void donat_99_retorna_Noranta_nou() {
        Assertions.assertEquals("Noranta-nou", numbers.say(99L));
    }

    @Test
    void donat_20_retorna_Vint() {
        Assertions.assertEquals("Vint", numbers.say(20L));
    }

    @Test
    void donat_21_retorna_Vint_i_un() {
        Assertions.assertEquals("Vint-i-un", numbers.say(21L));
    }

    @Test
    void donat_100_retorna_Cent() {
        Assertions.assertEquals("Cent", numbers.say(100L));
    }

    @Test
    void donat_999_retorna_Nou_cents_noranta_nou() {
        Assertions.assertEquals("Nou-cents noranta-nou", numbers.say(999L));
    }

    @Test
    void donat_1000_retorna_Mil() {
        Assertions.assertEquals("Mil", numbers.say(1000L));
    }

    @Test
    void donat_1057_retorna_Mil_cinquanta_set() {
        Assertions.assertEquals("Mil cinquanta-set", numbers.say(1057L));
    }

    @Test
    void donat_1237() {
        Assertions.assertEquals("Mil dos-cents trenta-set", numbers.say(1237L));
    }

    @Test
    void donat_5123() {
        Assertions.assertEquals("Cinc mil cent vint-i-tres", numbers.say(5123L));
    }

    @Test
    void donat_323191() {
        Assertions.assertEquals("Tres-cents vint-i-tres mil cent noranta-un", numbers.say(323191L));
    }

    @Test
    void donat_1000000() {
        Assertions.assertEquals("Milió", numbers.say(1000000L));
    }

    @Test
    void donat_1_023_983() {
        Assertions.assertEquals("Milió vint-i-tres mil nou-cents vuitanta-tres", numbers.say(1_023_983L));
    }

    @Test
    void donat_6_204_323() {
        Assertions.assertEquals("Sis milions dos-cents quatre mil tres-cents vint-i-tres", numbers.say(6_204_323L));
    }

    @Test
    void donat_1845135() {
        Assertions.assertEquals("Milió vuit-cents quaranta-cinc mil cent trenta-cinc", numbers.say(1845135L));
    }

    @Test
    void donat_1086() {
        Assertions.assertEquals("Mil vuitanta-sis", numbers.say(1086L));
    }

    @Test
    void donat_658715() {
        Assertions.assertEquals("Sis-cents cinquanta-vuit mil set-cents cinquanta-tres", numbers.say(658753L));
    }

    @Test
    void donat_1086_retorna_Mil_vuitanta_sis() {
        Assertions.assertEquals("Mil vuitanta-sis", numbers.say(1086L));
    }

    @Test
    void donat_1845135_retorna_Milio_vuit_cents_quaranta_cinc_mil_cent_trenta_cinc() {
        Assertions.assertEquals("Milió vuit-cents quaranta-cinc mil cent trenta-cinc", numbers.say(1845135L));
    }
}
