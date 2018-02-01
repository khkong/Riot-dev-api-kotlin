package riot_dev_api.summoner_v3

import riot_dev_api.Data

class Summoner : Data {
    var id: String
        set(value) {
            this.id = value
        }
        get() = this.id

    var accountId: String
        set(value) {
            this.accountId = value;
        }
        get() = this.accountId

    var name: String
        set(value) {
            this.name = value;
        }
        get() = this.name

    var profileIconId: String
        set(value) {
            this.profileIconId = value;
        }
        get() = this.profileIconId

    var revisionDate: String
        set(value) {
            this.revisionDate = value;
        }
        get() = this.revisionDate

    var summonerLevel: String
        set(value) {
            this.summonerLevel = value;
        }
        get() = this.summonerLevel

}