package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class SkinDto(
        @SerializedName("num") val num: Int,
        @SerializedName("name") val name: String,
        @SerializedName("id") val id: Int
)