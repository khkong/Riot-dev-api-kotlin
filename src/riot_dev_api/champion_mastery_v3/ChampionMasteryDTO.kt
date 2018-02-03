package riot_dev_api.champion_mastery_v3

class ChampionMasteryDTO {
    /**
     * Is chest granted for this champion or not in current season.
     */
    var chestGranted: Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Champion level for specified player and champion combination.
     */
    var championLevel: Int? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Total number of champion points for this player and champion combination - they are used to determine championLevel.
     */
    var championPoints: Int? = null
        set(value) {
            field = value
        }
        get() = field

    /**
     * Champion ID for this entry.
     */
    var championId: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Player ID for this entry.
     */
    var playerId: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion.
     */
    var championPointsUntilNextLevel: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * The token earned for this champion to levelup.
     */
    var tokensEarned: Int? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Number of points earned since current level has been achieved.
     */
    var championPointsSinceLastLevel: Long? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Last time this champion was played by this player - in Unix milliseconds time format.
     */
    var lastPlayTime: Long? = null
        set(value) {
            field = value
        }
        get() = field

}