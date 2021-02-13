# An inverview coding problem "Patient state simulation"

## About
I hidden the problem description details but just provide an overall description.
Please not that the code here is just for showing a possible implementation of Rule Engine design patter.


##  Problem description

You were asked by a doctor friend to prepare for her a “Hospital simulator”, which can
simulate the future patients’ state, based on their current state and a list of drugs they take.

Drugs effects are described by the following rules:
- Aspirin cures Fever;
- Antibiotic cures Tuberculosis;
- Insulin prevents diabetic subject from dying, does not cure Diabetes;
- If insulin is mixed with antibiotic, healthy people catch Fever;
- Paracetamol cures Fever;
......

Note that new drugs and new states can be added in the future, as well as the new rules.
So it's important to provide extensible codes.

##  About the code
### First version Based on "State" behavioral design-pattern.
At the beginning, i was thinking about using state pattern, because it's quite similar to "Post office package tracking problem".
The reasons are :
State transition logic are encapsulated in dedicated State classes which favors :
- Single Responsibility Principle
- Open/Closed Principle

- But the code will become difficult to maintain and exends when a huge amount of new states will be added.

### Second version based on Rule & Rule Engine pattern which resolves these limitations.
The advantages are
- Better "S" principle application
- Rules can be reused and be combined



##  How to Run
mvn spring-boot:run -Dspring-boot.run.arguments="D,F"
- Please configure Lombok for your IDE, otherwise you get compiler errors.
