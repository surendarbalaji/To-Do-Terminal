import io.circe._
import io.circe.syntax._

class Completer {
  def completeTask(args: Array[String]): Unit = {
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    val cursor: HCursor = readJson.hcursor
    val taskCursor: ACursor = cursor.downField("activeTasks").downField(args(0))
    if (taskCursor.succeeded) {
      val description = taskCursor.as[String].getOrElse("")
      val updatedJson: Json = cursor.downField("activeTasks").downField(args(0)).delete.top.get
      val newJson = updatedJson.hcursor.downField("completedTasks").withFocus(_.mapObject(_.add(args(0), description.asJson))).top.get
      fileHandler.writeToFile(newJson)
    }
    else print("Task not found")
  }
}
