# Riot-dev-api-kotlin
Riot development API written in Kotlin.

## Overview
The first step to creating a LOL-related application.

Incomplete, under development.

## Class diagram
#### Global variable
Manage global variables. It is used as parameter of Connection object such as country, URL, API information.
![ex_screenshot](/res/global.png)
#### Connection module
Connection objects are managed by the Factory pattern. It also retrieves API information through the Connection object.
![ex_screenshot](/res/connection.png)
#### Unit test module
Conduct unit tests on Connection objects. Objects developed so far have been tested.
<img src="/res/unittest.png" width="300" height="300">![ex_screenshot](/res/unittest.png)</img>

## Library
Please import the library.
1. __[[gson]](https://github.com/google/gson)__ is required.
2. __[[junit4]](https://github.com/junit-team/junit4)__ is required.

## Reference
1. https://developer.riotgames.com/api-methods/
