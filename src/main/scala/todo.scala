object todo {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) println("Please enter a command")
    args(0).toLowerCase match {
      case "help" => println("Running help command")
      case "create" => val writer = new Writer
                        writer.writeToFile(args.drop(1))
      case "view" => val displayer = new Displayer
                      displayer.display()
      case "complete" => val completer = new Completer
                          completer.completeTask(args.drop(1))

    }
  }
}
