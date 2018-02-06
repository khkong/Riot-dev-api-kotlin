package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.Global
import riot_dev_api.connection.ChampionConnection
import riot_dev_api.connection.ConnectionFactory

class ChampionConnectionTest {
    @Test
    fun getChampionList() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.CHAMPION_V3, Global.Locale.KR)
        connObject as ChampionConnection
        val freeChampions = connObject.getChampionList(true, Global.API_KEY);
        Assert.assertNotNull("Failed. ChampionList is null data. (free)", freeChampions);
        val allChampions = connObject.getChampionList(false, Global.API_KEY);
        Assert.assertNotNull("Failed. ChampionList is null data. (all)", allChampions);
    }

    @Test
    fun getChampionByChampionID() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.CHAMPION_V3, Global.Locale.KR)
        connObject as ChampionConnection
        val allChampions = connObject.getChampionList(false, Global.API_KEY);
        Assert.assertNotNull("Failed. ChampionList is null data. (all)", allChampions);
        val list = allChampions!!.champions;
        var champion = connObject.getChampionByChampionID(list!![0].id, Global.API_KEY);
    }
}