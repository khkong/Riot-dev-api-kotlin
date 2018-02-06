package riot_dev_api.connection

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import riot_dev_api.Global
import riot_dev_api.dto.champion_mastery_v3.ChampionMasteryDTO
import riot_dev_api.dto.champion_v3.ChampionListDto

class ChampionMasteryConnection : Connection {
    private val HOST: String
    private val URL_BY_SUMMONER_ID: String
    private val URL_BY_CHAMPION_ID: String
    private val URL_TOTAL_MASTERY_SCORE: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_BY_SUMMONER_ID = "https://" + HOST + Global.ApiPath.CHAMPION_MASTERY_V3 + "champion-masteries/by-summoner/"
        this.URL_BY_CHAMPION_ID = "https://" + HOST + Global.ApiPath.CHAMPION_MASTERY_V3 + "champion-masteries/by-summoner/"
        this.URL_TOTAL_MASTERY_SCORE = "https://" + HOST + Global.ApiPath.CHAMPION_MASTERY_V3 + "scores/by-summoner/"
        this.PARAM_API_KEY = "?api_key="
    }

    /**
     * Get all champion mastery entries sorted by number of champion points descending,
     */
    public fun getChampMasteryList(summonerId: Long, apiKey: String): List<ChampionMasteryDTO>? {
        val responde = connectAPI(URL_BY_SUMMONER_ID + summonerId + PARAM_API_KEY + apiKey,0)
        if (responde.isNotEmpty()) {
            val turnsType = object : TypeToken<List<ChampionMasteryDTO>>() {}.type
            return Gson().fromJson<List<ChampionMasteryDTO>>(responde, turnsType)
        }
        return null
    }

    /**
     * Get a champion mastery by player ID and champion ID.
     */
    public fun getChampMastery(summonerId: Long, championId: Long, apiKey: String): ChampionMasteryDTO? {
        val responde = connectAPI(URL_BY_CHAMPION_ID + summonerId + "/by-champion/" + championId + PARAM_API_KEY + apiKey,0)
        if (responde.isNotEmpty()) {
            return Gson().fromJson(responde, ChampionMasteryDTO::class.java)
        }
        return null
    }

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
     */
    public fun getTotalMasteryScore(summonerId: Long, apiKey: String): Int {
        val responde = connectAPI(URL_TOTAL_MASTERY_SCORE + summonerId + PARAM_API_KEY + apiKey,0)
        if (responde.isNotEmpty()) {
            return Gson().fromJson(responde, Int::class.java)
        }
        return -1
    }

}