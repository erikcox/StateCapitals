# State Capitals

**State Capitals** is an Android quiz game for U.S. state capitals.

## User Stories

The following functionality is completed:

* [x] Save the names of all 50 U.S. states in an array or arraylist.
* [x] Use a remote service to save the states and capitals using AIDL.
* [x] Use a client to send a regular expression to your service to give a listing of all matching states. `Ex) "^C" means any state that begins with capital C.`
* [x] Create a sqlite table US_States with 3 fields: int id autoincrement, text state, text capital. No fields should be null (don't allow null in the field creation process).
* [x] This program has 3 intents (each intent has it's own screen, java program, and xml file). Splash screen, game, and show scores.
* [x] Load data into db. Create hash map. Key as state, Value as capital.
* [x] Ask user for their name (name will be compared on high scores later).
* [x] Add welcome text: "Welcome to the state game"
* [x] Hit start button: Please enter your name: <hit enter and game starts>
* [x] Add a scores button at the bottom that skips the game and goes to the scores intent
* [x] Randomly show 5 states & ask the user to type in their capitals.
* [x] Query the db to check if answer is right
* [x] Randomly show 5 capitals & ask the user to type in their corresponding states
* [x] Scoring: 1 point for correct, 0 points for incorrect. 10 questions total, highest score is 10.
* [x] Retrieve the High score list (Top 10)
* [x] Have a quit button, restart button, and a way to get back to the main screen

## Notes

Took small steps to build this piece by piece.

Used FileInputStream to iterate over text file to load into SQLite db.

## License

    Copyright 2014 Erik Cox

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
