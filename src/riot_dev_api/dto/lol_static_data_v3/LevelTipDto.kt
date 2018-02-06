package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class LevelTipDto(
        @SerializedName("effect") val effect: List<String>,
        @SerializedName("label") val label: List<String>
)