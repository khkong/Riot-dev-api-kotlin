package riot_dev_api.connection

import com.google.gson.Gson
import riot_dev_api.Global
import riot_dev_api.dto.summoner_v3.SummonerDTO
import java.net.URLEncoder

class SummonerConnection : Connection {
    var HOST: String
    var URL_BY_ACCOUNT: String
    var URL_BY_NAME: String
    var URL_BY_ID: String
    var PARAM_API_KEY: String

    constructor(){
        this.HOST = ""
        this.URL_BY_ACCOUNT = ""
        this.URL_BY_NAME = ""
        this.URL_BY_ID = ""
        this.PARAM_API_KEY = ""
    }

    override fun setLocalHost(localHost: String) {
        this.HOST = localHost
        this.URL_BY_ACCOUNT = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/by-account/"
        this.URL_BY_NAME = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/by-name/"
        this.URL_BY_ID = "https://" + HOST + Global.ApiPath.SUMMONER_V3 + "summoners/"
        this.PARAM_API_KEY = "?api_key="
    }

    fun getSummonerByAccount(accountId: Long, apiKey: String): SummonerDTO? {
        val responde = connectAPI(URL_BY_ACCOUNT + accountId + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }

    fun getSummonerByName(summonerName: String, apiKey: String): SummonerDTO? {
        val urlUTF8 = URLEncoder.encode(summonerName.replace(" ",""), "UTF-8")
        val responde = connectAPI(URL_BY_NAME + urlUTF8 + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }

    fun getSummonerBySummonerID(summonerId: Long, apiKey: String): SummonerDTO? {
        val responde = connectAPI(URL_BY_ID + summonerId + PARAM_API_KEY + apiKey,0)
        if(responde.isNotEmpty()) {
            return Gson().fromJson(responde, SummonerDTO::class.java)
        }
        return null
    }


}