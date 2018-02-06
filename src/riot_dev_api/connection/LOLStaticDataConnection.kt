package riot_dev_api.connection

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import riot_dev_api.Global
import riot_dev_api.dto.champion_mastery_v3.ChampionMasteryDTO
import riot_dev_api.dto.luague_v3.LeagueItemDTO
import riot_dev_api.dto.luague_v3.LeagueListDTO
import riot_dev_api.dto.luague_v3.LeaguePositionDTO
import riot_dev_api.dto.luague_v3.MiniSeriesDTO
import riot_dev_api.dto.summoner_v3.SummonerDTO

class LOLStaticDataConnection : Connection {
    private var HOST: String
    private var URL_CHALLENGER_LEAGUES_BY_QUEUE: String
    private var URL_LEAGUE_BY_LEAGUE_ID: String
    private var URL_MASTER_LEAGUES_BY_QUEUE: String
    private var URL_POSITION_BY_SUMMONER: String
    private var PARAM_API_KEY: String

    constructor(){
        this.HOST = ""
        this.URL_CHALLENGER_LEAGUES_BY_QUEUE = ""
        this.URL_LEAGUE_BY_LEAGUE_ID = ""
        this.URL_MASTER_LEAGUES_BY_QUEUE = ""
        this.URL_POSITION_BY_SUMMONER = ""
        this.PARAM_API_KEY =""
    }

    override fun setLocalHost(localHost: String) {
        this.HOST = localHost;
        this.URL_CHALLENGER_LEAGUES_BY_QUEUE = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "challengerleagues/by-queue/"
        this.URL_LEAGUE_BY_LEAGUE_ID = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "leagues/"
        this.URL_MASTER_LEAGUES_BY_QUEUE = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "masterleagues/by-queue/"
        this.URL_POSITION_BY_SUMMONER = "https://" + HOST + Global.ApiPath.LEAGUE_V3 + "positions/by-summoner/"
        this.PARAM_API_KEY = "?api_key="
    }

}