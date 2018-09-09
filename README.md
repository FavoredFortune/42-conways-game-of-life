#Canvas Manipulation Lab
Conway's Game of Life

#Overview
Create a game application that combines traditional Java programming with Android capabilities, especially Canvas and draw, to build a game.
Game is modeled after a famous algorithm called ["Conway's Game of Life"](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

#User Story
As a user I want to be able to click on a blank white canvas as many times as I like to turn squares black (or white again) to set up a "population".
Then I want to be able to hit a "tick" button that simulates a journey of each black cell towards a stable population. 

###Stretch Goal
As a user, each time I play the game, I would also like to know:
 - [ ] How many squares I turn black 
 
 - [x] How many times I have to "tick" to get a stable population._Achieved_

#Technology

- Android Studio
- Java
- Java util imports
- Gradle
- ButterKnife Import

#Resources

- Class lecture
- Android Developer Guide
- Wikipedia (https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
- https://dzone.com/articles/recreate-the-conways-game-of-life-on-android

#Credits

- Class lecture
- Dzone (see link above)
- Classmates Timothy GB Busch, Amy Cohen 

#Screenshots
[Start of game - pre -tick](screenshots/showconwaygameboard_start.png)
[Display of tick count, show of grid/game change](screenshots/showtickcount_intial.png)
[Display of onTouch location with row/column address](screenshots/ticks_showtouchgridlocation.png)