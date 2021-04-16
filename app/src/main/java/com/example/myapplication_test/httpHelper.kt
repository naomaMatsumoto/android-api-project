package com.example.myapplication_test

import android.os.AsyncTask
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class HitAPITask: AsyncTask<String, String, String>(){

        override fun doInBackground(vararg params: String?): String {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection

                // methodを決定している
                connection.requestMethod = "POST"
//                connection.requestMethod = params[1]
                connection.doOutput = true
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8")

                println(params[2])
                val bodyData = params[2]!!.toByteArray()
                    connection.setChunkedStreamingMode(bodyData.size)
//                val outputStream = connection.outputStream
//                val outputStream: OutputStream = connection.outputStream

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。
                try {
                    val outputStream: OutputStream = connection.outputStream
                    outputStream.write(bodyData)
                    outputStream.flush()
                    outputStream.close()
                } catch (e: java.lang.Exception) {
                    println(e)
                }

                try {
                    //ステップ4:コネクションを開く
                    connection.connect()
                } catch (e: Exception) {
                    println(e)
                }


                val statusCode = connection.responseCode
                if (statusCode == HttpURLConnection.HTTP_OK) {
//                    readStream(connection.inputStream)
                }


                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()
                return jsonText;
                //JSONObjectを使って、まず全体のJSONObjectを取ります。
//                val parentJsonObj = JSONObject(jsonText)
//
//                return parentJsonObj;

                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
//                val parentJsonArray = parentJsonObj.getJSONArray("movies")
//
//                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
//                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得
//
//                //moviesの0番目のデータのtitle項目をStringで取ります。これで中身を取れました。
//                val movieName: String = detailJsonObj.getString("title")  // => Your Name.
//                //公開年を取りたい時も同じようにすれば良いです。
//                val year: Int = detailJsonObj.getInt("year")  // => 2016
//
//                //Stringでreturnしてあげましょう。
//                return "$movieName - $year"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
//                return {}
            } catch (e: IOException) {
                e.printStackTrace()
//                return ""
            } catch (e: JSONException) {
                e.printStackTrace()
//                return ""
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return ""
        }
    }
//}