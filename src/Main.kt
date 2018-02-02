import riot_dev_api.ConnectionFactory
import riot_dev_api.GlobalState
import riot_dev_api.summoner_v3.SummonerConnection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    GlobalState.API_KEY = args[0]

    var connFactory = ConnectionFactory();
    var conn = connFactory.getConnection(GlobalState.SUMMONER_V3, GlobalState.KR)
    conn as SummonerConnection
    var summoner = conn.getSummonersByName("안산외로운자크", GlobalState.API_KEY);
    println("id : "+summoner.id)
    println("accountId : "+summoner.accountId)
    println("name : "+summoner.name)
    println("profileIconId : "+summoner.profileIconId)
    println("revisionDate : "+summoner.revisionDate)
    println("summonerLevel : "+summoner.summonerLevel)
}