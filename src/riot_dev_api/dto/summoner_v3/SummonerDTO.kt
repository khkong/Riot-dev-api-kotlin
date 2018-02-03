package riot_dev_api.dto.summoner_v3

class SummonerDTO {
    /**
     * Summoner ID.
     */
    var id: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Account ID.
     */
    var accountId: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Summoner name.
     */
    var name: String? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * ID of the summoner icon associated with the summoner.
     */
    var profileIconId: Int? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Date summoner was last modified specified as epoch milliseconds.
     * The following events will update this timestamp:
     * profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change
     */
    var revisionDate: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Summoner level associated with the summoner.
     */
    var summonerLevel: Long? = null
        set(value) {
            field = value
        }
        get() = field

}