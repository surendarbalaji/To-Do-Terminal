import java.io.PrintWriter
import io.circe.syntax._
import io.circe.parser._
import io.circe.Json

class Writer {
  def writeToFile(args: Array[String]): Unit = {
    val source = scala.io.Source.fromFile("src/main/tasks.json")
    val existingContent = source.mkString
    source.close()

    val existingJson = parse(existingContent).getOrElse(Json.obj())

    val newJson = existingJson.deepMerge(Map(args(0) -> args(1)).asJson)

    val writer = new PrintWriter("src/main/tasks.json")
    writer.write(newJson.spaces2)
    writer.close()
    println("Success, task has been created")
  }
}
