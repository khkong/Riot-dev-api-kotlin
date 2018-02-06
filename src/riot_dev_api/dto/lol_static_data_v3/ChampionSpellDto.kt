package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class ChampionSpellDto(
        @SerializedName("cooldownBurn") val cooldownBurn: String,
        @SerializedName("resource") val resource: String,
        @SerializedName("leveltip") val leveltip: LevelTipDto,
        @SerializedName("vars") val vars: List<SpellVarsDto>,
        @SerializedName("costType") val costType: String,
        @SerializedName("image") val image: ImageDto,
        @SerializedName("sanitizedDescription") val sanitizedDescription: String,
        @SerializedName("sanitizedTooltip") val sanitizedTooltip: String,
        @SerializedName("effect") val effect: List<Object>,//	This field is a List of List of Double.
        @SerializedName("tooltip") val tooltip: String,
        @SerializedName("maxrank") val maxrank: Int,
        @SerializedName("costBurn") val costBurn: String,
        @SerializedName("rangeBurn") val rangeBurn: String,
        @SerializedName("range") val range: Object,  //This field is either a List of Integer or the String 'self' for spells that target one's own champion.
        @SerializedName("cooldown") val cooldown: List<Double>,
        @SerializedName("cost") val cost: List<Int>,
        @SerializedName("key") val key: String,
        @SerializedName("description") val description: String,
        @SerializedName("effectBurn") val effectBurn: List<String>,
        @SerializedName("altimages") val altimages: List<ImageDto>,
        @SerializedName("name") val name: String
)