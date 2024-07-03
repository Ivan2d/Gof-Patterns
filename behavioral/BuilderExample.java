package behavioral;

public class BuilderExample {
    public static void main(String[] args) {
        Person person = Person.builder()
                .age(12)
                .name("Anton")
                .build();
        System.out.println(person.age + " " + person.name);

        Person person1 = new PersonBuilderImpl()
                .age(12)
                .name("Anton")
                .build();
        System.out.println(person1.age + " " + person1.name);
    }
}

class Person {
    String name;
    int age;

    Person() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Person person;

        private Builder() {
            this.person = new Person();
        }

        Builder name(String name) {
            person.name = name;
            return this;
        }

        Builder age(int age) {
            person.age = age;
            return this;
        }

        Person build() {
            return person;
        }
    }
}

interface PersonBuilder {
    PersonBuilder name(String str);
    PersonBuilder age(int age);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder {
    private Person person;

    public PersonBuilderImpl() {
        this.person = new Person();
    }

    @Override
    public PersonBuilder name(String name) {
        this.person.name = name;
        return this;
    }

    @Override
    public PersonBuilder age(int age) {
        this.person.age = age;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}
