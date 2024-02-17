class Displayer {
  def display(): Unit = {
    val fileHandler = new FileHandler
    val readJson = fileHandler.readFromFile()

    println("+--------------------------------+--------------------------------+")
    println("|              Task              |           Description          |")
    println("+--------------------------------+--------------------------------+")

    readJson.asObject.foreach { jsonObject =>
      jsonObject.toMap.foreach { case (key, value) =>
        printf("|%-32s|%-32s|\n", key, value.asString.getOrElse("Not a string"))
        println("+--------------------------------+--------------------------------+")
      }
    }
  }
}