package Questions.Chapter3;

import java.util.LinkedList;

/*
    Animal shelter holds only dogs/cats, operates on "first in, first out".
    People must adopt either the oldest animal at the shelter or oldest of
    either dog or cat. Can't select specific animal.
    Implement generic enqueue, dequeueAny, dequeueDog, dequeueCat
    Use LinkedList.
 */
public class Question3_7 {
    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());

        System.out.println(animals.shelterSize());
        System.out.println(animals.totalAnimalsHistory());
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    // order isn't decreased anywhere...
    // guess it's ok - makes comparisons easier.
    int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        }
        else {
            cats.add((Cat) a);
        }
    }
    // Should return oldest animal
    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        }
        else if (cats.size() == 0) {
            return dequeueDogs();
        }
        // If both lists have animals, need to compare order
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        }
        else {
            return cats.poll();
        }
    }

    public Animal peekAny() {
        if (dogs.size() == 0) {
            // could just be cats.peek()
            return peekCats();
        }
        else if (cats.size() == 0) {
            // dogs.peek()
            return peekDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dog;
        } else {
            return cat;
        }
    }

    public Cat dequeueCats() {
        // poll returns and removes from linked list.
        return cats.poll();
    }

    public Cat peekCats() {
        // peek returns but doesn't remove.
        return cats.peek();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Dog peekDogs() {
        return dogs.peek();
    }
    // number of all animals currently in shelter.
    public int shelterSize() {
        return dogs.size() + cats.size();
    }
    // number of animals ever in shelter.
    public int totalAnimalsHistory() {
        return order + 1;
    }
}

abstract class Animal {
    int order;
    String name;
    // Separate name methods in Dog/Cat class.
    public abstract String name();

    Animal(String n) {
        this.name = n;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public String name() {
        return "Cat's name is " + name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String name() {
        return "Dog's name is " + name;
    }
}
