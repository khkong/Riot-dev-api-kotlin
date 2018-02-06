package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class StatsDto(
        @SerializedName("armorperlevel") val armorperlevel: Double,
        @SerializedName("hpperlevel") val hpperlevel: Double,
        @SerializedName("attackdamage") val attackdamage: Double,
        @SerializedName("mpperlevel") val mpperlevel: Double,
        @SerializedName("attackspeedoffset") val attackspeedoffset: Double,
        @SerializedName("armor") val armor: Double,
        @SerializedName("hp") val hp: Double,
        @SerializedName("hpregenperlevel") val hpregenperlevel: Double,
        @SerializedName("spellblock") val spellblock: Double,
        @SerializedName("attackrange") val attackrange: Double,
        @SerializedName("movespeed") val movespeed: Double,
        @SerializedName("attackdamageperlevel") val attackdamageperlevel: Double,
        @SerializedName("mpregenperlevel") val mpregenperlevel: Double,
        @SerializedName("mp") val mp: Double,
        @SerializedName("spellblockperlevel") val spellblockperlevel: Double,
        @SerializedName("crit") val crit: Double,
        @SerializedName("mpregen") val mpregen: Double,
        @SerializedName("attackspeedperlevel") val attackspeedperlevel: Double,
        @SerializedName("hpregen") val hpregen: Double,
        @SerializedName("critperlevel") val critperlevel: Double
)