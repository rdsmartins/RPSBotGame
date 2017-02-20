# RPS Terminal Game

This the a typical Rock / Paper / Scissors simulator

This game follow some logical principals:
  - Each time the programs runs a **Game** is started;
  - Each **Game** may have one or more **Rounds**;
  - Each **Round** have **n** matches - The user is prompted to inform the number of **n**;
  - Each Match is composed for a couple of *Players*;
  - A **Match** never ends *Tied*, what direct means that a *Match* always have a *Winner*;
  - A **Player** interact with the terminal providing number's to express the Game *Gestures* (*PAPER*, *ROCK*, *SCISSORS*) the range of number goes from 1 to 3;
  - After the first **Round** is finished - The user is prompted to inform if want to play another **Round** or not;
  - At the end of a **Round** the user provide any answer different than *y* the **Game** will be finalized and the **Game** statistics will be printed;

# How to Compile and Run
*The Project **requires** Java 1.8*
```sh
$ git clone https://github.com/rdsmartins/RPSBotGame.git
$ cd <project_folder>
$ mvn clean package
$ java -jar <project_folder>/target/RPSSimulator-0.0.1-SNAPSHOT.jar
```

