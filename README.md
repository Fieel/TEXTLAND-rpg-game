# TEXTLAND-rpg-game
@uthor Filipe Madureira

***************************INTRODUCTION*********************************
As a complete beginner i tried to create a simple-randomized textual RPG game.

This game is meant to be streamed using a terminal window and the player has to insert commands with the keyboard to play.
Everything is randomized and the only way the player has to impact in the outcome is by having different choices when prompted to.
Often you can decide to take a risk or just turn back and look for another way to continue your trip, so good luck.

*****************************INSTRUCTIONS*******************************
There are 5 different stats: HP, stamina, food, water, and (mental) sanity.
If one of these stats reaches 0 you'll lose the game.


There is a map and there are 10 different biomes: Village, forest, river, cave, castle, plains, mountain, swamp, crypta and countryside.

Every different biome stores 5 different cases, so if you end up two times in a village this won't mean that the same scene will pop up

***************************GAME-STRUCTURE********************************
The game uses 6 classes: Character.java stores everything about the player's character, stats, map position and stat increase-reduce methods.

Game.java stores the main game cycle. See comments for more infos.

Main.java stores the menus, like the opening screen or the game-over screens.

Map.java stores data regarding the map (or game world), which is a simple 10x10 array.

Variables.java stores general variables.
