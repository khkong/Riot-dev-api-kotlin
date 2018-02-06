package riot_dev_api.connection

import riot_dev_api.Global

open class ConnectionFactory {

    companion object {
        val summonerConnection = SummonerConnection()
        val championMasteryConnection = ChampionMasteryConnection()
        val championConnection = ChampionConnection()
        val leagueConnection = LeagueConnection()
        val lolStaticDataConnection = LOLStaticDataConnection()
    }

    fun getConnection(state : Int, localeHost : String) : Connection?{
        if(Global.Api.SUMMONER_V3 == state){
//            println("SUMMONER_V3 CONNECTION RETURN")
            summonerConnection.setLocalHost(localeHost)
            return summonerConnection
        }
        if (Global.Api.CHAMPION_MASTERY_V3 == state) {
//            println("CHAMPION_MASTERY_V3 CONNECTION RETURN")
            championMasteryConnection.setLocalHost(localeHost)
            return championMasteryConnection
        }
        if (Global.Api.CHAMPION_V3 == state) {
//            println("CHAMPION_V3 CONNECTION RETURN")
            championConnection.setLocalHost(localeHost)
            return championConnection
        }
        if (Global.Api.LEAGUE_V3 == state) {
//            println("CHAMPION_V3 CONNECTION RETURN")
            leagueConnection.setLocalHost(localeHost)
            return leagueConnection
        }
        if (Global.Api.LOL_STATIC_DATA_V3 == state) {
//            println("CHAMPION_V3 CONNECTION RETURN")
            lolStaticDataConnection.setLocalHost(localeHost)
            return lolStaticDataConnection
        }

        return null
    }

}