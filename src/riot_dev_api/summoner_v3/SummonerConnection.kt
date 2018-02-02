package riot_dev_api.summoner_v3

import com.google.gson.JsonParser
import riot_dev_api.Connection
import riot_dev_api.GlobalState
import riot_dev_api.Data
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.net.URLEncoder
import javax.net.ssl.HttpsURLConnection

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

    public fun getSummonersByAccount(accountId: String, apiKey: String): SummonerDTO {
        var data = connectAPI(URL_BY_ACCOUNT + accountId + PARAM_API_KEY + apiKey)
        data = data as SummonerDTO
        return data
    }

    public fun getSummonersByName(summonerName: String, apiKey: String): SummonerDTO {
        var name = URLEncoder.encode(summonerName, "UTF-8")
        var data = connectAPI(URL_BY_NAME + name + PARAM_API_KEY + apiKey)
        data = data as SummonerDTO
        return data
    }

    public fun getSummoners(summonerId: String, apiKey: String): SummonerDTO {
        var data = connectAPI(URL_NOTTHING + summonerId + PARAM_API_KEY + apiKey)
        data = data as SummonerDTO
        return data
    }

    override fun connectAPI(api: String): Data {
        var summoner = SummonerDTO()
        var stream: InputStream? = null
        var streamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null

        try {

            var url = URL(api)
            var conn = url.openConnection()
            conn as HttpsURLConnection
            if (respondeCode(conn.responseCode)) { // 200?
                //Connect to host
                conn.connect()
                stream = conn.getInputStream()
                streamReader = InputStreamReader(stream)
                bufferedReader = BufferedReader(streamReader)
                var sb = StringBuilder()
                var list = bufferedReader.readLines();
                for (s in list)
                    sb.append(s)
                var json = sb.toString()
                var parser = JsonParser()
                var element = parser.parse(json)
                summoner.id = element.asJsonObject["id"].asString
                summoner.accountId = element.asJsonObject["accountId"].asString
                summoner.name = element.asJsonObject["name"].asString
                summoner.profileIconId = element.asJsonObject["profileIconId"].asString
                summoner.revisionDate = element.asJsonObject["revisionDate"].asString
                summoner.summonerLevel = element.asJsonObject["summonerLevel"].asString
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (bufferedReader != null)
                bufferedReader.close()
            if (streamReader != null)
                streamReader.close()
            if (stream != null)
                stream.close()
        }
        return summoner
    }

}