package prog

import prog.Model.Flat

import java.util.{Calendar, Date}
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main extends App {
  println("Beginning of lab 5 variant 1486, scala edition\n")

  FileChecker.check(args(0))

  val start: Date = Calendar.getInstance().getTime
  val filename = args(0)
  val list = ArrayBuffer[Flat]()

  //    TODO: read data from file
  while (true) {
    print("Type your command: ")
    val command: String = StdIn.readLine()
    //    TODO: finish handle for all available commands
    Console.handler(command)
  }
}
