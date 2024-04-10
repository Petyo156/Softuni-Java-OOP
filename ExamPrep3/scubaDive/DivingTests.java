package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {
    public static final DeepWaterDiver DEEP_WATER_DIVER = new DeepWaterDiver("name", 5.0);

    @Test(expected = NullPointerException.class)
    public void test_ConstructorInvalidNameThrowsWhenNull() {
        Diving diving = new Diving(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void test_ConstructorInvalidNameThrowsWhenEmpty() {
        Diving diving = new Diving("", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ConstructorThrowsWhenCapacityLessThan0() {
        Diving diving = new Diving("name", -1);
    }

    @Test
    public void test_ConstructorWorksProperly() {
        Diving diving = new Diving("name", 1);
    }

    @Test
    public void test_getCountWorksProperly() {
        Diving diving = new Diving("name", 1);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);
        Assert.assertEquals(1, diving.getCount());
    }

    @Test
    public void test_getNameWorksProperly() {
        Diving diving = new Diving("name", 1);
        Assert.assertEquals("name", diving.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_thereIsNoSpaceForNewDiver(){
        Diving diving = new Diving("name", 1);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);

        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("name1",10);
        diving.addDeepWaterDiver(deepWaterDiver);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_thereIsNoSuchDiver(){
        Diving diving = new Diving("name", 3);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);
    }

    @Test
    public void test_addDiverWorksProperly(){
        Diving diving = new Diving("name", 3);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);

        DeepWaterDiver deepWaterDiver = new DeepWaterDiver("name1",10);
        diving.addDeepWaterDiver(deepWaterDiver);
    }

    @Test
    public void test_removeDeepWaterDiverExpectNull(){
        Diving diving = new Diving("name", 3);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);
        boolean exists = diving.removeDeepWaterDiver("Petar");
        Assert.assertFalse(exists);
    }

    @Test
    public void test_removeDeepWaterDiverSuccessfully(){
        Diving diving = new Diving("name", 3);
        diving.addDeepWaterDiver(DEEP_WATER_DIVER);
        boolean exists = diving.removeDeepWaterDiver("name");
        Assert.assertTrue(exists);
    }
}
