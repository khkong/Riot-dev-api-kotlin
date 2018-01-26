package riot_api.connection

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class Connection {

    public fun getHttps(urlString: String): String {
        var retStr = ""
        var stream: InputStream? = null
        var streamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null

        try {
            var url = URL(urlString)
            var conn = url.openConnection()

            //Connect to host
            conn.connect()
            stream = conn.getInputStream()
            streamReader = InputStreamReader(stream)
            bufferedReader = BufferedReader(streamReader)

            var line: String? = null
            do {
                line = bufferedReader.readLine()
                if (line != null)
                    retStr += line;
            } while (line != null)

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

        return retStr
    }
}