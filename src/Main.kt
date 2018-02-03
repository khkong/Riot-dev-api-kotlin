import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.api_test.SummonerConnectionTest
import riot_dev_api.champion_mastery_v3.ChampionMasteryConnection
import riot_dev_api.summoner_v3.SummonerConnection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    GlobalState.API_KEY = args[0]
    GlobalState.SUMMONER_NAME_FOR_TEST = args[1]

    var connFactory = ConnectionFactory()
    var connObject = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
    connObject as SummonerConnection

    var summoner = connObject.getSummonerByName(GlobalState.SUMMONER_NAME_FOR_TEST, GlobalState.API_KEY)
    println()
    println("Example, SUMMONER_V3 ByName")
    println("id : "+summoner.id)
    println("accountId : "+summoner.accountId)
    println("name : "+summoner.name)
    println("profileIconId : "+summoner.profileIconId)
    println("revisionDate : "+summoner.revisionDate)
    println("summonerLevel : "+summoner.summonerLevel)
}