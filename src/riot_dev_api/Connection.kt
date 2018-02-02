package riot_dev_api

abstract class Connection {

    abstract fun connectAPI(url : String): Data

    fun respondeCode(code: Int): Boolean {
        if(200 == code){
            println("OK")
            return true;
        }
        if(GlobalState.BAD_REQUEST == code){
            println("BAD_REQUEST")
            return false
        }
        if(GlobalState.UBAUTHORIZED == code){
            println("UBAUTHORIZED")
            return false
        }
        if(GlobalState.FORBIDDEN == code){
            println("FORBIDDEN")
            return false
        }
        if(GlobalState.DATA_NOT_FOUND == code){
            println("DATA_NOT_FOUND")
            return false
        }
        if(GlobalState.METHOD_NOT_ALLOWED == code){
            println("METHOD_NOT_ALLOWED")
            return false
        }
        if(GlobalState.UNSUPPORTED_MEDIA_TYPE == code){
            println("UNSUPPORTED_MEDIA_TYPE")
            return false
        }
        if(GlobalState.RATE_LIMIT_EXCEEDED == code){
            println("RATE_LIMIT_EXCEEDED")
            return false
        }
        if(GlobalState.INTERNAL_SERVER_ERROR == code){
            println("INTERNAL_SERVER_ERROR")
            return false
        }
        if(GlobalState.BAD_GATEWAY == code){
            println("BAD_GATEWAY")
            return false
        }
        if(GlobalState.SERVIVCE_UNAVAILABLE == code){
            println("SERVIVCE_UNAVAILABLE")
            return false
        }
        if(GlobalState.GATEWAY_TIMEOUT == code){
            println("GATEWAY_TIMEOUT")
            return false
        }
        return true
    }
}