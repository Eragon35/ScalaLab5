package prog.IO

import prog.{ConsoleHandler, FileChecker}
import prog.Model.{FlatReader, IdGenerator}
import prog.Main._

import java.io.{BufferedInputStream, DataInputStream, File, FileInputStream}
import scala.xml.XML

object ReadFromFile {
  def readXml(): Unit = {
    try {
      val xml = XML.loadFile(new File(filename))
      var maxId = -1
      for (flat <- xml \\ "file" \\ "flat") {
        FlatReader.fromXml(flat)
        if ((flat \ "id").text.toInt > maxId) maxId = (flat \ "id").text.toInt
      }
      IdGenerator.setId(maxId)
    } catch {
      case _: Throwable => Console.err.println("\tProblem with parsing xml file")
        println("\t" + _)
    }
  }

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
