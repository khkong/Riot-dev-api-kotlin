package riot_dev_api.connection

import riot_dev_api.Global
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

abstract class Connection {
    open fun setLocalHost(localHost :String) {}

    fun connectAPI(api: String, reconnectCount :Int): String {
        var stream: InputStream? = null
        var streamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null
        var sb = StringBuilder()

        try {
            val url = URL(api)
            var conn = url.openConnection()
            conn as HttpsURLConnection

            val sleepSec = conn.getHeaderFieldLong("Retry-After", -1)
            if(sleepSec > -1){
                println("wait... " + sleepSec + "sec")
                Thread.sleep(sleepSec * 1000)
                conn.disconnect()
                conn = url.openConnection()
                conn as HttpsURLConnection
            }

            if (respondeCode(conn.responseCode, api, reconnectCount)) { // 200?
                //Connect to host
                conn.connect()
                stream = conn.getInputStream()
                streamReader = InputStreamReader(stream)
                bufferedReader = BufferedReader(streamReader)
                val list = bufferedReader.readLines();
                for (s in list)
                    sb.append(s)
                conn.disconnect()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (bufferedReader != null)
                bufferedReader.close()
            if (streamReader != null)
                streamReader.close()
            if (stream != null)
                stream.close()
        }

        return sb.toString()
    }

    fun respondeCode(code: Int, reconnectURL :String, reconnectCount : Int): Boolean {
        if (200 == code) {
            return true;
        }
        if (reconnectCount < Global.ConnectionState.RECONNECT_LIMIT) {
            println("CAN NOT CONNECT")
            return false
        }
        if(Global.ConnectionState.BAD_REQUEST == code){
            println("BAD_REQUEST")
            return false
        }
        if (Global.ConnectionState.UNAUTHORIZED == code) {
            println("UNAUTHORIZED")
            return false
        }
        if(Global.ConnectionState.FORBIDDEN == code){
            println("FORBIDDEN")
            return false
        }
        if(Global.ConnectionState.DATA_NOT_FOUND == code){
            println("DATA_NOT_FOUND")
            return false
        }
        if(Global.ConnectionState.METHOD_NOT_ALLOWED == code){
            println("METHOD_NOT_ALLOWED")
            return false
        }
        if(Global.ConnectionState.UNSUPPORTED_MEDIA_TYPE == code){
            println("UNSUPPORTED_MEDIA_TYPE")
            return false
        }
        if(Global.ConnectionState.RATE_LIMIT_EXCEEDED == code){
            println("RATE_LIMIT_EXCEEDED")
            return false
        }
        if(Global.ConnectionState.INTERNAL_SERVER_ERROR == code){
            println("INTERNAL_SERVER_ERROR")
            return false
        }
        if(Global.ConnectionState.BAD_GATEWAY == code){
            println("BAD_GATEWAY")
            return false
        }
        if(Global.ConnectionState.SERVIVCE_UNAVAILABLE == code){
            println("SERVIVCE_UNAVAILABLE")
            return false
        }
        if(Global.ConnectionState.GATEWAY_TIMEOUT == code){
            println("GATEWAY_TIMEOUT")
            connectAPI(reconnectURL,reconnectCount+1)
            return false
        }
        println("FALSE, code number : ${code}")
        return false
    }


}