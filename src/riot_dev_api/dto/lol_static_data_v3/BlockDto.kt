package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class BlockDto(
        @SerializedName("items") val items: List<BlockItemDto>,
        @SerializedName("recMath") val recMath: Boolean,
        @SerializedName("type") val type: String
)