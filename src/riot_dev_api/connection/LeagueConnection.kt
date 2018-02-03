package riot_dev_api.connection

import riot_dev_api.connection.Connection

class LeagueConnection : Connection {
    private val HOST: String
    private val URL_CHALLENGER_LEAGUES_BY_QUEUE: String
    private val URL_LEAGUE_BY_LEAGUE_ID: String
    private val URL_MASTER_LEAGUES_BY_QUEUE: String
    private val URL_POSITION_BY_SUMMONER: String
    private val PARAM_API_KEY: String

    constructor(host: String) {
        this.HOST = host;
        this.URL_CHALLENGER_LEAGUES_BY_QUEUE = "https://"
        this.URL_LEAGUE_BY_LEAGUE_ID = "https://"
        this.URL_MASTER_LEAGUES_BY_QUEUE = "https://"
        this.URL_POSITION_BY_SUMMONER = "https://"
        this.PARAM_API_KEY = "?api_key="
    }

}