object todo {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) println("Please enter a command")
    args(0).toLowerCase match {
      case "help" => println("Running help command")
      case "create" => val writer = new Writer
                        writer.writeToFile(args.drop(1))
      case "view" => val reader = new Reader
                      reader.readFromFile()

    }
  }
}
