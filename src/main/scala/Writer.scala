import io.circe.syntax._

class Writer {
  def writeToFile(args: Array[String]): Unit = {

    if (args.length == 0) {
      println("Please enter a task to create")
      return
    }

    var task = ""
    var description = ""
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    if (args.length == 1) {task = args(0)}
    else if (args.length == 2)  {task = args(0); description = args(1)}
    else {
      println("Please surround your names and descriptions with quotes")
      return
    }

    val newJson = readJson.deepMerge(Map(task -> description.asJson).asJson)

    fileHandler.writeToFile(newJson)
    println("Success, task has been created")
  }
}