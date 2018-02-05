package riot_dev_api.connection

import com.google.gson.JsonParser
import riot_dev_api.Global
import riot_dev_api.dto.luague_v3.LeagueItemDTO
import riot_dev_api.dto.luague_v3.LeagueListDTO
import riot_dev_api.dto.luague_v3.LeaguePositionDTO
import riot_dev_api.dto.luague_v3.MiniSeriesDTO

class LeagueConnection : Connection {
    private val HOST: String
    private val URL_CHALLENGER_LEAGUES_BY_QUEUE: String
    private val URL_LEAGUE_BY_LEAGUE_ID: String
    private val URL_MASTER_LEAGUES_BY_QUEUE: String
    private val URL_POSITION_BY_SUMMONER: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_CHALLENGER_LEAGUES_BY_QUEUE = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "challengerleagues/by-queue/"
        this.URL_LEAGUE_BY_LEAGUE_ID = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "leagues/"
        this.URL_MASTER_LEAGUES_BY_QUEUE = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "masterleagues/by-queue/"
        this.URL_POSITION_BY_SUMMONER = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "positions/by-summoner/"
        this.PARAM_API_KEY = "?api_key="
    }

    public fun getChallengerLeaguesByQueue(queue: String, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_CHALLENGER_LEAGUES_BY_QUEUE + queue + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
            try {
                var parser = JsonParser()
                var element = parser.parse(responde)
                leaqueList.tier = element.asJsonObject["tier"].asString
                leaqueList.queue = element.asJsonObject["queue"].asString
                leaqueList.leagueId = element.asJsonObject["leagueId"].asString
                leaqueList.name = element.asJsonObject["name"].asString
                var arrObject = element.asJsonObject["entries"]
                var arr = arrObject.asJsonArray
                for (item in arr) {
                    var league = LeagueItemDTO()
                    league.hotStreak = item.asJsonObject["hotStreak"].asBoolean
                    league.wins = item.asJsonObject["wins"].asInt
                    league.veteran = item.asJsonObject["veteran"].asBoolean
                    league.losses = item.asJsonObject["losses"].asInt
                    league.rank = item.asJsonObject["rank"].asString
                    league.playerOrTeamName = item.asJsonObject["playerOrTeamName"].asString
                    league.inactive = item.asJsonObject["inactive"].asBoolean
                    league.playerOrTeamId = item.asJsonObject["playerOrTeamId"].asString
                    league.freshBlood = item.asJsonObject["freshBlood"].asBoolean
                    league.leaguePoints = item.asJsonObject["leaguePoints"].asInt
                    leaqueList.entries!!.add(league)
                }
            } catch (e: Exception) {

            }
        }
        return leaqueList
    }

    public fun getLeaguesByLeagueID(leagueID: String, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_LEAGUE_BY_LEAGUE_ID + leagueID + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
            try {
                var parser = JsonParser()
                var element = parser.parse(responde)
                leaqueList.tier = element.asJsonObject["tier"].asString
                leaqueList.queue = element.asJsonObject["queue"].asString
                leaqueList.leagueId = element.asJsonObject["leagueId"].asString
                leaqueList.name = element.asJsonObject["name"].asString
                var arrObject = element.asJsonObject["entries"]
                var arr = arrObject.asJsonArray
                for (item in arr) {
                    var league = LeagueItemDTO()
                    league.hotStreak = item.asJsonObject["hotStreak"].asBoolean
                    league.wins = item.asJsonObject["wins"].asInt
                    league.veteran = item.asJsonObject["veteran"].asBoolean
                    league.losses = item.asJsonObject["losses"].asInt
                    league.rank = item.asJsonObject["rank"].asString
                    league.playerOrTeamName = item.asJsonObject["playerOrTeamName"].asString
                    league.inactive = item.asJsonObject["inactive"].asBoolean
                    league.playerOrTeamId = item.asJsonObject["playerOrTeamId"].asString
                    league.freshBlood = item.asJsonObject["freshBlood"].asBoolean
                    league.leaguePoints = item.asJsonObject["leaguePoints"].asInt
                    leaqueList.entries!!.add(league)
                }
            } catch (e: Exception) {

            }
        }
        return leaqueList
    }

    public fun getMasterLeaguesByQueue(queue: String, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_MASTER_LEAGUES_BY_QUEUE + queue + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
            try {
                var parser = JsonParser()
                var element = parser.parse(responde)
                leaqueList.tier = element.asJsonObject["tier"].asString
                leaqueList.queue = element.asJsonObject["queue"].asString
                leaqueList.leagueId = element.asJsonObject["leagueId"].asString
                leaqueList.name = element.asJsonObject["name"].asString
                var arrObject = element.asJsonObject["entries"]
                var arr = arrObject.asJsonArray
                for (item in arr) {
                    var league = LeagueItemDTO()
                    league.hotStreak = item.asJsonObject["hotStreak"].asBoolean
                    league.wins = item.asJsonObject["wins"].asInt
                    league.veteran = item.asJsonObject["veteran"].asBoolean
                    league.losses = item.asJsonObject["losses"].asInt
                    league.rank = item.asJsonObject["rank"].asString
                    league.playerOrTeamName = item.asJsonObject["playerOrTeamName"].asString
                    league.inactive = item.asJsonObject["inactive"].asBoolean
                    league.playerOrTeamId = item.asJsonObject["playerOrTeamId"].asString
                    league.freshBlood = item.asJsonObject["freshBlood"].asBoolean
                    league.leaguePoints = item.asJsonObject["leaguePoints"].asInt
                    leaqueList.entries!!.add(league)
                }
            } catch (e: Exception) {

            }
        }
        return leaqueList
    }

    public fun getPositionBySummoner(summonerID: Long, apiKey: String): LeaguePositionDTO {
        var responde = connectAPI(URL_POSITION_BY_SUMMONER + summonerID + PARAM_API_KEY + apiKey, 0)
        var position = LeaguePositionDTO()
        if (responde.isNotEmpty()) {
            try {
                var parser = JsonParser()
                var element = parser.parse(responde)
                var arr = element.asJsonArray
                position.rank = arr[0].asJsonObject["rank"].asString
                position.queueType = arr[0].asJsonObject["queueType"].asString
                position.hotStreak = arr[0].asJsonObject["hotStreak"].asBoolean
                position.wins = arr[0].asJsonObject["wins"].asInt
                position.veteran = arr[0].asJsonObject["veteran"].asBoolean
                position.losses = arr[0].asJsonObject["losses"].asInt
                position.freshBlood = arr[0].asJsonObject["freshBlood"].asBoolean
                position.leagueId = arr[0].asJsonObject["leagueId"].asString
                position.playerOrTeamName = arr[0].asJsonObject["playerOrTeamName"].asString
                position.inactive = arr[0].asJsonObject["inactive"].asBoolean
                position.playerOrTeamId = arr[0].asJsonObject["playerOrTeamId"].asString
                position.tier = arr[0].asJsonObject["tier"].asString
                position.leaguePoints = arr[0].asJsonObject["leaguePoints"].asInt
                position.leagueName = arr[0].asJsonObject["leagueName"].asString

                var miniSeries = MiniSeriesDTO()
                var arrObject = arr[0].asJsonObject["miniSeries"]
                if(!arrObject.isJsonNull) {
                    miniSeries.wins = arrObject.asJsonObject["wins"].asInt
                    miniSeries.losses = arrObject.asJsonObject["losses"].asInt
                    miniSeries.target = arrObject.asJsonObject["target"].asInt
                    miniSeries.progress = arrObject.asJsonObject["progress"].asString
                    position.miniSeries = miniSeries
                }
            } catch (e: Exception) {

            }
        }
        return position
    }
}