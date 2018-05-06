import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.Global
import riot_dev_api.connection.SummonerConnection
import riot_dev_api.connection.async.SummonerAsyncConn
import riot_dev_api.dto.summoner_v3.SummonerDTO

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    Global.API_KEY = args[0]
    Global.SUMMONER_NAME_FOR_TEST = args[1]

    //example
    println("example HttpsURLConnection")
    var connFactory = ConnectionFactory()
    var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
    connObject as SummonerConnection
    println(connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY))

    //example using retrofit
    println("example using retrofit")
    val service = SummonerAsyncConn.Builder(Global.Locale.KR)
    var call = service.getConnection().getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)
    call.enqueue(object : Callback<SummonerDTO> {
        override fun onResponse(paramColl: Call<SummonerDTO>?, response: Response<SummonerDTO>?) {
            println(response!!.body())
        }
        override fun onFailure(paramColl: Call<SummonerDTO>?, t: Throwable?) {
            call.cancel()
            paramColl!!.cancel()

        }
    })

}