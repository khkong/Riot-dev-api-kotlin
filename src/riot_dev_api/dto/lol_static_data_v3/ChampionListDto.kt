package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class ChampionListDto(
        @SerializedName("keys") val keys: Map<String, String>,
        @SerializedName("data") val data: Map<String, ChampionDto>,
        @SerializedName("version") val version: String,
        @SerializedName("type") val type: String,
        @SerializedName("format") val format: String
)