package prog

import prog.Model.Flat

import java.nio.file.{Files, Path, Paths}
import java.util.{Calendar, Date}
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main extends App {
  println("Begining of lab 5 variant 1486, scala edition" +
    "\nbut with ArrayBuffer instead of linkedList 'cause it's deprecated in scala since v2.11\n")
  FileChecker.check(args(0))

  val start: Date = Calendar.getInstance().getTime
  val filename = args(0)
  val list = ArrayBuffer[Flat]()

  //    TODO: read data from file
  while (true) {
    print("Type your command: ")
    val command: String = StdIn.readLine()
    Console.handler(command)
  }
}
