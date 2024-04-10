package petStore;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetStoreTests {
    private static Animal animal = new Animal("a", 2, 2);

    @Test
    public void test_ConstructorWorksProperly(){
        PetStore petStore = new PetStore();
    }

    @Test
    public void test_getAnimalsShouldWorkProperly(){
        PetStore petStore = new PetStore();
        List<Animal> animals = petStore.getAnimals();
        Assert.assertEquals(Collections.unmodifiableList(animals), petStore.getAnimals());
    }

    @Test
    public void test_getCountWorksProperly(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);
        Assert.assertEquals(1,petStore.getCount());
    }

    @Test
    public void test_findAllAnimalsWithMaxKilogramsWorks(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(1);

        Assert.assertEquals(1, animals.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addAnimalThrows(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void test_addAnimalAddsCorrectly(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);

        Assert.assertEquals(1, petStore.getAnimals().size());
    }

    @Test
    public void test_getTheMostExpensiveAnimal(){
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal);
        Animal mostExpenciveAnimal = new Animal("a", 2, 3000);
        petStore.addAnimal(mostExpenciveAnimal);

        Animal expectedAnimal = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(mostExpenciveAnimal,expectedAnimal);
    }

    @Test
    public void test_findAllAnimalBySpecie(){
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("qk", 2, 2);
        Animal animal2 = new Animal("qk", 2, 2);
        Animal animal3 = new Animal("ne qk", 2, 2);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(animal1);
        expectedList.add(animal2);

        List<Animal> actualList = petStore.findAllAnimalBySpecie("qk");
        Assert.assertEquals(expectedList,actualList);
    }
}

