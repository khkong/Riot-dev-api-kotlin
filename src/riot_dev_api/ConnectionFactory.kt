package riot_dev_api

import riot_dev_api.champion_mastery_v3.ChampionMasteryConnection
import riot_dev_api.champion_v3.ChampionConnection
import riot_dev_api.summoner_v3.SummonerConnection

open class ConnectionFactory {

    fun getConnection(state : Int, localeHost : String) : Connection?{
        if(GlobalState.SUMMONER_V3 == state){
//            println("SUMMONER_V3 CONNECTION RETURN")
            return SummonerConnection(localeHost)
        }
        if (GlobalState.CHAMPION_MASTERY_V3 == state) {
//            println("CHAMPION_MASTERY_V3 CONNECTION RETURN")
            return ChampionMasteryConnection(localeHost)
        }
        if (GlobalState.CHAMPION_V3 == state) {
//            println("CHAMPION_V3 CONNECTION RETURN")
            return ChampionConnection(localeHost)
        }
        return null
    }

}