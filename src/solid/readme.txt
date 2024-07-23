SOLID principles


1) S -> Single responsibility principle
Single responsibilty principle states that one class should have only one responsibility . Or we can say one class,module, package should cater to only one stake holder/actor.
For Example : There are two classes MenuItem and Bill class. Bill class can have a list of menuItems and  three functions -> printBill(), storeBill(), calculateAmount() .
As long as the classes are easy to change and the changes do not break other functionality.
https://www.youtube.com/watch?v=-T0H--a8WnY


2) O -> Open-closed Principle (OCP)
Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself.

3) L -> Liskov Substitution Principle
Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.
This means that every subclass or derived class should be substitutable for their base or parent class.


4) I -> Interface segrigation principle
A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

5)Dependency inversion principle
Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.

This principle allows for decoupling.

https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design