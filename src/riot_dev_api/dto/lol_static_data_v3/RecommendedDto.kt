package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class RecommendedDto(
        @SerializedName("map") val map : String,
        @SerializedName("blocks") val blocks : List<BlockDto>,
        @SerializedName("champion") val champion : String,
        @SerializedName("title") val title : String,
        @SerializedName("priority") val priority : Boolean,
        @SerializedName("mode") val mode : String,
        @SerializedName("type") val type : String
)