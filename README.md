# interview-patients-state-problem

##  Description
This sample code demonstrates how to manage transition between different states based on rules.



##  About the code
First version Based on "State" behavioral design-pattern.
State transition logic are encapsulated in dedicated State classes which favors :
- Single Responsibility Principle
- Open/Closed Principle
But the code will become difficult to maintain and exends when a huge amount of new states will be added.

Second version based on Rule&Rule engine pattern which resolves these limitations.
