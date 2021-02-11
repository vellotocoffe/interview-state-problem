# interview-state-problem



## Assumptions
Different states could co-exist, but there is no specific requirement at this point. 
So i consider that a patient only has one state at a given time.

The algorithm is based on state severity, the checking starts from most "grave" states.

Dead -> Diabetes -> Tuberculosis -> Fever -> Healthy

There are three possible state transition : 
1)A patient can move to a more grave state.
2)A patient can still be in same state.
3)A patient can move to a less grave state if current state can be curved firstly.

For example, a diabetes patient receives I and An, as diabetes is more sever
than Fever, so he will still be in diabetes state. 
other example, a Tuberculosis received An,As,I, he can be curved by An, but due to I, he will be fever finally.



##  Build
use mvn clean install for buidling the jar file.

##  Execution
java -jar .\evooqInterview-0.0.1-SNAPSHOT.jar H P,An,I

##  About the code
Based on "State" behavioral design-pattern.
State transition logic are encapsulated in dedicated State classes which favors :
- Single Responsibility Principle
- Open/Closed Principle

So the code will be easily extensible and maintainable.
