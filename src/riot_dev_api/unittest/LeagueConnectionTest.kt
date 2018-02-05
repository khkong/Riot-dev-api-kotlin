package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import riot_dev_api.Global
import riot_dev_api.connection.ChampionConnection
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.connection.LeagueConnection
import riot_dev_api.connection.SummonerConnection
import riot_dev_api.dto.luague_v3.LeagueListDTO
import riot_dev_api.dto.luague_v3.LeaguePositionDTO

class LeagueConnectionTest {
    @Test
    fun getChallengerLeaguesByQueue() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertFalse("challenger leagues list is empty. "+Global.LeagueQueue.RANKED_SOLO_5x5,list.name.isNullOrEmpty())

        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_SR, Global.API_KEY)
        Assert.assertFalse("challenger leagues list is empty. " + Global.LeagueQueue.RANKED_FLEX_SR,list.name.isNullOrEmpty())

        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_TT, Global.API_KEY)
        Assert.assertFalse("challenger leagues list is empty. " + Global.LeagueQueue.RANKED_FLEX_TT,list.name.isNullOrEmpty())
    }

    @Test
    fun getLeaguesByLeagueID() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(list.entries[0].playerOrTeamName!!, Global.API_KEY)

        connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var leaguePosition = connObject.getPositionBySummoner(summoner.id!!, Global.API_KEY)
        connObject.getLeaguesByLeagueID(leaguePosition.leagueId!!, Global.API_KEY)
        list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertFalse("getPositionBySummoner leagues list is empty. "+Global.LeagueQueue.RANKED_SOLO_5x5,list.name.isNullOrEmpty())
    }

    @Test
    fun getMasterLeaguesByQueue() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)
        Assert.assertFalse("master leagues list is empty. "+Global.LeagueQueue.RANKED_SOLO_5x5,list.name.isNullOrEmpty())
//        list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_SR, Global.API_KEY)
//        Assert.assertFalse("master leagues list is empty. " + Global.LeagueQueue.RANKED_FLEX_SR,list.name.isNullOrEmpty())
//
//        list = connObject.getMasterLeaguesByQueue(Global.LeagueQueue.RANKED_FLEX_TT, Global.API_KEY)
//        Assert.assertFalse("master leagues list is empty. " + Global.LeagueQueue.RANKED_FLEX_TT,list.name.isNullOrEmpty())
    }

    @Test
    fun getPositionBySummoner() {
        var connFactory = ConnectionFactory();
        var connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var list = connObject.getChallengerLeaguesByQueue(Global.LeagueQueue.RANKED_SOLO_5x5, Global.API_KEY)


        connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(list.entries[0].playerOrTeamName!!, Global.API_KEY)


        connObject = connFactory.getConnection(Global.Api.LEAGUE_V3, Global.Locale.KR)
        connObject as LeagueConnection
        var leaguePosition = connObject.getPositionBySummoner(summoner.id!!, Global.API_KEY)

        Assert.assertNotNull("Failed. leaguePosition.rank is null data.",leaguePosition.rank);
        Assert.assertNotNull("Failed. leaguePosition.queueType is null data.",leaguePosition.queueType);
        Assert.assertNotNull("Failed. leaguePosition.hotStreak is null data.",leaguePosition.hotStreak);
//        Assert.assertNotNull("Failed. leaguePosition.miniSeries is null data.",leaguePosition.miniSeries);
        Assert.assertNotNull("Failed. leaguePosition.wins is null data.",leaguePosition.wins);
        Assert.assertNotNull("Failed. leaguePosition.veteran is null data.",leaguePosition.veteran);
        Assert.assertNotNull("Failed. leaguePosition.losses is null data.",leaguePosition.losses);
        Assert.assertNotNull("Failed. leaguePosition.freshBlood is null data.",leaguePosition.freshBlood);
        Assert.assertNotNull("Failed. leaguePosition.leagueId is null data.",leaguePosition.leagueId);
        Assert.assertNotNull("Failed. leaguePosition.playerOrTeamName is null data.",leaguePosition.playerOrTeamName);
        Assert.assertNotNull("Failed. leaguePosition.inactive is null data.",leaguePosition.inactive);
        Assert.assertNotNull("Failed. leaguePosition.playerOrTeamId is null data.",leaguePosition.playerOrTeamId);
        Assert.assertNotNull("Failed. leaguePosition.leagueName is null data.",leaguePosition.leagueName);
        Assert.assertNotNull("Failed. leaguePosition.tier is null data.",leaguePosition.tier);
        Assert.assertNotNull("Failed. leaguePosition.leaguePoints is null data.",leaguePosition.leaguePoints);
    }
}