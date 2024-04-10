package carShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests {
    CarShop carShop = new CarShop();
    Car car1 = new Car("model", 100, 100);
    Car car2 = new Car("model", 101, 101);

    @Before
    public void setUp() {
        CarShop carShop = new CarShop();
        Car car1 = new Car("model", 100, 100);
        Car car2 = new Car("model", 101, 101);
    }

    @Test
    public void test_ConstructorWorksProperly() {
        List<Car> cars = new ArrayList<>();
        Assert.assertEquals(carShop.getCars(), cars);
    }

    @Test
    public void test_getCount() {
        carShop.add(car1);
        Assert.assertEquals(1, carShop.getCount());
    }

    @Test
    public void test_findAllCarsWithMaxHorsepower() {
        carShop.add(car1);
        carShop.add(car2);
        List<Car> cars = carShop.findAllCarsWithMaxHorsePower(100);

        List<Car> expectedList = new ArrayList<>();
        expectedList.add(car2);
        Assert.assertEquals(expectedList, cars);
    }

    @Test(expected = NullPointerException.class)
    public void test_addCarCantBeNull() {
        carShop.add(null);
    }

    @Test
    public void test_removeRemoves() {
        carShop.add(car1);
        Assert.assertTrue(carShop.remove(car1));
    }

    @Test
    public void test_findMostLuxuryCar() {
        carShop.add(car1);
        carShop.add(car2);
        Car car = carShop.getTheMostLuxuryCar();
        Assert.assertEquals(car2, car);
    }

    @Test
    public void test_findAllCarsByModel() {
        carShop.add(car1);
        carShop.add(car2);
        List<Car> expectedList = new ArrayList<>();
        expectedList.add(car1);
        expectedList.add(car2);
        List<Car> actualList = carShop.findAllCarByModel("model");
        Assert.assertEquals(expectedList, actualList);
    }
}

