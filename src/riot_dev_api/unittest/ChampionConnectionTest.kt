package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.Global
import riot_dev_api.connection.ChampionConnection

class ChampionConnectionTest {
    @Test
    fun getChampionList() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.CHAMPION_V3, Global.Locale.KR)
        connObject as ChampionConnection
        var freeChampions = connObject.getChampionList(true, Global.API_KEY);
        var allChampions = connObject.getChampionList(false, Global.API_KEY);

        Assert.assertFalse("champions is empty.",freeChampions.champions!!.isEmpty())
        Assert.assertFalse("champions is empty.",allChampions.champions!!.isEmpty())
    }

    @Test
    fun getChampionByChampionID() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.CHAMPION_V3, Global.Locale.KR)
        connObject as ChampionConnection
        var champion = connObject.getChampionByChampionID(1, Global.API_KEY);

        Assert.assertNotNull("Failed. Champion.rankedPlayEnabled is null data.",champion.rankedPlayEnabled)
        Assert.assertNotNull("Failed. Champion.botEnabled is null data.",champion.botEnabled)
        Assert.assertNotNull("Failed. Champion.botMmEnabled is null data.",champion.botMmEnabled)
        Assert.assertNotNull("Failed. Champion.active is null data.",champion.active)
        Assert.assertNotNull("Failed. Champion.freeToPlay is null data.",champion.freeToPlay)
        Assert.assertNotNull("Failed. Champion.id is null data.",champion.id)
    }
}