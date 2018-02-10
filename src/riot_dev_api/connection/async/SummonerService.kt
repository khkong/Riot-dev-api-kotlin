package riot_dev_api.connection.async

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import riot_dev_api.Global
import riot_dev_api.dto.summoner_v3.SummonerDTO

interface SummonerService {
    @GET(Global.ApiPath.SUMMONER_V3+"summoners/by-name/{name}")
    fun getSummonerByName(@Path("name") name: String, @Query("api_key") apiKey: String): Call<SummonerDTO>

    @GET(Global.ApiPath.SUMMONER_V3+"summoners/by-account/{accountId}?api_key={apiKey}")
    fun getSummonerByAccount(@Path("accountId") accountId: Long, @Query("api_key") apiKey: String): Call<SummonerDTO>

    @GET(Global.ApiPath.SUMMONER_V3+"summoners/{summonerId}?api_key={apiKey}")
    fun getSummonerBySummonerID(@Path("summonerId") summonerId: Long, @Query("api_key") apiKey: String): Call<SummonerDTO>

    class Async{
        private val service : SummonerService
        constructor(locale : String){
            val retrofit = Retrofit.Builder().baseUrl("https://"+locale).addConverterFactory(GsonConverterFactory.create()).build()
            service = retrofit.create(SummonerService::class.java)
        }
        fun getService(): SummonerService {
            return service
        }
    }
}