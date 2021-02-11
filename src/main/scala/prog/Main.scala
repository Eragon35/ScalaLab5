package prog

import prog.IO.ReadFromFile
import prog.Model.Flat

import java.util.{Calendar, Date}
import scala.collection.mutable
import scala.io.StdIn

object Main extends App {
  println("Beginning of lab 5 variant 1486, scala edition")

  if (FileChecker.check(args(0))) sys.exit()
  val start: Date = Calendar.getInstance().getTime
  val filename = args(0)
  val collection = mutable.ArrayDeque[Flat]()
  ReadFromFile.readXml()

  while (true) {
    Thread.sleep(50)
    print("\nType your command: ")
    val command: String = StdIn.readLine()
    ConsoleHandler.handler(command)
  }
}
