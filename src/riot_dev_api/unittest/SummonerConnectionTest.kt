package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.Global
import riot_dev_api.connection.SummonerConnection

class SummonerConnectionTest {
    @Test
    fun getSummonerByAccount() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        summoner = connObject.getSummonerByAccount(summoner.accountId!!, Global.API_KEY)
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name)
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId)
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id)
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId)
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel)
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate)
    }

    @Test
    fun getSummonerByName() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
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
        var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        summoner = connObject.getSummonerBySummonerID(summoner.id!!, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner.name is null data.",summoner.name);
        Assert.assertNotNull("Failed. Summoner.accountId is null data.",summoner.accountId);
        Assert.assertNotNull("Failed. Summoner.id is null data.",summoner.id);
        Assert.assertNotNull("Failed. Summoner.profileIconId is null data.",summoner.profileIconId);
        Assert.assertNotNull("Failed. Summoner.summonerLevel is null data.",summoner.summonerLevel);
        Assert.assertNotNull("Failed. Summoner.revisionDate is null data.",summoner.revisionDate);
    }
}