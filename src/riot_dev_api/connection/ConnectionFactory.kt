package riot_dev_api.connection

import riot_dev_api.Global

open class ConnectionFactory {

    fun getConnection(state : Int, localeHost : String) : Connection?{
        if(Global.Api.SUMMONER_V3 == state){
//            println("SUMMONER_V3 CONNECTION RETURN")
            return SummonerConnection(localeHost)
        }
        if (Global.Api.CHAMPION_MASTERY_V3 == state) {
//            println("CHAMPION_MASTERY_V3 CONNECTION RETURN")
            return ChampionMasteryConnection(localeHost)
        }
        if (Global.Api.CHAMPION_V3 == state) {
//            println("CHAMPION_V3 CONNECTION RETURN")
            return ChampionConnection(localeHost)
        }
        return null
    }

}