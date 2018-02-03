package riot_dev_api.api_test

import org.junit.Assert
import org.junit.Test
import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.summoner_v3.SummonerConnection

class SummonerConnectionTest {
    @Test
    fun connByAccount() {
        var summonerName = "안산외로운자크"
        GlobalState.API_KEY = "RGAPI-fa3a91af-9166-4ce3-ab9a-e28ca3dfd0a6"

        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection

        var summoner = connObject.connByName(summonerName, GlobalState.API_KEY);
        summoner = connObject.connByAccount(summoner.accountId!!, GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }

    @Test
    fun connByName() {
        var summonerName = "안산외로운자크"
        GlobalState.API_KEY = "RGAPI-fa3a91af-9166-4ce3-ab9a-e28ca3dfd0a6"

        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.connByName("안산외로운자크", GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }

    @Test
    fun conn() {
        var summonerName = "안산외로운자크"
        GlobalState.API_KEY = "RGAPI-fa3a91af-9166-4ce3-ab9a-e28ca3dfd0a6"

        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection

        var summoner = connObject.connByName(summonerName, GlobalState.API_KEY);
        summoner = connObject.conn(summoner.id!!, GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }
}