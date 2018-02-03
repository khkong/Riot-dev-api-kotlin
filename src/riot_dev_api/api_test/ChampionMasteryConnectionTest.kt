package riot_dev_api.api_test

import org.junit.Assert
import org.junit.Test
import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.champion_mastery_v3.ChampionMasteryConnection
import riot_dev_api.summoner_v3.SummonerConnection

class ChampionMasteryConnectionTest {
    @Test
    fun getCampMasteryList() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST, GlobalState.API_KEY)

        connObject = connFactory.getConnection(GlobalState.CHAMPION_MASTERY_V3, GlobalState.KR)
        connObject as ChampionMasteryConnection
        var champMasteryList = connObject.getCampMasteryList(summoner.id!!, GlobalState.API_KEY)

        //Usually there is more than one, but it is not likely to be empty. Please note.
        Assert.assertFalse("Failed. champMastery list is empty", champMasteryList.isEmpty())
    }

    @Test
    fun getCampMastery() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST, GlobalState.API_KEY)

        connObject = connFactory.getConnection(GlobalState.CHAMPION_MASTERY_V3, GlobalState.KR)
        connObject as ChampionMasteryConnection
        var champMasteryList = connObject.getCampMasteryList(summoner.id!!, GlobalState.API_KEY)

        var champMastery = connObject.getCampMastery(summoner.id!!, champMasteryList[0].championId!!, GlobalState.API_KEY)
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
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST, GlobalState.API_KEY)

        connObject = connFactory.getConnection(GlobalState.CHAMPION_MASTERY_V3, GlobalState.KR)
        connObject as ChampionMasteryConnection
        var totalScore = connObject.getTotalMasteryScore(summoner.id!!, GlobalState.API_KEY)

        Assert.assertNotSame(-1, totalScore)
    }
}