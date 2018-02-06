package riot_dev_api.dto.luague_v3

import com.google.gson.annotations.SerializedName

data class LeaguePositionDTO(
        @SerializedName("rank") val rank : String,
        @SerializedName("queueType") val queueType : String,
        @SerializedName("hotStreak") val hotStreak : Boolean,
        @SerializedName("miniSeries") val miniSeries : MiniSeriesDTO,
        @SerializedName("wins") val wins : Int,
        @SerializedName("veteran") val veteran : Boolean,
        @SerializedName("losses") val losses : Int,
        @SerializedName("freshBlood") val freshBlood : Boolean,
        @SerializedName("leagueId") val leagueId : String,
        @SerializedName("playerOrTeamName") val playerOrTeamName : String,
        @SerializedName("inactive") val inactive : Boolean,
        @SerializedName("playerOrTeamId") val playerOrTeamId : String,
        @SerializedName("leagueName") val leagueName : String,
        @SerializedName("tier") val tier : String,
        @SerializedName("leaguePoints") val leaguePoints : Int
)