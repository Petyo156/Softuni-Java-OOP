package archeologicalExcavations;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExcavationTests {
    private Excavation excavation;

    private static final String EXPECTED_NAME = "Excavation";
    private static final int EXPECTED_CAPACITY = 3;
    private static final int EXPECTED_COUNT = 0;

    @Before
    public void setUp() {
        excavation = new Excavation(EXPECTED_NAME, EXPECTED_CAPACITY);
    }

    @After
    public void tearUp() {
        excavation = new Excavation(EXPECTED_NAME, EXPECTED_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldThrowWhenWrongCapacity() {
        excavation = new Excavation(EXPECTED_NAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowWhenNullName() {
        excavation = new Excavation(null, EXPECTED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowWhenEmptyName() {
        excavation = new Excavation("", EXPECTED_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_ShouldThrowWhenBlankName() {
        excavation = new Excavation("      ", EXPECTED_CAPACITY);
    }

    @Test
    public void test_ConstructorShouldCreateCorrectObject() {
        String actualName = excavation.getName();
        int actualCapacity = excavation.getCapacity();
        int actualCount = excavation.getCount();

        assertEquals(EXPECTED_NAME, actualName);
        assertEquals(EXPECTED_CAPACITY, actualCapacity);
        assertEquals(EXPECTED_COUNT, actualCount);
    }

//    @Test
//    public void test_ShouldGetCorrectCount() {
//        Archaeologist archaeologist = Mockito.mock(Archaeologist.class);
//        Archaeologist archaeologist1 = Mockito.mock(Archaeologist.class);
//        Archaeologist archaeologist2 = Mockito.mock(Archaeologist.class);
//
//        this.excavation.addArchaeologist(archaeologist);
//        this.excavation.addArchaeologist(archaeologist1);
//        this.excavation.addArchaeologist(archaeologist2);
//
//        assertEquals(3, this.excavation.getCount());
//    }

    @Test
    public void test_ShouldBeAbleToAdd() {
        Archaeologist archaeologist = new Archaeologist("a",1);

        this.excavation.addArchaeologist(archaeologist);
        assertEquals(1, this.excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldNotBeAbleToAddDueNoCapacity() {
        Archaeologist archaeologist1 = new Archaeologist("a",1);
        Archaeologist archaeologist2 = new Archaeologist("b",1);
        Archaeologist archaeologist3 = new Archaeologist("c",1);
        Archaeologist archaeologist4 = new Archaeologist("d",1);
        this.excavation.addArchaeologist(archaeologist1);
        this.excavation.addArchaeologist(archaeologist2);
        this.excavation.addArchaeologist(archaeologist3);
        this.excavation.addArchaeologist(archaeologist4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ShouldNotBeAbleToAddDueDuplicated() {
        Archaeologist archaeologist = new Archaeologist("a",1);
        Archaeologist archaeologist1 = new Archaeologist("a",1);

        this.excavation.addArchaeologist(archaeologist);
        this.excavation.addArchaeologist(archaeologist1);
    }

    @Test
    public void test_ShouldRemoveSuccessfully(){
        Archaeologist archaeologist = new Archaeologist("a",1);
        this.excavation.addArchaeologist(archaeologist);
        boolean isRemoved = this.excavation.removeArchaeologist("a");
        int actual = excavation.getCount();

        assertTrue(isRemoved);
        assertEquals(0, actual);
    }

    @Test
    public void test_ShouldRemoveUnsuccessfully() {
        boolean isRemoved = excavation.removeArchaeologist("");
        assertFalse(isRemoved);
    }

}
