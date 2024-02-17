//import java.io.PrintWriter
//import io.circe.syntax._
import io.circe.parser._
import io.circe.Json

class Reader {
  def readFromFile(): Unit = {
    val source = scala.io.Source.fromFile("src/main/tasks.json")
    val content = source.mkString
    source.close()

    val sourceJson = parse(content).getOrElse(Json.obj())

    println("+--------------------------------+--------------------------------+")
    println("|              Task              |           Description          |")
    println("+--------------------------------+--------------------------------+")

    sourceJson.asObject.foreach { jsonObject =>
      jsonObject.toMap.foreach { case (key, value) =>
        printf("|%-32s|%-32s|\n", key, value.asString.getOrElse("Not a string"))
        println("+--------------------------------+--------------------------------+")
      }
    }
  }
}
