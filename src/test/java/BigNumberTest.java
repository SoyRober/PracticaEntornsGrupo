import net.esliceu.numbers.BigNumber;
import net.esliceu.numbers.Numbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class BigNumberTest {

    private BigNumber bignumber;

    @Test
    public void comparacions() {
        BigNumber b1, b2;

        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals(b1, b2);

        b1 = new BigNumber("345345234523452352345");
        b2 = new BigNumber("000000000000000345345234523452352345");
        assertEquals(b1, b2);

        b1 = new BigNumber("56");
        b2 = new BigNumber("000000000000000000000000000000056");
        assertEquals(0, b1.compareTo(b2));

        b1 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(0, b1.compareTo(b2));

        b1 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(-1, b1.compareTo(b2));

        b1 = new BigNumber("556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(1, b1.compareTo(b2));

        b1 = new BigNumber("556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("556456345634563456345634556783678567856783456345634563456567456745674561");
        assertEquals(1, b1.compareTo(b2));

        b1 = new BigNumber("000556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("556456345734563456345634556783678567856783456345634563456567456745674561");
        assertEquals(-1, b1.compareTo(b2));

        b1 = new BigNumber("3");
        b2 = new BigNumber("14");
        assertEquals(-1, b1.compareTo(b2));
        assertEquals(1, b2.compareTo(b1));

        b1 = new BigNumber("35");
        b2 = new BigNumber("35");
        assertEquals(0, b2.compareTo(b1));

        b1 = new BigNumber("135");
        b2 = new BigNumber("136");
        assertEquals(-1, b1.compareTo(b2));
        assertEquals(1, b2.compareTo(b1));

        b1 = new BigNumber("00135");
        b2 = new BigNumber("136");
        assertEquals(-1, b1.compareTo(b2));
        assertEquals(1, b2.compareTo(b1));

        b1 = new BigNumber("135467845634556778909546345234534534512335");
        b2 = new BigNumber("135467845634556778909546345234534534512332");
        assertEquals(1, b1.compareTo(b2));
        assertEquals(-1, b2.compareTo(b1));
    }

    @Test
    public void sumes() {
        BigNumber b1, b2;

        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals(b1, b2);
        assertEquals(new BigNumber("4"), b1.add(b2));

        b1 = new BigNumber("12");
        b2 = new BigNumber("34");
        assertEquals(new BigNumber("46"), b1.add(b2));

        b1 = new BigNumber("00022");
        b2 = new BigNumber("090");
        assertEquals(new BigNumber("112"), b1.add(b2));

        b1 = new BigNumber("123");
        b2 = new BigNumber("999");
        assertEquals(new BigNumber("1122"), b1.add(b2));

        b1 = new BigNumber("999");
        b2 = new BigNumber("999");
        assertEquals(new BigNumber("1998"), b1.add(b2));

        b1 = new BigNumber("567456234578945345234234456");
        b2 = new BigNumber("456235768978078934523523452345456");
        assertEquals(new BigNumber("456236336434313513468868686579912"), b1.add(b2));

        b1 = new BigNumber("342234234123423576789423422323123412341234");
        b2 = new BigNumber("3245234789789234234123784567892349789456");
        assertEquals(new BigNumber("345479468913212811023547206891015762130690"), b1.add(b2));
    }

    @Test
    public void restes() {
        BigNumber b1, b2;

        b1 = new BigNumber("60");
        b2 = new BigNumber("010");
        assertEquals(new BigNumber("50"), b1.substract(b2));

        b1 = new BigNumber("34535233");
        b2 = new BigNumber("04533453");
        assertEquals(new BigNumber("30001780"), b1.substract(b2));

        b1 = new BigNumber("7");
        b2 = new BigNumber("3");
        assertEquals(new BigNumber("4"), b1.substract(b2));

        b1 = new BigNumber("14");
        b2 = new BigNumber("12");
        assertEquals(new BigNumber("2"), b1.substract(b2));

        b1 = new BigNumber("34");
        b2 = new BigNumber("19");
        assertEquals(new BigNumber("15"), b1.substract(b2));

        b1 = new BigNumber("32453453");
        b2 = new BigNumber("2313");
        assertEquals(new BigNumber("32451140"), b1.substract(b2));

        b1 = new BigNumber("32456789567456786783453");
        b2 = new BigNumber("2345664556756713");
        assertEquals(new BigNumber("32456787221792230026740"), b1.substract(b2));

        b1 = new BigNumber("56734564576346234567567834534565675674567");
        b2 = new BigNumber("999999999999999999999999999999999999999");
        assertEquals(new BigNumber("55734564576346234567567834534565675674568"), b1.substract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("0000000000000000000000000000000000000000000000000000000000011");
        assertEquals(new BigNumber("45634563456565555557854564223429999886785678901"), b1.substract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals(new BigNumber("45633773666767576103320029688862132063295780013"), b1.substract(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals(new BigNumber("45633773666767576103320029688862132063295780013"), b1.substract(b2));
    }
}