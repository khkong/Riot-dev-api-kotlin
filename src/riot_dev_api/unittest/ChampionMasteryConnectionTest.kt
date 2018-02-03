package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.Global
import riot_dev_api.connection.ChampionMasteryConnection
import riot_dev_api.connection.SummonerConnection

class ChampionMasteryConnectionTest {
    @Test
    fun getChampMasteryList() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        var champMasteryList = connObject.getChampMasteryList(summoner.id!!, Global.API_KEY)

        //Usually there is more than one, but it is not likely to be empty. Please note.
        Assert.assertFalse("Failed. champMastery list is empty", champMasteryList.isEmpty())
    }

    @Test
    fun getChampMastery() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        var champMasteryList = connObject.getChampMasteryList(summoner.id!!, Global.API_KEY)

        var champMastery = connObject.getChampMastery(summoner.id!!, champMasteryList[0].championId!!, Global.API_KEY)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].playerId, champMastery.playerId)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].championPointsUntilNextLevel, champMastery.championPointsUntilNextLevel)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].championPointsSinceLastLevel, champMastery.championPointsSinceLastLevel)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].championLevel, champMastery.championLevel)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].championPoints, champMastery.championPoints)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].chestGranted, champMastery.chestGranted)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].tokensEarned, champMastery.tokensEarned)
        Assert.assertEquals("Champion id is " + champMasteryList[0].championId, champMasteryList[0].lastPlayTime, champMastery.lastPlayTime)
    }

    @Test
    fun getTotalMasteryScore() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.CHAMPION_MASTERY_V3, Global.Locale.KR)
        connObject as ChampionMasteryConnection
        var totalScore = connObject.getTotalMasteryScore(summoner.id!!, Global.API_KEY)

        Assert.assertNotSame(-1, totalScore)
    }
}