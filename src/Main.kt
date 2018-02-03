import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.Global
import riot_dev_api.connection.SummonerConnection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    Global.API_KEY = args[0]
    Global.SUMMONER_NAME_FOR_TEST = args[1]

    var connFactory = ConnectionFactory()
    var connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
    connObject as SummonerConnection

    var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST, Global.API_KEY)
    println()
    println("Example, SUMMONER_V3 ByName")
    println("id : "+summoner.id)
    println("accountId : "+summoner.accountId)
    println("name : "+summoner.name)
    println("profileIconId : "+summoner.profileIconId)
    println("revisionDate : "+summoner.revisionDate)
    println("summonerLevel : "+summoner.summonerLevel)
}