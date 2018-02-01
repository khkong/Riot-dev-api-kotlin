package riot_dev_api

import riot_dev_api.summoner_v3.SummonerConnection

open class ConnectionFactory {

    fun getConnection(state : Int) : Connection?{
        if(ConnectionState.SUMMONER_V3 == state){
            println("SUMMONER_V3 CONNECTION RETURN")
            return SummonerConnection()
        }
        return null
    }

}