package riot_dev_api.dto.luague_v3

import com.google.gson.annotations.SerializedName

data class MiniSeriesDTO(
        @SerializedName("wins") val wins: Int,
        @SerializedName("losses") val losses: Int,
        @SerializedName("target") val target: Int,
        @SerializedName("progress") val progress: String
)