import io.circe._

class Remover {
  def removeTask(args: Array[String]): Unit = {
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    val cursor: HCursor = readJson.hcursor
    val activeTaskCursor: ACursor = cursor.downField("activeTasks").downField(args(0))
    val completedTaskCursor: ACursor = cursor.downField("completedTasks").downField(args(0))

    if (activeTaskCursor.succeeded) {
      val newJson: Json = cursor.downField("activeTasks").downField(args(0)).delete.top.get
      fileHandler.writeToFile(newJson)
    }
    else if (completedTaskCursor.succeeded) {
      val newJson: Json = cursor.downField("completedTasks").downField(args(0)).delete.top.get
      fileHandler.writeToFile(newJson)
    }
    else {
      print("Task not found")
    }
  }
}
