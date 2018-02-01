package riot_dev_api

abstract class Connection {
    abstract fun connectAPI(url : String): Data
    fun respondeCode(code: Int): Boolean {
        if(ConnectionState.BAD_REQUEST == code){
            println("BAD_REQUEST")
            return false
        }
        if(ConnectionState.UBAUTHORIZED == code){
            println("UBAUTHORIZED")
            return false
        }
        if(ConnectionState.FORBIDDEN == code){
            println("FORBIDDEN")
            return false
        }
        if(ConnectionState.DATA_NOT_FOUND == code){
            println("DATA_NOT_FOUND")
            return false
        }
        if(ConnectionState.METHOD_NOT_ALLOWED == code){
            println("METHOD_NOT_ALLOWED")
            return false
        }
        if(ConnectionState.UNSUPPORTED_MEDIA_TYPE == code){
            println("UNSUPPORTED_MEDIA_TYPE")
            return false
        }
        if(ConnectionState.RATE_LIMIT_EXCEEDED == code){
            println("RATE_LIMIT_EXCEEDED")
            return false
        }
        if(ConnectionState.INTERNAL_SERVER_ERROR == code){
            println("INTERNAL_SERVER_ERROR")
            return false
        }
        if(ConnectionState.BAD_GATEWAY == code){
            println("BAD_GATEWAY")
            return false
        }
        if(ConnectionState.SERVIVCE_UNAVAILABLE == code){
            println("SERVIVCE_UNAVAILABLE")
            return false
        }
        if(ConnectionState.GATEWAY_TIMEOUT == code){
            println("GATEWAY_TIMEOUT")
            return false
        }
        return true
    }
}