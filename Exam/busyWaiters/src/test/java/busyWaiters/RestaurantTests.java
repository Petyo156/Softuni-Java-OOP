package busyWaiters;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class RestaurantTests {
    private Restaurant restaurant = new Restaurant("name", 2);
    private FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("Petar", 3);
    private FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("Ivan", 5);

    @After
    public void cleanUp(){
        restaurant = new Restaurant("name", 2);
        fullTimeWaiter1 = new FullTimeWaiter("Petar", 3);
        fullTimeWaiter2 = new FullTimeWaiter("Ivan", 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_constructorThrowsWhenNameNull(){
        Restaurant r = new Restaurant(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void test_constructorThrowsWhenNameEmpty(){
        Restaurant r = new Restaurant("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructorThrowsWhenCapacityNegative(){
        Restaurant r = new Restaurant("Hello", -5);
    }

    @Test
    public void test_workingConstructor(){
        Restaurant r = new Restaurant("Hello", 10);
    }

    @Test
    public void test_workingGetCapacity(){
        Assert.assertEquals(2, restaurant.getCapacity());
    }

    @Test
    public void test_workingGetName(){
        Assert.assertEquals("name", restaurant.getName());
    }

    @Test
    public void test_workingGetWaiters(){
        Collection<FullTimeWaiter> waiters = new ArrayList<>();
        Assert.assertEquals(waiters, restaurant.getWaiters());
    }

    @Test
    public void test_workingGetCount(){
        Assert.assertEquals(0, restaurant.getCount());
        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        Assert.assertEquals(1, restaurant.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addThrowsWhenNoCapacity(){
        Restaurant restaurant1 = new Restaurant("Alo", 1);
        restaurant1.addFullTimeWaiter(fullTimeWaiter1);
        restaurant1.addFullTimeWaiter(fullTimeWaiter2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addThrowsWhenAddingSameWaiter(){
        Restaurant restaurant1 = new Restaurant("Alo", 10);
        restaurant1.addFullTimeWaiter(fullTimeWaiter1);
        restaurant1.addFullTimeWaiter(fullTimeWaiter1);
    }

    @Test
    public void test_addWorks(){
        Assert.assertEquals(0, restaurant.getCount());
        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        Assert.assertEquals(1, restaurant.getCount());
    }

    @Test
    public void test_removeIsFalse(){
        Assert.assertFalse(restaurant.removeFullTimeWaiter("Gosho"));
    }

    @Test
    public void test_removeIsTrue(){
        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        Assert.assertTrue(restaurant.removeFullTimeWaiter("Petar"));
    }

}
