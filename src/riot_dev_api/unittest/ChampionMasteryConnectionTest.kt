package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.Global
import riot_dev_api.connection.ChampionMasteryConnection
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.connection.SummonerConnection

class ChampionMasteryConnectionTest {
    @Test
    fun getChampMasteryList() {
        val connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        val champMasteryList = connObject.getChampMasteryList(summoner!!.id, Global.API_KEY)
        Assert.assertNotNull("Failed. Champion mastery list is null data.", champMasteryList);

    }

    @Test
    fun getChampMastery() {
        val connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        val list = connObject.getChampMasteryList(summoner!!.id, Global.API_KEY)
        Assert.assertNotNull("Failed. Champion mastery list is null data.", list);
        val champMastery = connObject.getChampMastery(summoner!!.id, list!![0].championId, Global.API_KEY)
        Assert.assertNotNull("Failed. Champion mastery is null data.", champMastery);
    }

    @Test
    fun getTotalMasteryScore() {
        val connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        val totalScore = connObject.getTotalMasteryScore(summoner!!.id, Global.API_KEY)
        Assert.assertNotSame(-1, totalScore)
    }
}