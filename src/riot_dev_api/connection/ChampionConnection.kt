package riot_dev_api.connection

import com.google.gson.JsonParser
import riot_dev_api.Global
import riot_dev_api.dto.champion_v3.ChampionDTO
import riot_dev_api.dto.champion_v3.ChampionListDTO

/**
 * Requests to this API are not counted against the application Rate Limits.
 */
class ChampionConnection : Connection {
    private val HOST: String
    private val URL_CHAMPIONS: String
    private val URL_BY_CHAMP_ID: String
    private val PARAM_FREE_TO_PLAY: String
    private val PARAM_API_KEY1: String
    private val PARAM_API_KEY2: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_CHAMPIONS = "https://" + HOST + Global.ApiPath.CHAMPION_V3 + "champions"
        this.URL_BY_CHAMP_ID = "https://" + HOST + Global.ApiPath.CHAMPION_V3 + "champions/"
        this.PARAM_API_KEY1 = "?api_key="
        this.PARAM_API_KEY2 = "&api_key="
        this.PARAM_FREE_TO_PLAY = "?freeToPlay="
    }

    /**
     * get champion list.
     * @param freeToflay Optional filter param to retrieve only free to play champions.
     */
    public fun getChampionList(freeToflay: Boolean, apiKey: String): ChampionListDTO {
        var responde = connectAPI(URL_CHAMPIONS + PARAM_FREE_TO_PLAY + freeToflay + PARAM_API_KEY2 + apiKey,0 )
        var champList = ChampionListDTO()
        if (responde.isNotEmpty()) {
            var parser = JsonParser()
            var element = parser.parse(responde)
            var arrObject = element.asJsonObject["champions"]
            var arr = arrObject.asJsonArray
            for (item in arr) {
                var champion = ChampionDTO()
                champion.rankedPlayEnabled = item.asJsonObject["rankedPlayEnabled"].asBoolean
                champion.botEnabled = item.asJsonObject["botEnabled"].asBoolean
                champion.botMmEnabled = item.asJsonObject["botMmEnabled"].asBoolean
                champion.active = item.asJsonObject["active"].asBoolean
                champion.freeToPlay = item.asJsonObject["freeToPlay"].asBoolean
                champion.id = item.asJsonObject["id"].asLong
                champList.champions!!.add(champion)
            }
        }
        return champList
    }

    /**
     * Get one champion by champion ID.
     */
    public fun getChampionByChampionID(championId: Long, apiKey: String): ChampionDTO {
        var responde = connectAPI(URL_BY_CHAMP_ID + championId + PARAM_API_KEY1 + apiKey, 0)
        var champion = ChampionDTO()
        if (responde.isNotEmpty()) {
            var parser = JsonParser()
            var element = parser.parse(responde)
            champion.rankedPlayEnabled = element.asJsonObject["rankedPlayEnabled"].asBoolean
            champion.botEnabled = element.asJsonObject["botEnabled"].asBoolean
            champion.botMmEnabled = element.asJsonObject["botMmEnabled"].asBoolean
            champion.active = element.asJsonObject["active"].asBoolean
            champion.freeToPlay = element.asJsonObject["freeToPlay"].asBoolean
            champion.id = element.asJsonObject["id"].asLong
        }
        return champion
    }


}