# BABEL - ING


## ArrayLeader test

Runnable application and config file are in "bin" folder.


### Configuration
Change application.properties file to configure the tests:

*  arrayLeader.array -> define the array to be used for tests
*  arrayLeader.K -> set K value
*  arrayLeader.M -> set M value

*WARNING: There is not any kind of checking for these parameters*


For random tests for bigger arrays, change following parameters:
*  arrayLeader.array.generator.use -> set to true to use array random generator
*  arrayLeader.array.generator.maxLength -> set max length of the array (take care with logging level)

*Note: due to behavior of Radom class, the results are not significant. It is better to create specific tests.*

Other parameters:
*  logging.level* -> trace level
*  arrayLeader.groupingBy -> alternative way to calculate leaders. Less efficient, but clearer code.


### Sources

com.igarridos.babel.ing.test.TestApp -> main method

com.igarridos.babel.ing.test.arrayLeader.Solution -> Solution class


# 
# 
# 
# 
# 
# 
# 
# 
# 
# 
# 

## Quiz

What's new in Java 8? Explain some of them.

>Lambdas: For functional programming.
>
>Streams: Utilities to work with collections.
>
>Try Catch with resorurces: to manage easily exceptions manamement with input/output resources.
>
>Default implementation for methods defined in interfaces. Declare Static constants in interfaces.  
	
	
Given the following list implement a solution in order to get even numbers using Java 8 Streams

>List<Integer> list = Arrays.asList(1,2,3,4);
>
>List<Integer> evenList = list.stream.filter( l -> l%2==0).collect(Collectors.toList());


What do you notice when you do code review?
>Bugs
>
>Typos
>
>Correctness:
>
>-  Duplicated code
>
>-  Unnecessary code
>-  Possible refactoring
>
>Learn

		
Have you ever worked with Scrum? Tell us what it is, what events do you remember and
what roles are involved?

>It is not a metodology, it is a framework which provides some guidelines to implement/follow agile principles.
>
>Development process is divided in Sprints. Normally each spring should be as short as possible (one/two weeks).
>  
>For each Sprint, Team Members and Product Owner select from product backlog what tasks must be acomplished during the sprint.
>
>Every day, there is a daily meeting. This meeting must be short (less than 20 minutes) and each member explains to the rest of the team what they did, what problems found and what is their next work. Deribated discussions must be avoided during this meeting. If deeper discussions are needed, they will be arranged in different specific meetings.
>  
>At the end of the spring there must be a releasable product with the task completed. This product will be explained during specific Spring meeting.
>
>Another meeting can be arranged where each member can tell about the good/bad things happened during the meeting. 
> 
>**Scrum Master** is the person who helps to team members to stay focused on the development:
>- Guide meetings. Avoid dailys to be too long. 
>- Take care about the "external issues" the members can have and try to solve them. 



What access modifiers (or visibility) do you know in Java?
>Private -> Only accesible inside the class.
>
>Default/Package -> Accessible inside the class or package.
>
>Protected -> Accessible inside the class, package and childs.
>
>Public -> Accesible from everwhere.


Differences between an abstract class and an interface. When would you use one or the
other?
> Abstract class can define properties and methods (abstract or not) to be used from childs. Unitl Java 8, interfaces were special classes where only abstract methods can be described. From Java 8, the difference is not too big, because it is possible to specify constants and default implementation for methods in interfaces. This behavior brockes someway the multiinheritace limitation in java. 
> 	
>For me, interfaces must be used to espicify the behavior: a contract. The goal of default implementation of methods is to extend interfaces without having to modify existing clases that implements this interface.
>Abstract classes should be used to specify common behavior/meaning for different classes.
>
 



What is Maven and why is it used? What is Maven life cycle?
>Maven is a tool/framework to mange one application composition/development.
>Life cycle is compossed by different phases:
>-  Build: compile
>-  Test: Run specified tests
>-  Install: built the application, resolve dependencies and download necessary libraries to local artifactory. It generates an artifact that can be executed (war, jar...)
>-  Package: The same than build, but creates the artifact in local artifactory, so it can be used by other apps.
>-  Deploy: Deploy the application to specific run environment.
	 
What is Git and what is it used for? List all Git commands that you know.
>Git is not centralized version control. Focused on development based on branchs.
>-	Init -> Create new repository.
>-	Clone -> Get locally a repository located in different host.
>-  Pull -> Update local repository head to latest status from external repository.
>-  Push -> Update remote repository head to latest status from local repository.
>-  Checkout -> Move between branches.
>-  Commit -> Add to current branch last changes.
>-  Add -> Add to git control sisytem some resource.
>-  Revert -> Remove from current branch some commit.
>-  Branch -> Work over branches (delete...)
	

What is a mock? What would you use it for?
>In unit testing, to simulate external objects behavior.
>
>Testing unit should be focused on the behavior of each specific method in isolated way. But usually a method have iteractions with other mehods/objects. Mock objects are in charge of simulating the behavior of this methods.   

How would you explain to someone what Spring is? What can it bring to their projects?
>Spring is a framework focused on IoC and Dependecy Injection. Appart from this, it brings several modules that provide an abstraction layer for different needs: MVC, Web, JDBC, Data...


What's the difference between Spring and Spring Boot?
> Springboot is a evolution of Sping to facilitate some configuration tasks and provides some utilities like embeded servers


Do you know what CQRS is? And Event Sourcing?
>
>

Differences between IaaS and PaaS. Do you know any of each type?
>
>

Explain what a Service Mesh is? Do you have an example?
> For systems based on microservices, a service mesh is a technology in the infraestructure layer. The purpoose is to isolate each microservice from the infraestructure knowledge. Each microservice is deployed with a proxy. Each microsevice delegates any communication task to this proxy. Proxys communicate with a control tower, who knows all the infraestructure stauts: proxys/services, load, faults... 
> 
> Istio???

Explain what is TDD? What is triangulation?
> Test driven development. Development metodolgy that focuses in testing. The main idea is that before developing any business logic, the tests for this logic must be written first, and then develop the logic that is executed correclty against these tests.



Apply the Factory pattern with lambda expressions

Reduce the 3 classes (OldWayPaymentStrategy, CashPaymentStrategy and

CreditCardStrategy) into a single class (PaymentStrategy). You do not need to create any
more classes or interfaces. Also, tell me how you would use PaymentStrategy, i.e. the
different payment strategies in the Main class
public interface OldWayPaymentStrategy {
double pay(double amount);
}
public class CashPaymentStrategy implements OldWayPaymentStrategy {
@Override
public double pay(double amount) {
double serviceCharge = 5.00;
return amount + serviceCharge;
}
}
public class CreditCardStrategy implements OldWayPaymentStrategy {
@Override
public double pay(double amount) {
double serviceCharge = 5.00;
double creditCardFee = 10.00;
return amount + serviceCharge + creditCardFee;
}
}
public interface PaymentStrategy {
//write here your solution}
public class Main {
public static void main(String[] args) {
}
}

>> Review the code
