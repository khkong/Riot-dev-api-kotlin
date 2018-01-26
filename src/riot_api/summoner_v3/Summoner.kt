package riot_api.summoner_v3

class Summoner {
    private var id: String
        set(value) {
            this.id = value;
        }
        get() = this.id

    private var accountId: String
        set(value) {
            this.accountId = value;
        }
        get() = this.accountId

    private var name: String
        set(value) {
            this.name = value;
        }
        get() = this.name

    private var profileIconId: String
        set(value) {
            this.profileIconId = value;
        }
        get() = this.profileIconId

    private var revisionDate: String
        set(value) {
            this.revisionDate = value;
        }
        get() = this.revisionDate

    private var summonerLevel: String
        set(value) {
            this.summonerLevel = value;
        }
        get() = this.summonerLevel


    constructor()

    constructor(id: String, accountId: String, name: String, profileIconId: String, revisionDate: String, summonerLevel: String) {
        this.id = id
        this.accountId = accountId
        this.name = name
        this.profileIconId = profileIconId
        this.revisionDate = revisionDate
        this.summonerLevel = summonerLevel
    }


}