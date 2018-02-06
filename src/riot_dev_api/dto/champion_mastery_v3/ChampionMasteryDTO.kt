package riot_dev_api.dto.champion_mastery_v3

import com.google.gson.annotations.SerializedName

data class ChampionMasteryDTO(
        /**
         * Is chest granted for this champion or not in current season.
         */
        @SerializedName("chestGranted") val chestGranted: Boolean,
        /**
         * Champion level for specified player and champion combination.
         */
        @SerializedName("championLevel") val championLevel: Int,
        /**
         * Total number of champion points for this player and champion combination - they are used to determine championLevel.
         */
        @SerializedName("championPoints") val championPoints: Int,
        /**
         * Champion ID for this entry.
         */
        @SerializedName("championId") val championId: Long,
        /**
         * Player ID for this entry.
         */
        @SerializedName("playerId") val playerId: Long,
        /**
         * Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion.
         */
        @SerializedName("championPointsUntilNextLevel") val championPointsUntilNextLevel: Long,
        /**
         * The token earned for this champion to levelup.
         */
        @SerializedName("tokensEarned") val tokensEarned: Int,
        /**
         * Number of points earned since current level has been achieved.
         */
        @SerializedName("championPointsSinceLastLevel") val championPointsSinceLastLevel: Long,
        /**
         * Last time this champion was played by this player - in Unix milliseconds time format.
         */
        @SerializedName("lastPlayTime") val lastPlayTime: Long
)