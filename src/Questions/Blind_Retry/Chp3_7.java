package Questions.Blind_Retry;
import java.util.LinkedList;
/*
    Animal shelter holds only dogs/cats, operates on "first in, first out".
    People must adopt either the oldest animal at the shelter or oldest of
    either dog or cat. Can't select specific animal.
    Implement generic enqueue, dequeueAny, dequeueDog, dequeueCat
    Use LinkedList.
 */
public class Chp3_7 {
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

        System.out.println(animals.dequeueAny().getName());
        System.out.println(animals.dequeueAny().getName());
        System.out.println(animals.dequeueAny().getName());

        System.out.println(animals.dequeueCat().getName());
        System.out.println(animals.dequeueDog().getName());
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else {
            cats.add((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            dequeueCat();
        } else if (cats.size() == 0) {
            dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}

abstract class Animal {
    String name;
    int order;

    public abstract String getName();

    Animal(String n) { this.name = n; }

    public void setOrder(int ord) {
        this.order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Dog extends Animal {
        Dog(String n) {
            super(n);
        }
        public String getName() {
            return "The dog's name is " + name;
        }
}

class Cat extends Animal {
        Cat(String n) {
           super(n);
        }
        public String getName() {
            return "The cat's name is " + name;
        }
}
