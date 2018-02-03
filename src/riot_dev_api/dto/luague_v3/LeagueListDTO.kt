package riot_dev_api.dto.luague_v3

class LeagueListDTO {
    //    leagueId	string
    //    tier	string
    //    entries	List[LeagueItemDTO]
    //    queue	string
    //    name	string
    var leagueId : String? = null
        set(value) {
            field = value
        }
        get() = field

    var tier : String? = null
        set(value) {
            field = value
        }
        get() = field

    var entries : ArrayList<LeagueItemDTO> = arrayListOf<LeagueItemDTO>()
        get() = field

    var queue : String? = null
        set(value) {
            field = value
        }
        get() = field

    var name : String? = null
        set(value) {
            field = value
        }
        get() = field
}