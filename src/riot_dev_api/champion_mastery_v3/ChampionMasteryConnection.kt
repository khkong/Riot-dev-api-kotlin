package riot_dev_api.champion_mastery_v3

import com.google.gson.JsonParser
import riot_dev_api.Connection
import riot_dev_api.GlobalState

class ChampionMasteryConnection : Connection {
    private val HOST: String
    private val URL_BY_SUMMONER_ID: String
    private val URL_BY_CHAMPION_ID: String
    private val URL_NOTTHING: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_BY_SUMMONER_ID = "https://" + HOST + GlobalState.PATH_CHAMPION_MASTERY_V3 + "champion-masteries/by-summoner/"
        this.URL_BY_CHAMPION_ID = "https://" + HOST + GlobalState.PATH_CHAMPION_MASTERY_V3 + "champion-masteries/by-summoner/"
        this.URL_NOTTHING = "https://" + HOST + GlobalState.PATH_CHAMPION_MASTERY_V3 + "champion-masteries/"
        this.PARAM_API_KEY = "?api_key="
    }

    /**
     * Get all champion mastery entries sorted by number of champion points descending,
     */
    public fun connBySummonerID(summonerId: Long, apiKey: String): List<ChampionMasteryDTO> {
        var responde = connectAPI(URL_BY_SUMMONER_ID + summonerId + PARAM_API_KEY + apiKey)
        var parser = JsonParser()
        var element = parser.parse(responde)
        var arr = element.asJsonArray

        var list = arrayListOf<ChampionMasteryDTO>()
        for (item in arr) {
            var champMastery = ChampionMasteryDTO()
            champMastery.chestGranted = item.asJsonObject["chestGranted"].asBoolean
            champMastery.championLevel = item.asJsonObject["championLevel"].asInt
            champMastery.championPoints = item.asJsonObject["championPoints"].asInt
            champMastery.championId = item.asJsonObject["championId"].asLong
            champMastery.playerId = item.asJsonObject["playerId"].asLong
            champMastery.championPointsUntilNextLevel = item.asJsonObject["championPointsUntilNextLevel"].asLong
            champMastery.tokensEarned = item.asJsonObject["tokensEarned"].asInt
            champMastery.championPointsSinceLastLevel = item.asJsonObject["championPointsSinceLastLevel"].asLong
            champMastery.lastPlayTime = item.asJsonObject["lastPlayTime"].asLong
            list.add(champMastery)
        }
        return list
    }

    /**
     * Get a champion mastery by player ID and champion ID.
     */
    public fun connByChampionID(summonerId: Long, championId: Long, apiKey: String): ChampionMasteryDTO {
        var responde = connectAPI(URL_BY_CHAMPION_ID + summonerId + "/by-champion/" + championId + PARAM_API_KEY + apiKey)
        var parser = JsonParser()
        var element = parser.parse(responde)

        var champMastery = ChampionMasteryDTO()
        champMastery.chestGranted = element.asJsonObject["chestGranted"].asBoolean
        champMastery.championLevel = element.asJsonObject["championLevel"].asInt
        champMastery.championPoints = element.asJsonObject["championPoints"].asInt
        champMastery.championId = element.asJsonObject["championId"].asLong
        champMastery.playerId = element.asJsonObject["playerId"].asLong
        champMastery.championPointsUntilNextLevel = element.asJsonObject["championPointsUntilNextLevel"].asLong
        champMastery.tokensEarned = element.asJsonObject["tokensEarned"].asInt
        champMastery.championPointsSinceLastLevel = element.asJsonObject["championPointsSinceLastLevel"].asLong
        champMastery.lastPlayTime = element.asJsonObject["lastPlayTime"].asLong
        return champMastery
    }

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
     */
    public fun conn(summonerId: Long, apiKey: String): Int {
        var responde = connectAPI(URL_NOTTHING + summonerId + PARAM_API_KEY + apiKey)
        return Integer.parseInt(responde)
    }

}