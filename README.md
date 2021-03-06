# RPS Terminal Game

This the a typical Rock / Paper / Scissors simulator

This game follows some logical principals:
  - Each time the programs runs a **Game** is started;
  - Each **Game** may have one or more **Matches**;
  - Each **Match** has **n** rounds - The user is prompted to inform the number of **Rounds** want to play in a **Match**;
  - Each *Match* is composed for a couple of *Players*;
  - A **Round** never ends *Tied*, which direct means that a *Round* always has a *Winner*;
  - A **Player** interacts with the terminal providing number's to express the Game *Gestures* (*PAPER*, *ROCK*, *SCISSORS*) the range of number goes from 1 to 3;
  - After the first **Match** is finished - The user is prompted to inform if want to play another **Match** or not;
  - At the end of a **Match** the user provide any answer different than *y* the **Game** will be finalized and the **Game** statistics will be printed;

# How to Compile and Run
*The Project **requires** Java 1.8* and Apache Maven 3.x or above
```sh
$ git clone https://github.com/rdsmartins/RPSBotGame.git
$ cd <project_folder>
$ mvn clean package
$ java -jar <project_folder>/target/RPSSimulator-0.0.1-SNAPSHOT.jar
```
# Run with Docker

```sh
$ docker push rsmartins/rpsgame:latest
$ docker run -it rsmartins/rpsgame:latest
```
