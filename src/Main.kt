import riot_api.connection.Connection

fun main(args : Array<String>) {
    println("Hello, RIOT-API-kotlin!")

    var conn = Connection();
    var url = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key="
    var res = conn.getHttps(url+ args[0]);
    println(res)
}