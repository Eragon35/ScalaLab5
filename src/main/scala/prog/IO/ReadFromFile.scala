package prog.IO

import prog.ConsoleHandler
import prog.Main.collection
import prog.Model.{FlatReader, IdGenerator}

import java.io.{BufferedInputStream, DataInputStream, File, FileInputStream}
import scala.xml.XML

object ReadFromFile {
  def readXml(fileName : String): Unit = {
    val xml = XML.loadFile(new File(fileName))
    var maxId = -1
    for (flat <- xml \\ "file" \\ "flat") {
      collection.addOne(FlatReader.fromXml(flat))
      if ((flat \ "id").text.toInt > maxId) maxId = (flat \ "id").text.toInt
    }
    IdGenerator.setId(maxId)
  }

  def readCommands (fileName: String): Unit = {
    val stream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))
    while (stream.available() != 0) {
      val line = stream.readLine()
      println(s"\n\tExecute '$line':")
      ConsoleHandler.handler(line)
    }
  }

}
