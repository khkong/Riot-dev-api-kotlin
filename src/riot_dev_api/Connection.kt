package riot_dev_api

import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

abstract class Connection {

    fun connectAPI(api: String): String {
        var stream: InputStream? = null
        var streamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null
        var sb = StringBuilder()

        try {
            var url = URL(api)
            var conn = url.openConnection()
            conn as HttpsURLConnection
            if (respondeCode(conn.responseCode)) { // 200?
                //Connect to host
                conn.connect()
                stream = conn.getInputStream()
                streamReader = InputStreamReader(stream)
                bufferedReader = BufferedReader(streamReader)

                var list = bufferedReader.readLines();
                for (s in list)
                    sb.append(s)
            } else {
                println(api)
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
        var parser = JsonParser()
        var json = sb.toString()
        return sb.toString()
    }

    fun respondeCode(code: Int): Boolean {
        if(200 == code){
//            println("OK")
            return true;
        }
        if(GlobalState.BAD_REQUEST == code){
            println("BAD_REQUEST")
            return false
        }
        if (GlobalState.UNAUTHORIZED == code) {
            println("UNAUTHORIZED")
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
        println("FALSE, code number : " + code)
        return false
    }
}