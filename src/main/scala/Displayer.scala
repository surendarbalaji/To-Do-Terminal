class Displayer {
  def display(): Unit = {
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    println("+--------------------------------+--------------------------------+")
    println("|              Task              |           Description          |")
    println("+--------------------------------+--------------------------------+")

    readJson.asObject.foreach { jsonObject =>
      jsonObject.toMap.foreach { case (key, value) =>
        if (key == "activeTasks") {
          value.asObject.foreach { activeTasks =>
            activeTasks.toMap.foreach { case (task, description) =>
              printf("|%-32s|%-32s|\n", "[ ] " + task, description.asString.getOrElse("Not a string"))
              println("+--------------------------------+--------------------------------+")}
          }
        }
        else
          value.asObject.foreach { completedTasks =>
            completedTasks.toMap.foreach { case (task, description) =>
              printf("|%-32s|%-32s|\n", "[x] " + task, description.asString.getOrElse(""))
              println("+--------------------------------+--------------------------------+")}
          }
      }
    }
  }
}