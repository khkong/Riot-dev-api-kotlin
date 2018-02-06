package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class ImageDto(
        @SerializedName("full") val full: String,
        @SerializedName("group") val group: String,
        @SerializedName("sprite") val sprite: String,
        @SerializedName("h") val h: Int,
        @SerializedName("w") val w: Int,
        @SerializedName("y") val y: Int,
        @SerializedName("x") val x: Int
)