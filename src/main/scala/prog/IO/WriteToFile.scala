package prog.IO

import prog.Model.Flat

import java.io.{File, PrintWriter}
import scala.collection.mutable

object WriteToFile {

  def writeToFile(fileName : String, collection: mutable.ArrayDeque[Flat]) : Unit = {
    val fileObject = new File(fileName) // Creating a file
    val printWriter = new PrintWriter(fileObject) // Passing reference of file to the printwriter
    printWriter.write("<file>") // Writing to the file
//    collection.foreach(x => printWriter.write(x.toXml))
    printWriter.write("</file>")
    printWriter.close()
    println("Data was written to " + fileName)
  }
}
