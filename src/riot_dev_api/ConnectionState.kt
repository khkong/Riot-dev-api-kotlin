package riot_dev_api

class ConnectionState{
    companion object {
        var API_KEY = ""
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

        const val BAD_REQUEST = 400
        const val UBAUTHORIZED = 403
        const val FORBIDDEN = 403
        const val DATA_NOT_FOUND = 404
        const val METHOD_NOT_ALLOWED = 405
        const val UNSUPPORTED_MEDIA_TYPE = 415
        const val RATE_LIMIT_EXCEEDED = 429
        const val INTERNAL_SERVER_ERROR= 500
        const val BAD_GATEWAY = 502
        const val SERVIVCE_UNAVAILABLE = 503
        const val GATEWAY_TIMEOUT = 504

    }


}

