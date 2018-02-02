package riot_dev_api.summoner_v3

import riot_dev_api.Data

class SummonerDTO : Data {
    var id: String? = null
        set(value) {
            field = value
        }
        get() = field

    var accountId: String? = null
        set(value) {
            field = value
        }
        get() = field

    var name: String? = null
        set(value) {
            field = value
        }
        get() = field

    var profileIconId: String? = null
        set(value) {
            field = value
        }
        get() = field

    var revisionDate: String? = null
        set(value) {
            field = value
        }
        get() = field

    var summonerLevel: String? = null
        set(value) {
            field = value
        }
        get() = field

}