package riot_dev_api.dto.champion_v3

import com.google.gson.annotations.SerializedName

data class ChampionListDto(
        /**
         * The collection of champion information.
         */
        @SerializedName("champions") val champions: List<ChampionDto>
)