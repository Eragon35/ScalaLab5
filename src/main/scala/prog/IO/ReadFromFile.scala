package prog.IO

import prog.{ConsoleHandler, FileChecker}
import prog.Model.FlatReader
import prog.Main._

import java.io.{BufferedInputStream, DataInputStream, File, FileInputStream}
import scala.xml.XML

object ReadFromFile {
  /**
   * get nodes from filename
   * try to parse it to flat by calling FlatReader.fromXml
   * if it returns flat then add it to the collection
   */
  def readXml(): Unit = {
    try {
      val xml = XML.loadFile(new File(filename))
      for (flat <- xml \\ "file" \\ "flat") {
        FlatReader.fromXml(flat) match {
          case Some(i) => collection.addOne(i)
        }
      }
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing xml file\n\t" + e.getMessage)
    }
  }

  /**
   * @param fileName
   * just read lines from fileName and send it to ConsoleHandler
   */
  def readCommands (fileName: String): Unit = {
    if (FileChecker.check(fileName, full = false)) return
    try {
      val stream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))
      while (stream.available() != 0) {
        val line = stream.readLine()
        println(s"\n\tExecute '$line':")
        ConsoleHandler.handler(line)
      }
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file to commands\n\t" + e.getMessage)
    }
  }
}
