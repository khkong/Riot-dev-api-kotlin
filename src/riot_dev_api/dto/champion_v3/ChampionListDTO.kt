package riot_dev_api.dto.champion_v3

/**
 * The collection of champion information.
 */
class ChampionListDTO {
    var champions : ArrayList<ChampionDTO>? = arrayListOf<ChampionDTO>()
        get() = field
}