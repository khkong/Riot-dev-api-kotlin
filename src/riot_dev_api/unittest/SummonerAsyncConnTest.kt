package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riot_dev_api.Global
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.connection.SummonerConnection
import riot_dev_api.connection.async.SummonerAsyncConn
import riot_dev_api.dto.summoner_v3.SummonerDTO

class SummonerAsyncConnTest {
    @Test
    fun getSummonerByAccount() {
        var conn = SummonerAsyncConn.Builder(Global.Locale.KR).getConnection()
        var call = conn.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)
        call.enqueue(object : Callback<SummonerDTO> {
            override fun onResponse(call: Call<SummonerDTO>?, response: Response<SummonerDTO>?) {
                println(response!!.body())
                var subCall = conn.getSummonerByAccount(response!!.body()!!.accountId, Global.API_KEY)
                subCall.enqueue(object  : Callback<SummonerDTO>{
                    override fun onResponse(p0: Call<SummonerDTO>?, p1: Response<SummonerDTO>?) {
                        println(p1!!.body())
                    }

                    override fun onFailure(p0: Call<SummonerDTO>?, p1: Throwable?) {
                        Assert.assertNotNull("Failed.", null)
                    }
                })

            }
            override fun onFailure(call: Call<SummonerDTO>?, t: Throwable?) {
                Assert.assertNotNull("Failed.", null)
            }
        })
    }

    @Test
    fun getSummonerByName() {
        var call = SummonerAsyncConn.Builder(Global.Locale.KR).getConnection().getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)
        call.enqueue(object : Callback<SummonerDTO> {
            override fun onResponse(call: Call<SummonerDTO>?, response: Response<SummonerDTO>?) {
                println(response!!.body())
            }
            override fun onFailure(call: Call<SummonerDTO>?, t: Throwable?) {
                Assert.assertNotNull("Failed.", null)
            }
        })
    }

    @Test
    fun getSummonerBySummonerID() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);
        summoner = connObject.getSummonerBySummonerID(summoner!!.id, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);

        var conn = SummonerAsyncConn.Builder(Global.Locale.KR).getConnection()
        var callback = conn.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST,Global.API_KEY)
        callback.enqueue(object : Callback<SummonerDTO>{
            override fun onResponse(p0: Call<SummonerDTO>?, p1: Response<SummonerDTO>?) {
                var subcall = conn.getSummonerBySummonerID(p1!!.body()!!.id, Global.API_KEY)
                subcall.enqueue(object : Callback<SummonerDTO>{
                    override fun onResponse(p0: Call<SummonerDTO>?, p1: Response<SummonerDTO>?) {
                        println(p1!!.body())
                    }

                    override fun onFailure(p0: Call<SummonerDTO>?, p1: Throwable?) {
                        Assert.assertNotNull("Failed.", null)
                    }
                })
            }
            override fun onFailure(p0: Call<SummonerDTO>?, p1: Throwable?) {
                Assert.assertNotNull("Failed.", null)
            }
        })
    }
}