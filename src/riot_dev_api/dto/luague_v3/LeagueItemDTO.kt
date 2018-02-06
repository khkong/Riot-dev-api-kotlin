package riot_dev_api.dto.luague_v3

import com.google.gson.annotations.SerializedName

data class LeagueItemDTO(
        @SerializedName("rank") val rank: String,
        @SerializedName("hotStreak") val hotStreak: Boolean,
        @SerializedName("miniSeries") val miniSeries: MiniSeriesDTO,
        @SerializedName("wins") val wins: Int,
        @SerializedName("veteran") val veteran: Boolean,
        @SerializedName("losses") val losses: Int,
        @SerializedName("freshBlood") val freshBlood: Boolean,
        @SerializedName("playerOrTeamName") val playerOrTeamName: String,
        @SerializedName("inactive") val inactive: Boolean,
        @SerializedName("playerOrTeamId") val playerOrTeamId: String,
        @SerializedName("leaguePoints") val leaguePoints: Int
)