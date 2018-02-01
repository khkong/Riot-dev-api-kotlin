package riot_dev_api.summoner_v3

import riot_dev_api.Connection
import riot_dev_api.ConnectionState
import riot_dev_api.Data
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.net.URLEncoder
import javax.net.ssl.HttpsURLConnection

class SummonerConnection : Connection() {

    companion object {
        const val URL_BY_ACCOUNT = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-account/"
        const val URL_BY_NAME = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"
        const val URL_NOTTHING = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/"
    }

    public fun getSummonersByAccount(accountId : String): Summoner {
        var data = connectAPI(URL_BY_ACCOUNT + accountId+"?api_key="+ConnectionState.API_KEY)
        data = data as Summoner
        return data
    }

    public fun getSummonersByName(summonerName : String): Summoner {
        var name = URLEncoder.encode(summonerName, "UTF-8")
        var data = connectAPI(URL_BY_NAME + name+"?api_key="+ConnectionState.API_KEY)
        data = data as Summoner
        return data
    }

    public fun getSummoners(summonerId : String): Summoner {
        var data = connectAPI(URL_NOTTHING + summonerId +"?api_key="+ConnectionState.API_KEY)
        data = data as Summoner
        return data
    }

    override fun connectAPI(api: String): Data  {
        var summoner = Summoner()
        var retStr = ""
        var stream: InputStream? = null
        var streamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null

        try {

            var url = URL(api)
            var conn = url.openConnection()

            conn as HttpsURLConnection
            if(respondeCode(conn.responseCode)) {
                //Connect to host
                conn.connect()
                stream = conn.getInputStream()
                streamReader = InputStreamReader(stream)
                bufferedReader = BufferedReader(streamReader)
                var line: String?
                do {
                    line = bufferedReader.readLine()
                    if (line != null)
                        retStr += line;
                } while (line != null)
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
        println(retStr)
        return summoner
    }

}