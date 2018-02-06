package riot_dev_api.connection

import com.google.gson.JsonParser
import riot_dev_api.Global
import riot_dev_api.dto.summoner_v3.SummonerDTO
import java.net.URLEncoder
import com.google.gson.Gson



class SummonerConnection : Connection {
    private val HOST: String
    private val URL_BY_ACCOUNT: String
    private val URL_BY_NAME: String
    private val URL_BY_ID: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_BY_ACCOUNT = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/by-account/"
        this.URL_BY_NAME = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/by-name/"
        this.URL_BY_ID = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/"
        this.PARAM_API_KEY = "?api_key="
    }

    public fun getSummonerByAccount(accountId: Long, apiKey: String): SummonerDTO? {
        val responde = connectAPI(URL_BY_ACCOUNT + accountId + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }

    public fun getSummonerByName(summonerName: String, apiKey: String): SummonerDTO? {
        val urlUTF8 = URLEncoder.encode(summonerName.replace(" ",""), "UTF-8")
        val responde = connectAPI(URL_BY_NAME + urlUTF8 + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }

    public fun getSummonerBySummonerID(summonerId: Long, apiKey: String): SummonerDTO? {
        val responde = connectAPI(URL_BY_ID + summonerId + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }


}