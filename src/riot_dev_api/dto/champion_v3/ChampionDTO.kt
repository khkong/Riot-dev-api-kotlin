package riot_dev_api.dto.champion_v3

class ChampionDTO {
    /**
     * Ranked play enabled flag.
     */
    var rankedPlayEnabled : Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Bot enabled flag (for custom games).
     */
    var botEnabled : Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Bot Match Made enabled flag (for Co-op vs. AI games).
     */
    var botMmEnabled : Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Indicates if the champion is active.
     */
    var active : Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Indicates if the champion is free to play. Free to play champions are rotated periodically.
     */
    var freeToPlay : Boolean? = null
        set(value) {
            field = value
        }
        get() = field
    /**
     * Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API.
     */
    var id : Long? = null
        set(value) {
            field = value
        }
        get() = field

}