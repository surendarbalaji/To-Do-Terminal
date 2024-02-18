import io.circe.Json
import io.circe.parser.parse
import java.io.PrintWriter

class FileHandler {
  def readFromFile(): Json = {
    val source = scala.io.Source.fromFile("src/main/tasks.json")
    val existingContent = source.mkString
    source.close()

    parse(existingContent).getOrElse(Json.obj())
  }

  def writeToFile(newJson: Json): Unit = {
    val writer = new PrintWriter("src/main/tasks.json")
    writer.write(newJson.spaces2)
    writer.close()
  }
}
