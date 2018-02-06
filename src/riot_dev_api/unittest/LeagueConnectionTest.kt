package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.Global
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.connection.LeagueConnection
import riot_dev_api.connection.SummonerConnection

class LeagueConnectionTest {
    @Test
    fun getChallengerLeaguesByQueue() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertNotNull("Failed. Challenger Leagues is null data.(RANKED_SOLO_5x5)", list);

        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_SR, Global.API_KEY)
        Assert.assertNotNull("Failed. Challenger Leagues is null data.(RANKED_FLEX_SR)", list);

        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_TT, Global.API_KEY)
        Assert.assertNotNull("Failed. Challenger Leagues is null data.(RANKED_FLEX_TT)", list);
    }

    @Test
    fun getLeaguesByLeagueID() {
        val connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertNotNull("Failed. Challenger Leagues is null data.(RANKED_FLEX_TT)", list);

        connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(list!!.entries[0].playerOrTeamName, Global.API_KEY)
        Assert.assertNotNull("Failed. Challenger Leagues is null data.(RANKED_FLEX_TT)", list);

        connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        val leaguePosition = connObject.getPositionBySummoner(summoner!!.id, Global.API_KEY)
        Assert.assertNotNull("Failed. league positiont is null data.", leaguePosition);

        connObject.getLeaguesByLeagueID(leaguePosition!!.elementAt(0).leagueId, Global.API_KEY)
        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)

        Assert.assertNotNull("Failed. Challenger Leagues is null data.", list);
    }

    @Test
    fun getMasterLeaguesByQueue() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertNotNull("Failed. leagues list is null data.(RANKED_SOLO_5x5)", list);

        list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_SR, Global.API_KEY)
        Assert.assertNotNull("Failed. leagues list is null data.(RANKED_FLEX_SR)", list);

        list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_TT, Global.API_KEY)
        Assert.assertNotNull("Failed. leagues list is null data.(RANKED_FLEX_TT)", list);
    }

    @Test
    fun getPositionBySummoner() {
        val connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        val list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)


        connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(list!!.entries[0].playerOrTeamName, Global.API_KEY)
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);

        connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        val leaguePosition = connObject.getPositionBySummoner(summoner!!.id, Global.API_KEY)
        Assert.assertNotNull("Failed. league positiont is null data.", leaguePosition);
    }
}