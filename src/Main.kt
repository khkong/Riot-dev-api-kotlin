import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.api_test.SummonerConnectionTest
import riot_dev_api.champion_mastery_v3.ChampionMasteryConnection
import riot_dev_api.summoner_v3.SummonerConnection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    GlobalState.API_KEY = args[0]

    var test = SummonerConnectionTest()
    test.conn()
    test.connByName()
    test.connByAccount()

    var connFactory = ConnectionFactory();
    var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
    connObject as SummonerConnection
    var summoner = connObject.connByName("안산외로운자크", GlobalState.API_KEY);
    println("SUMMONER_V3 ByName")
    println("id : "+summoner.id)
    println("accountId : "+summoner.accountId)
    println("name : "+summoner.name)
    println("profileIconId : "+summoner.profileIconId)
    println("revisionDate : "+summoner.revisionDate)
    println("summonerLevel : "+summoner.summonerLevel)
    println()

    connObject = connFactory.getConnection(GlobalState.CHAMPION_MASTERY_V3, GlobalState.KR)
    connObject as ChampionMasteryConnection
    var champMateryArr = connObject.connBySummonerID(summoner.id!!, GlobalState.API_KEY);
    for (item in champMateryArr) {
        println("chestGranted : " + item.chestGranted)
        println("championLevel : " + item.championLevel)
        println("championPoints : " + item.championPoints)
        println("championId : " + item.championId)
        println("playerId : " + item.playerId)
        println("championPointsUntilNextLevel : " + item.championPointsUntilNextLevel)
        println("tokensEarned : " + item.tokensEarned)
        println("championPointsSinceLastLevel : " + item.championPointsSinceLastLevel)
        println("lastPlayTime : " + item.lastPlayTime)
        println()
    }
}