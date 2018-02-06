package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class PassiveDto(
        @SerializedName("image") val image: ImageDto,
        @SerializedName("sanitizedDescription") val sanitizedDescription: String,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String
)
