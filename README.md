# interview-patients-state-problem

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


##  About the code
### First version Based on "State" behavioral design-pattern.
State transition logic are encapsulated in dedicated State classes which favors :
- Single Responsibility Principle
- Open/Closed Principle

- But the code will become difficult to maintain and exends when a huge amount of new states will be added.

### Second version based on Rule&Rule engine pattern which resolves these limitations.



##  How to Run
mvn spring-boot:run -Dspring-boot.run.arguments="D,F"
- Please configure Lombok for your IDE, otherwise you get compiler errors.