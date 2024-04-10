package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if(!name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setAge(int age) {
        if(age>0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setGender(String gender) {
        if(!gender.isEmpty() && !gender.isBlank()) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String produceSound(){
        return "Sound";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n" +
                String.format("%s %d %s%n", this.getName(), this.getAge(), this.getGender()) +
                produceSound();

    }
}
