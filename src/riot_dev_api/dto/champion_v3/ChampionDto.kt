package riot_dev_api.dto.champion_v3

import com.google.gson.annotations.SerializedName

data class ChampionDto(
        /**
         * 	Ranked play enabled flag.
         */
        @SerializedName("rankedPlayEnabled") val rankedPlayEnabled: Boolean,
        /**
         * Bot enabled flag (for custom games).
         */
        @SerializedName("botEnabled") val botEnabled: Boolean,
        /**
         * Bot Match Made enabled flag (for Co-op vs. AI games).
         */
        @SerializedName("botMmEnabled") val botMmEnabled: Boolean,
        /**
         * 	Indicates if the champion is active.
         */
        @SerializedName("active") val active: Boolean,
        /**
         * Indicates if the champion is free to play. Free to play champions are rotated periodically.
         */
        @SerializedName("freeToPlay") val revisionDate: Boolean,
        /**
         * Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API.
         */
        @SerializedName("id") val id: Long
)
