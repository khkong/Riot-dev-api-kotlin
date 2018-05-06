package riot_dev_api.connection.async

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import riot_dev_api.Global
import riot_dev_api.dto.summoner_v3.SummonerDTO

interface SummonerAsyncConn {
    @GET(Global.ApiPath.SUMMONER_V3+"summoners/by-name/{name}")
    fun getSummonerByName(@Path("name") name: String, @Query("api_key") apiKey: String): Call<SummonerDTO>

    @GET(Global.ApiPath.SUMMONER_V3+"summoners/by-account/{accountId}")
    fun getSummonerByAccount(@Path("accountId") accountId: Long, @Query("api_key") apiKey: String): Call<SummonerDTO>

    @GET(Global.ApiPath.SUMMONER_V3+"summoners/{summonerId}")
    fun getSummonerBySummonerID(@Path("summonerId") summonerId: Long, @Query("api_key") apiKey: String): Call<SummonerDTO>

    class Builder{
        private val asyncConn : SummonerAsyncConn
        constructor(locale : String){
            val retrofit = Retrofit.Builder().baseUrl("https://"+locale).addConverterFactory(GsonConverterFactory.create()).build()
            asyncConn = retrofit.create(SummonerAsyncConn::class.java)
        }
        fun getConnection(): SummonerAsyncConn {
            return asyncConn
        }
    }
}