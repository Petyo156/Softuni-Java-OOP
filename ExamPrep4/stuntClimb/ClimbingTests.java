package stuntClimb;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingTests {
    private static final RockClimber ROCK_CLIMBER = new RockClimber("name", 10);

    @Test(expected = NullPointerException.class)
    public void test_ConstructorThrowsWhenEmptyName(){
        Climbing climbing = new Climbing("", 1);
    }

    @Test(expected = NullPointerException.class)
    public void test_ConstructorThrowsWhenNullName(){
        Climbing climbing = new Climbing(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ConstructorThrowsWhenCapacityLessThan0(){
        Climbing climbing = new Climbing("name", -1);
    }

    @Test
    public void test_ConstructorWorksProperly(){
        Climbing climbing = new Climbing("name", 3);
    }

    @Test
    public void test_getCountWorksProperly(){
        Climbing climbing = new Climbing("name", 3);
        climbing.addRockClimber(ROCK_CLIMBER);
        Assert.assertEquals(1, climbing.getCount());
    }

    @Test
    public void test_getNameWorksProperly(){
        Climbing climbing = new Climbing("name", 3);
        Assert.assertEquals("name", climbing.getName());
    }

    @Test
    public void test_getCapacityWorksProperly(){
        Climbing climbing = new Climbing("name", 3);
        Assert.assertEquals(3, climbing.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CantAddMoreDueNoCapacity(){
        Climbing climbing = new Climbing("name", 1);
        climbing.addRockClimber(ROCK_CLIMBER);

        RockClimber rockClimber = new RockClimber("dummy", 10);
        climbing.addRockClimber(rockClimber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CantAddWithTheSameName(){
        Climbing climbing = new Climbing("name", 1);
        climbing.addRockClimber(ROCK_CLIMBER);
        climbing.addRockClimber(ROCK_CLIMBER);
    }

    @Test
    public void test_AddFunctionWorksProperly(){
        Climbing climbing = new Climbing("name", 3);
        climbing.addRockClimber(ROCK_CLIMBER);
        Assert.assertEquals(1, climbing.getCount());

        RockClimber rockClimber = new RockClimber("dummy", 10);
        climbing.addRockClimber(rockClimber);
        Assert.assertEquals(2, climbing.getCount());
    }

    @Test
    public void test_removeFunctionRemovesSuccessfully(){
        Climbing climbing = new Climbing("name", 3);
        climbing.addRockClimber(ROCK_CLIMBER);
        boolean removes = climbing.removeRockClimber("name");
        Assert.assertTrue(removes);
    }

    @Test
    public void test_removeFunctionRemovesUnsuccessfully(){
        Climbing climbing = new Climbing("name", 3);
        climbing.addRockClimber(ROCK_CLIMBER);
        boolean removes = climbing.removeRockClimber("Pesho");
        Assert.assertFalse(removes);
    }

}
