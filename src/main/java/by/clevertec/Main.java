package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.time.Period.between;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;

public class Main {
    private static final String NOT_FOUND = "Nothing was found according to your conditions";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final String JAPANESE = "Japanese";
    private static final String HUNGARIAN = "Hungarian";
    private static final String OCEANIA = "Oceania";
    private static final String TURKMENISTAN = "Turkmenistan";
    private static final String KAZAKHSTAN = "Kazakhstan";
    private static final String UZBEKISTAN = "Uzbekistan";
    private static final String KYRGYZSTAN = "Kyrgyzstan";
    private static final String RUSSIA = "Russia";
    private static final String MONGOLIA = "Mongolia";
    private static final String INDONESIAN = "Indonesian";
    private static final String COUNTRY_NONE = "None";
    private static final String LETTER_A = "A";
    private static final char CHAR_C = 'C';
    private static final char CHAR_S = 'S';
    private static final String HOSPITAL = "hospital";
    private static final String PERSON = "person";
    private static final String JAGUAR = "Jaguar";
    private static final String BMW = "bmw";
    private static final String LEXUS = "lexus";
    private static final String CHRYSLER = "chrysler";
    private static final String TOYOTA = "toyota";
    private static final String GMC = "GMC";
    private static final String DODGE = "Dodge";
    private static final String CIVIC = "Civic";
    private static final String CHEROKEE = "Cherokee";
    private static final String COLOR_WHITE = "white";
    private static final String COLOR_BLACK = "black";
    private static final String COLOR_YELLOW = "yellow";
    private static final String COLOR_RED = "red";
    private static final String COLOR_GREEN = "green";
    private static final String COLOR_BLUE = "blue";
    private static final String NUM_59 = "59";
    private static final String MATERIAL_GLASS = "Glass";
    private static final String MATERIAL_ALUMINUM = "Aluminum";
    private static final String MATERIAL_STEEL = "Steel";

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> res = animals.stream()
                .filter(a -> a.getAge() >= 10 && a.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7).toList();
        out.println(res);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> JAPANESE.equalsIgnoreCase(animal.getOrigin()))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .filter(animal -> FEMALE.equalsIgnoreCase(animal.getGender()))
                .map(Animal::getBread)
                .forEach(out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream().filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .distinct()
                .filter(origin -> origin.startsWith(LETTER_A))
                .forEach(out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long count = animals.stream()
                .filter(animal -> FEMALE.equalsIgnoreCase(animal.getGender()))
                .count();
        out.println("Female animals = " + count);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        boolean isFromHungarian = animals.stream()
                .anyMatch(animal -> animal.getAge() >= 20
                        && animal.getAge() <= 30
                        && HUNGARIAN.equalsIgnoreCase(animal.getOrigin()));
        out.println("Is anything from Hungarian? " + isFromHungarian);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean allMaleFemale = animals.stream()
                .allMatch(animal -> MALE.equalsIgnoreCase(animal.getGender())
                        || FEMALE.equalsIgnoreCase(animal.getGender()));
        out.println("Is everyone male or female? " + allMaleFemale);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean isNotFromOceania = animals.stream()
                .noneMatch(animal -> OCEANIA.equalsIgnoreCase(animal.getOrigin()));
        out.println("No one from Oceania? " + isNotFromOceania);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        int oldestAnimal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND));
        out.println("The oldest animal is " + oldestAnimal + " years old");
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        int smallestArray = animals.stream()
                .mapToInt(animal -> animal.getBread().toCharArray().length)
                .min()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND));
        out.println("The long of the smallest array is " + smallestArray);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        out.println("The total age of all animals is " + animals.stream().mapToInt(Animal::getAge).sum());
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        double avg = animals.stream()
                .filter(animal -> INDONESIAN.equalsIgnoreCase(animal.getOrigin()))
                .mapToInt(Animal::getAge)
                .average()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND));
        out.println("Average age of all animals from Indonesian is " + avg);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(p -> MALE.equalsIgnoreCase(p.getGender()))
                .filter(p -> between(p.getDateOfBirth(), LocalDate.now()).getYears() >= 18
                        && between(p.getDateOfBirth(), LocalDate.now()).getYears() <= 27)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
        houses.stream()
                .flatMap(h -> h.getPersonList()
                        .stream()
                        .map(p -> Map.of(HOSPITAL, HOSPITAL.equalsIgnoreCase(h.getBuildingType()), PERSON, p)))
                .sorted((mp1, mp2) -> {
                    int p1Weight = mp1.get(HOSPITAL).equals(true) ? 10 : (isChildOrOldPerson((Person) mp1.get(PERSON)) ? 1 : 0);
                    int p2Weight = mp2.get(HOSPITAL).equals(true) ? 10 : (isChildOrOldPerson((Person) mp2.get(PERSON)) ? 1 : 0);
                    return p2Weight - p1Weight;
                })
                .map(mp -> (Person) mp.get(PERSON))
                .limit(500)
                .toList()
                .forEach(out::println);
    }

    private static boolean isChildOrOldPerson(Person person) {
        String gender = person.getGender();
        int fullYears = between(person.getDateOfBirth(), LocalDate.now()).getYears();
        boolean child = fullYears < 18;
        boolean oldWoman = FEMALE.equalsIgnoreCase(gender) && fullYears >= 58;
        boolean oldMan = MALE.equalsIgnoreCase(gender) && fullYears >= 63;
        return child || oldMan || oldWoman;
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
        Map<String, IntSummaryStatistics> map = cars.stream()
                .collect(groupingBy(Main::getCountryToFollow, summarizingInt(Car::getMass)));
        map.remove(COUNTRY_NONE);
        map.forEach((k, v) -> {
            out.print("Country: " + k);
            out.print("\ttotal mass: " + v.getSum());
            out.println("\ttotal cost: " + BigDecimal.valueOf(v.getSum() * 7.14 / 1000).setScale(2, RoundingMode.HALF_UP));
        });
        double total = map.values().stream()
                .mapToLong(IntSummaryStatistics::getSum)
                .sum() * 7.14 / 1000;
        out.println("TOTAL REVENUE = " + BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP));
    }

    private static String getCountryToFollow(Car car) {
        if (JAGUAR.equalsIgnoreCase(car.getCarMake()) || COLOR_WHITE.equalsIgnoreCase(car.getColor())) {
            return TURKMENISTAN;
        }
        boolean makeCondition;
        switch (car.getCarMake().toLowerCase()) {
            case BMW, LEXUS, CHRYSLER, TOYOTA -> makeCondition = true;
            default -> makeCondition = false;
        }
        if (car.getMass() < 1500 && makeCondition) {
            return UZBEKISTAN;
        }
        if (COLOR_BLACK.equalsIgnoreCase(car.getColor()) && car.getMass() > 4000
                || GMC.equalsIgnoreCase(car.getCarMake())
                || DODGE.equalsIgnoreCase(car.getCarMake())) {
            return KAZAKHSTAN;
        }
        if (car.getReleaseYear() < 1982
                || CIVIC.equalsIgnoreCase(car.getCarModel())
                || CHEROKEE.equalsIgnoreCase(car.getCarModel())) {
            return KYRGYZSTAN;
        }
        boolean colorCondition;
        switch (car.getColor().toLowerCase()) {
            case COLOR_YELLOW, COLOR_RED, COLOR_GREEN, COLOR_BLUE -> colorCondition = false;
            default -> colorCondition = true;
        }
        if (colorCondition || car.getPrice() > 40_000) {
            return RUSSIA;
        }
        if (car.getVin().contains(NUM_59)) {
            return MONGOLIA;
        }
        return COUNTRY_NONE;
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        BigDecimal total = flowers.stream()
                .sorted((f1, f2) -> {
                    int resultCompare = f2.getOrigin().compareToIgnoreCase(f1.getOrigin());
                    if (resultCompare == 0) {
                        resultCompare = f1.getPrice() - f2.getPrice();
                    }
                    if (resultCompare == 0) {
                        Double waterConsumption1 = f1.getWaterConsumptionPerDay();
                        Double waterConsumption2 = f2.getWaterConsumptionPerDay();
                        resultCompare = waterConsumption2.compareTo(waterConsumption1);
                    }
                    return resultCompare;
                })
                .filter(f -> {
                    char firstChar = f.getCommonName().charAt(0);
                    return firstChar >= CHAR_C && firstChar <= CHAR_S;
                })
                .filter(Flower::isShadePreferred)
                .filter(f -> {
                    List<String> vaseMaterials = f.getFlowerVaseMaterial();
                    return vaseMaterials.contains(MATERIAL_GLASS)
                            || vaseMaterials.contains(MATERIAL_ALUMINUM)
                            || vaseMaterials.contains(MATERIAL_STEEL);
                })
                .map(f -> f.getPrice() + f.getWaterConsumptionPerDay() * 365 * 5 * 1.39 / 1000)
                .reduce(BigDecimal.ZERO, (startVal, p) -> startVal.add(BigDecimal.valueOf(p)).setScale(2, RoundingMode.HALF_UP), BigDecimal::add);
        out.println("General expenses = " + total);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(s -> s.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .map(s -> s.getSurname() + " is " + s.getAge() + " years old")
                .forEach(out::println);
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(groupingBy(Student::getFaculty, averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> out.println("Faculty " + entry.getKey() + " average age " + entry.getValue()));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        List<Integer> passedStudId = examinations.stream()
                .filter(e -> e.getExam3() > 4)
                .map(Examination::getStudentId)
                .toList();
        students.stream()
                .filter(s -> passedStudId.contains(s.getId()))
                .collect(groupingBy(Student::getGroup, toList()))
                .forEach((key, value) -> out.println("in group " + key + " exam3 was passed next students: " + value));
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, Double> facultyToAverage = examinations.stream()
                .collect(Collectors.groupingBy(
                        exam -> students.stream()
                                .filter(student -> student.getId() == exam.getStudentId())
                                .findFirst()
                                .map(Student::getFaculty)
                                .orElseThrow(RuntimeException::new),
                        Collectors.averagingInt(Examination::getExam1)
                ));
        out.println("Max average mark is on the faculty of " + facultyToAverage.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(RuntimeException::new).getKey());
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()))
                .forEach((key, value) -> out.println("Group " + key + " count of students " + value));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.mapping(
                                Student::getAge,
                                Collectors.minBy(Integer::compare)
                        )
                )).forEach((k, v) ->
                        out.println("Faculty " + k + " has the youngest people with " + v.orElseThrow(RuntimeException::new) + " years old"));
    }
}
