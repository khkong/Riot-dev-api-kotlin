package riot_dev_api.connection

import com.google.gson.JsonParser
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
        this.URL_CHALLENGER_LEAGUES_BY_QUEUE = "https://" + HOST + "challengerleagues/by-queue/"
        this.URL_LEAGUE_BY_LEAGUE_ID = "https://" + HOST + "leagues/"
        this.URL_MASTER_LEAGUES_BY_QUEUE = "https://" + HOST + "masterleagues/by-queue/"
        this.URL_POSITION_BY_SUMMONER = "https://" + HOST + "by-summoner/"
        this.PARAM_API_KEY = "?api_key="
    }

    public fun getChallengerLeaguesByQueue(queue: String, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_CHALLENGER_LEAGUES_BY_QUEUE + queue + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
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
        }
        return leaqueList
    }

    public fun getLeaguesByLeagueID(leagueID: Int, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_LEAGUE_BY_LEAGUE_ID + leagueID + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
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
        }
        return leaqueList
    }

    public fun getMasterLeaguesByQueue(queue: String, apiKey: String): LeagueListDTO {
        var responde = connectAPI(URL_MASTER_LEAGUES_BY_QUEUE + queue + PARAM_API_KEY + apiKey, 0)
        var leaqueList = LeagueListDTO()
        if (responde.isNotEmpty()) {
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
        }
        return leaqueList
    }

    public fun getPositionBySummoner(summonerID: Int, apiKey: String): LeaguePositionDTO {
        var responde = connectAPI(URL_POSITION_BY_SUMMONER + summonerID + PARAM_API_KEY + apiKey, 0)
        var position = LeaguePositionDTO()
        if (responde.isNotEmpty()) {
            var parser = JsonParser()
            var element = parser.parse(responde)
            position.rank = element.asJsonObject["rank"].asString
            position.queueType = element.asJsonObject["queueType"].asString
            position.hotStreak = element.asJsonObject["hotStreak"].asBoolean
            position.wins = element.asJsonObject["wins"].asInt
            position.veteran = element.asJsonObject["veteran"].asBoolean
            position.losses = element.asJsonObject["losses"].asInt
            position.freshBlood = element.asJsonObject["freshBlood"].asBoolean
            position.leagueId = element.asJsonObject["leagueId"].asString
            position.playerOrTeamName = element.asJsonObject["playerOrTeamName"].asString
            position.inactive = element.asJsonObject["inactive"].asBoolean
            position.playerOrTeamId = element.asJsonObject["playerOrTeamId"].asString
            position.tier = element.asJsonObject["tier"].asString
            position.leaguePoints = element.asJsonObject["leaguePoints"].asInt

            var miniSeries = MiniSeriesDTO()
            var arrObject = element.asJsonObject["miniSeries"]
            miniSeries.wins = arrObject.asJsonObject["wins"].asInt
            miniSeries.losses = arrObject.asJsonObject["losses"].asInt
            miniSeries.target = arrObject.asJsonObject["target"].asInt
            miniSeries.progress = arrObject.asJsonObject["progress"].asString
            position.miniSeries = miniSeries
        }
        return position
    }
}