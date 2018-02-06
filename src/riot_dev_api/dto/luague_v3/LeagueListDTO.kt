package riot_dev_api.dto.luague_v3

import com.google.gson.annotations.SerializedName

data class LeagueListDTO(
        @SerializedName("leagueId") val leagueId: String,
        @SerializedName("tier") val tier: String,
        @SerializedName("entries") val entries: List<LeagueItemDTO>,
        @SerializedName("queue") val queue: String,
        @SerializedName("name") val name: String
)