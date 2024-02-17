import io.circe._
import io.circe.syntax._

class Completer {
  def completeTask(args: Array[String]): Unit = {
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    val cursor: HCursor = readJson.hcursor
    val taskCursor: ACursor = cursor.downField(args(0))
    if (taskCursor.succeeded) {
      val newJson: Json = readJson.hcursor.downField(args(0)).delete.top.get
      fileHandler.writeToFile(newJson)
    }
    else print("Task not found")
  }
}
