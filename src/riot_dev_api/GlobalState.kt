package riot_dev_api

class GlobalState {
    companion object {
        var API_KEY = ""
        var CURR_STATE = 0

        const val BAD_REQUEST = 400
        const val UNAUTHORIZED = 403
        const val FORBIDDEN = 403
        const val DATA_NOT_FOUND = 404
        const val METHOD_NOT_ALLOWED = 405
        const val UNSUPPORTED_MEDIA_TYPE = 415
        const val RATE_LIMIT_EXCEEDED = 429
        const val INTERNAL_SERVER_ERROR= 500
        const val BAD_GATEWAY = 502
        const val SERVIVCE_UNAVAILABLE = 503
        const val GATEWAY_TIMEOUT = 504

        const val CHAMPION_MASTERY_V3 = 1
        const val CHAMPION_V3 = 2
        const val LEAGUE_V3 = 4
        const val LOL_STATIC_DATA_V3 = 8
        const val LOL_STATUS_V3 = 16
        const val MATCH_V3 = 32
        const val SPECTATOR_V3 = 64
        const val SUMMONER_V3 = 128
        const val THIRD_PARTY_CODE_V3 = 256
        const val TOURNAMENT_STUB_V3 = 512
        const val TOURNAMENT_V3 = 1024

        const val BR = "br1.api.riotgames.com";
        const val EUNE = "eun1.api.riotgames.com";
        const val EUW = "euw1.api.riotgames.com";
        const val JP = "jp1.api.riotgames.com";
        const val KR = "kr.api.riotgames.com";
        const val LAN = "la1.api.riotgames.com";
        const val LAS = "la2.api.riotgames.com";
        const val NA = "na1.api.riotgames.com";
        const val OCE = "oc1.api.riotgames.com";
        const val TR = "tr1.api.riotgames.com";
        const val RU = "ru.api.riotgames.com";
        const val PBE = "pbe1.api.riotgames.com";

        const val PATH_CHAMPION_MASTERY_V3 = "/lol/champion-mastery/v3/"
        const val PATH_CHAMPION_V3 = "/lol/platform/v3/"
        const val PATH_LEAGUE_V3 = "/lol/league/v3/"
        const val PATH_LOL_STATIC_DATA_V3 = "/lol/static-data/v3/"
        const val PATH_LOL_STATUS_V3 = "/lol/status/v3/"
        const val PATH_MATCH_V3 = "/lol/match/v3/"
        const val PATH_SPECTATOR_V3 = "/lol/spectator/v3/"
        const val PATH_SUMMONER_V3= "/lol/summoner/v3/";
        const val PATH_THIRD_PARTY_CODE_V3 = "/lol/platform/"
        const val PATH_TOURNAMENT_STUB_V3 = "/lol/tournament-stub/v3/"
        const val PATH_TOURNAMENT_V3 = "/lol/tournament/v3/"

    }


}

