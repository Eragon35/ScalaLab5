package prog

object Console {
  def handler(line: String) {
//    TODO: split line to command and object
    val word = """^([\w\-]+)""".r
    val command: String = line.trim.replaceAll("\\s\\s", " ").split(" ")(0)
    command.trim match {
      case "help" => println(help)
      case "info" => println("Type of collection is: " + Main.list.getClass + "\n" +
        "Initialization time is: " + Main.start.toString + "\n" +
        "Collection size is: " + Main.list.size + "\n" +
        "Collection hash-code is: " + Main.list.hashCode())
      case "show" => if (Main.list.isEmpty) println("Collection is empty")
      else Main.list.foreach(f => println(f))
      case "exit" => sys.exit()
      case _ => throw new IllegalArgumentException("You write wrong command")
    }
  }

  private val help: String =
    """help : вывести справку по доступным командам
      |info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
      |show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
      |add {element} : добавить новый элемент в коллекцию
      |update id {element} : обновить значение элемента коллекции, id которого равен заданному
      |remove_by_id id : удалить элемент из коллекции по его id
      |clear : очистить коллекцию
      |save : сохранить коллекцию в файл
      |execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
      |exit : завершить программу (без сохранения в файл)
      |remove_first : удалить первый элемент из коллекции
      |head : вывести первый элемент коллекции
      |add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
      |average_of_number_of_rooms : вывести среднее значение поля numberOfRooms для всех элементов коллекции
      |min_by_number_of_rooms : вывести любой объект из коллекции, значение поля numberOfRooms которого является минимальным
      |print_field_descending_view : вывести значения поля view всех элементов в порядке убывания""".stripMargin

}
