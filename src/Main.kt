import riot_dev_api.ConnectionFactory
import riot_dev_api.ConnectionState
import riot_dev_api.summoner_v3.SummonerConnection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")
    ConnectionState.API_KEY = args[0]

    var connFactory = ConnectionFactory();
    var conn = connFactory.getConnection(ConnectionState.SUMMONER_V3)
    conn as SummonerConnection
    var summoner = conn.getSummonersByName("안산외로운자크");

}