package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;


class MainTest {

    @Test
    void task1() {
        List<Animal> animals = new ArrayList<>();
        // all animals suit for conditions
        for (int i = 1; i < 50; i++) {
            animals.add(getAnimal(i));
        }
        try (MockedStatic<Util> utilMockedStatic = Mockito.mockStatic(Util.class)) {
            utilMockedStatic.when(Util::getAnimals).thenReturn(animals);
            ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputContent));
            Main.task1();
            // the third zoo has to contain animals with id from 15 to 21
            assertTrue(outputContent.toString().contains("id=15"));
        }
    }

    private Animal getAnimal(int id) {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setAge(15);
        animal.setBread("breed");
        animal.setOrigin("origin");
        animal.setGender("male");
        return animal;
    }
}
