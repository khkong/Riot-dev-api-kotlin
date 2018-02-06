package riot_dev_api.dto.summoner_v3

import com.google.gson.annotations.SerializedName

data class SummonerDTO(
        /**
         * Summoner ID.
         */
        @SerializedName("id") val id: Long,
        /**
         * Account ID.
         */
        @SerializedName("accountId") val accountId: Long,
        /**
         * Summoner name.
         */
        @SerializedName("name") val name: String,
        /**
         * ID of the summoner icon associated with the summoner.
         */
        @SerializedName("profileIconId") val profileIconId: Int,
        /**
         * Date summoner was last modified specified as epoch milliseconds.
         * The following events will update this timestamp: profile icon change,
         * playing the tutorial or advanced tutorial, finishing a game, summoner name change
         */
        @SerializedName("revisionDate") val revisionDate: Long,
        /**
         * Summoner level associated with the summoner.
         */
        @SerializedName("summonerLevel") val summonerLevel: Long
)
