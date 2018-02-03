package riot_dev_api.api_test

import org.junit.Assert
import org.junit.Test
import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.summoner_v3.SummonerConnection

class SummonerConnectionTest {
    @Test
    fun getSummonerByAccount() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST/*summoner name*/, GlobalState.API_KEY);
        summoner = connObject.getSummonerByAccount(summoner.accountId!!, GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }

    @Test
    fun getSummonerByName() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST/*summoner name*/, GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }

    @Test
    fun getSummonerBySummonerID() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST/*summoner name*/, GlobalState.API_KEY);
        summoner = connObject.getSummonerBySummonerID(summoner.id!!, GlobalState.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }
}