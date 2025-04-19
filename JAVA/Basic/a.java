package Basic;

// Superclass Animal
class Animal {
  // Method that will be overridden
  public void sound() {
      System.out.println("The animal makes a sound");
  }
}

// Subclass Dog that overrides the sound method
class Dog extends Animal {

  public void sound() {
      System.out.println("The dog barks");
  }
}

// Subclass Cat that also overrides the sound method
class Cat extends Animal {
  public void sound() {
      System.out.println("The cat meows");
  }
}

// Main class to demonstrate method overriding
public class a {
  public static void main(String[] args) {
      // Create an object of Animal class
      Animal myAnimal = new Animal();
      myAnimal.sound(); // Calls the Animal class method

      // Create an object of Dog class
      Dog myDog = new Dog();
      myDog.sound(); // Calls the Dog class method

      // Create an object of Cat class
     Cat myCat = new Cat();
      myCat.sound(); // Calls the Cat class method
  }
}

