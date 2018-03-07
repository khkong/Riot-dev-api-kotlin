# riot-dev-api-kotlin
Riot development API written in Kotlin.

## Overview
The first step to creating a LOL-related application.

Support for asynchronous processing using "retrofit".

Not all APIs are supported yet.

## Example
The following shows how to use it.

#### General connection 
```
               //example
               println("example HttpsURLConnection")
               var connFactory = ConnectionFactory()
               var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
               connObject as SummonerConnection
               println(connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY))
```
#### Asynchronous connection

```
               //example using retrofit
               println("example using retrofit")
               val service = SummonerService.Async(Global.Locale.KR)
               var call = service.getService().getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)
               call.enqueue(object : Callback<SummonerDTO> {
                   override fun onResponse(paramColl: Call<SummonerDTO>?, response: Response<SummonerDTO>?) {
                       println(response!!.body())
                   }
                   override fun onFailure(paramColl: Call<SummonerDTO>?, t: Throwable?) {
                   }
               })
```

## Class diagram
#### Global variable
Manage global variables. It is used as parameter of Connection object such as LOCALE, URL, API information.

<img src="/res/global.png" width="500"></img>

#### Connection module
Connection objects are managed by the Factory pattern. It also retrieves API information through the Connection object.

<img src="/res/connection.png" width="500"></img>

#### Unit test module
Conduct unit tests on Connection objects. Objects developed so far have been tested.

<img src="/res/unittest.png" width="400"></img>

## Library
Please import the library.
1. __[[gson]](https://github.com/google/gson)__ 2.8.2.ver
2. __[[junit4]](https://github.com/junit-team/junit4)__ 4.10.ver
3. __[[retrofit2]](https://github.com/square/retrofit)__ 2.3.0.ver
4. __[[okhttp]](https://github.com/square/okhttp)__ 3.9.1.ver
5. __[[okio]](https://github.com/square/okio)__ 1.13.0.ver
6. __[[converter-gson]](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)__ 2.3.0.ver

## Reference
1. https://developer.riotgames.com/api-methods/
2. http://square.github.io/retrofit/
