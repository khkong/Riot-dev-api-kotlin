package riot_dev_api.dto.lol_static_data_v3

import com.google.gson.annotations.SerializedName

data class ChampionDto(
        @SerializedName("info") val info: InfoDto,
        @SerializedName("stats") val stats: StatsDto,
        @SerializedName("name") val name: String,
        @SerializedName("title") val title: String,
        @SerializedName("image") val image: ImageDto,
        @SerializedName("tags") val tags: List<String>,
        @SerializedName("partype") val partype: String,
        @SerializedName("skins") val skins: List<SkinDto>,
        @SerializedName("passive") val passive: PassiveDto,
        @SerializedName("recommended") val recommended: List<RecommendedDto>,
        @SerializedName("allytips") val allytips: List<String>,
        @SerializedName("key") val key: String,
        @SerializedName("lore") val lore: String,
        @SerializedName("id") val id: Int,
        @SerializedName("blurb") val blurb: String,
        @SerializedName("spells") val spells: List<ChampionSpellDto>
)