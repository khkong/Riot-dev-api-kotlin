package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class InfoDto(
        @SerializedName("difficulty") val difficulty: Int,
        @SerializedName("attack") val attack: Int,
        @SerializedName("defense") val defense: Int,
        @SerializedName("magic") val magic: Int
)