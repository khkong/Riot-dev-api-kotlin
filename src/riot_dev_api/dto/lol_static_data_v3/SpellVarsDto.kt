package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class SpellVarsDto(
        @SerializedName("ranksWith") val ranksWith : String,
        @SerializedName("dyn") val dyn : String,
        @SerializedName("link") val link : String,
        @SerializedName("coeff") val coeff : List<Double>,
        @SerializedName("key") val key : String
)