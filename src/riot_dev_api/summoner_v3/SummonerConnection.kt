package riot_dev_api.summoner_v3

import com.google.gson.JsonParser
import riot_dev_api.Connection
import riot_dev_api.GlobalState
import java.net.URLEncoder

class SummonerConnection : Connection {
    private val HOST: String
    private val URL_BY_ACCOUNT: String
    private val URL_BY_NAME: String
    private val URL_NOTTHING: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_BY_ACCOUNT = "https://" + HOST + GlobalState.PATH_SUMMONER_V3 + "summoners/by-account/"
        this.URL_BY_NAME = "https://" + HOST + GlobalState.PATH_SUMMONER_V3 + "summoners/by-name/"
        this.URL_NOTTHING = "https://" + HOST + GlobalState.PATH_SUMMONER_V3 + "summoners/"
        this.PARAM_API_KEY = "?api_key="
    }

    public fun connByAccount(accountId: Long, apiKey: String): SummonerDTO {
        var responde = connectAPI(URL_BY_ACCOUNT + accountId + PARAM_API_KEY + apiKey)
        var summoner = SummonerDTO()
        if(responde.isNotEmpty()) {
            var parser = JsonParser()
            var element = parser.parse(responde)
            summoner.id = element.asJsonObject["id"].asLong
            summoner.accountId = element.asJsonObject["accountId"].asLong
            summoner.name = element.asJsonObject["name"].asString
            summoner.profileIconId = element.asJsonObject["profileIconId"].asInt
            summoner.revisionDate = element.asJsonObject["revisionDate"].asLong
            summoner.summonerLevel = element.asJsonObject["summonerLevel"].asLong
        }
        return summoner
    }

    public fun connByName(summonerName: String, apiKey: String): SummonerDTO {
        var urlUTF8 = URLEncoder.encode(summonerName, "UTF-8")
        var responde = connectAPI(URL_BY_NAME + urlUTF8 + PARAM_API_KEY + apiKey)
        var summoner = SummonerDTO()
        if(responde.isNotEmpty()){
            var parser = JsonParser()
            var element = parser.parse(responde)
            summoner = SummonerDTO()
            summoner.id = element.asJsonObject["id"].asLong
            summoner.accountId = element.asJsonObject["accountId"].asLong
            summoner.name = element.asJsonObject["name"].asString
            summoner.profileIconId = element.asJsonObject["profileIconId"].asInt
            summoner.revisionDate = element.asJsonObject["revisionDate"].asLong
            summoner.summonerLevel = element.asJsonObject["summonerLevel"].asLong
        }
        return summoner
    }

    public fun conn(summonerId: Long, apiKey: String): SummonerDTO {
        var responde = connectAPI(URL_NOTTHING + summonerId + PARAM_API_KEY + apiKey)
        var summoner = SummonerDTO()
        if(responde.isNotEmpty()) {
            var parser = JsonParser()
            var element = parser.parse(responde)
            summoner.id = element.asJsonObject["id"].asLong
            summoner.accountId = element.asJsonObject["accountId"].asLong
            summoner.name = element.asJsonObject["name"].asString
            summoner.profileIconId = element.asJsonObject["profileIconId"].asInt
            summoner.revisionDate = element.asJsonObject["revisionDate"].asLong
            summoner.summonerLevel = element.asJsonObject["summonerLevel"].asLong
        }
        return summoner
    }


}