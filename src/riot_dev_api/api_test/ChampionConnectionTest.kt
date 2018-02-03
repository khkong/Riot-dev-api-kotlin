package riot_dev_api.api_test

import org.junit.Assert
import org.junit.Test
import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.champion_mastery_v3.ChampionMasteryConnection
import riot_dev_api.champion_v3.ChampionConnection
import riot_dev_api.summoner_v3.SummonerConnection

class ChampionConnectionTest {
    @Test
    fun getChampionList() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.CHAMPION_V3, GlobalState.KR)
        connObject as ChampionConnection
        var freeChampions = connObject.getChampionList(true,GlobalState.API_KEY);
        var allChampions = connObject.getChampionList(false,GlobalState.API_KEY);

        Assert.assertFalse("champions is empty.",freeChampions.isEmpty())
        Assert.assertFalse("champions is empty.",allChampions.isEmpty())
    }

    @Test
    fun getChampionByChampionID() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(GlobalState.CHAMPION_V3, GlobalState.KR)
        connObject as ChampionConnection
        var champion = connObject.getChampionByChampionID(1,GlobalState.API_KEY);

        Assert.assertNotNull("Failed. Champion.rankedPlayEnabled is null data.",champion.rankedPlayEnabled)
        Assert.assertNotNull("Failed. Champion.botEnabled is null data.",champion.botEnabled)
        Assert.assertNotNull("Failed. Champion.botMmEnabled is null data.",champion.botMmEnabled)
        Assert.assertNotNull("Failed. Champion.active is null data.",champion.active)
        Assert.assertNotNull("Failed. Champion.freeToPlay is null data.",champion.freeToPlay)
        Assert.assertNotNull("Failed. Champion.id is null data.",champion.id)
    }
}