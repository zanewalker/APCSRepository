# Project 1: Birthday Card

* Author: Zane Walker
* Class: AP Computer Science
* Semester: Fall 2017

## Overview

This Java application displays an animated birthday card for my sister that has 3 lit candles, a message, 2 balloons, and a decorated cake on a platform.

## Compiling and Using

To compile, execute the following command in the main project directory:
```
javac BirthdayCard.java
```

Run the compiled class with the command:
```
java BirthdayCard
```

## Discussion

When I realized my paintComponent() method was getting really long and hard to
read, I broke out each graphical element into its own private method.  The hard
part of that was figuring out that I needed to pass in the Graphics object to
each method, but it worked well after I did that. It also helped to read about
the Graphics class in the oracle Java helper, to learn how to use the different 
draw methods and shapes more in detail to get more accurate images being able 
to know what each component does.

I tested for nearly a whole week on a separate project to mess with scale, 
shapes, and deminsions so that I knew what to put in my actual project. This 
helped a lot because now I can undertand and do a lot more than I could have if 
I had worked soely on finishing the project.

I tried running the program everytime I made any changes to see exactly what 
each component did so that I could more easily manipulate the code yet to be 
written. 

The starting file for the project had a window size of 400 x 600, but I found
that the project had to be able to scale with the window. This took me nearly 
2 weeks testing and researching ways to scale some more dificult shapes such as 
arcs or ovals since they didn't line up with values as easily as rectangles or 
polygons did. After presentations started, Dillon went and he had figured out 
how to scale the whole file. I asked him for help on that and now the arcs and 
everything scale together and fluidly.

This project was challenging at first, but it was fun once I got the hang of
it and I feel like I learned a lot about graphics in Java. It did take much 
longer than I had expected, yet i was able to learn more that way.

## Sources used

- I used the website "oracle" to find more in depth codes for shapes and the variables that control them.
- I also used Dillon's assistance in using scale.
