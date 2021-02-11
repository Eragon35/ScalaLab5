package prog.IO

import prog.{ConsoleHandler, FileChecker}
import prog.Model.{FlatReader, IdGenerator}
import prog.Main._

import java.io.{BufferedInputStream, DataInputStream, File, FileInputStream}
import scala.xml.XML

object ReadFromFile {
  /**
   * get nodes from filename
   * try to parse it to flat by calling FlatReader.fromXml
   * if it returns flat then add it to the collection
   * and also counting max id to set it to IdGenerator
   */
  def readXml(): Unit = {
    try {
      val xml = XML.loadFile(new File(filename))
      var maxId = -1
      for (flat <- xml \\ "file" \\ "flat") {
        val parsedFlat = FlatReader.fromXml(flat)
        if (parsedFlat.isDefined) {
          collection.addOne(parsedFlat.get)
          if (parsedFlat.get.id_() > maxId) maxId = parsedFlat.get.id_()
        }
      }
      IdGenerator.setId(maxId)
    } catch {
      case _: Throwable => Console.err.println("\tProblem with parsing xml file")
        println("\t" + _)
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
      case _: Throwable => Console.err.println("\tProblem with parsing file to commands")
        println("\t" + _)
    }
  }
}
