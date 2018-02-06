package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class BlockItemDto(
        @SerializedName("count") val count: Int,
        @SerializedName("id") val id: Int
)