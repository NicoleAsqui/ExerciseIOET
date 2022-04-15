# ACME project for IOET
The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.
## Objetive
The objective of this exercise is to show the paired names of employees who have coincided in their work hours and the frequency with which they have done so.

## Description 
The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame

The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.
Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our examples below:

### Example 1:

**INPUT**
```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```
**OUTPUT**
```
ASTRID-RENE: 2
ASTRID-ANDRES: 3
RENE-ANDRES: 2
```
### Example 2:

**INPUT**
```
RENE=MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```

**OUTPUT**
```
RENE-ASTRID: 3
```

## Architecture

The architecture used in this project is the object-oriented architecture is based on the structure and behavior of a software application is represented through the use of multiple interoperable objects. Where the objects encapsulate the different properties and tasks in an optimized and organized way, and connect, communicate and collaborate through well-defined interfaces.

Also by separating the classes and packages we can get a more simplified way of understanding the code as MVC by separating the Employee and Schedule models, the Intersection interface and the program logic in the controller.

### UML Diagram
![uml](https://user-images.githubusercontent.com/56647127/163497233-36610bd0-f345-4d88-be1e-f6d64a332a23.png)

## Methodology

For this project I used waterfall methodology which is a traditional approach to project management where tasks and phases are completed in a linear and sequential manner, and each stage of the project must be completed before the next begins.

The stages are shown below:

Requirements: It is based on the compilation of the information of the exercise on the entrances and exits that they wish to execute.

Analysis: At this stage, the language used (java) was established.

Design: In this stage, the entity-relationship diagram and UML to be implemented were made.

Construction: The code was implemented in small parts with an integration at the end.

Testing: Unit tests were performed with JUnit on the coincidence of schedules


