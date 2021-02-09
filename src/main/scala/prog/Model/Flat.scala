package prog.Model

import prog.Model.Furnish.Furnish
import prog.Model.Transport.Transport
import prog.Model.View.View

import java.time.LocalDate
import scala.xml.{Elem, Node}

// TODO: refactor area default value
class Flat(id: Int = IdGenerator.getId, name: String, coordinates: Coordinates,
           creationDate: LocalDate = java.time.LocalDate.now, area: Float = 0, numberOfRooms : Int,
           furnish: Furnish = Furnish.NONE, view: View, transport: Transport = Transport.NONE, house: House)
//  .format(DateTimeFormatter.ofPattern("dd-MM-YYYY") i can add this to creationDate
//  for better readability but then it would be String instead of Date
{
  if (id <= 0) throw new IllegalArgumentException("id must be more than 0")
  if (name == null) throw new IllegalArgumentException("name can't be null")
  if (name.isEmpty) throw new IllegalArgumentException("name must be longer than 0")
  if (coordinates == null) throw new IllegalArgumentException("coordinates can't be null")
  if (creationDate == null) throw new IllegalArgumentException("creationDate can't be null")
//  if (area <= 0) throw new IllegalArgumentException("area must be more than 0")
  if (numberOfRooms <= 0) throw new IllegalArgumentException("numberOfRooms must be more than 0")
  if (furnish == null) throw new IllegalArgumentException("furnish can't be null")
  if (house == null) throw new IllegalArgumentException("house can't be null")


  def id_(): Int = id
  def view_(): View = view
  override def toString: String = {
    s"\tFlat {id: $id; name: $name; $coordinates; creation date: $creationDate; area: $area; " +
    s"number of rooms: $numberOfRooms; \n\t\tfurnish: $furnish; view: $view; transport: $transport; $house; hashCode: $hashCode()}"
  }

  /**
   * @return xml element that would be written to file
   */
  def toXml: Elem = {
    <flat>
      <id>{ id }</id>
      <name>{ name }</name>
      <coordinates>
        <x>{ coordinates.x() }</x>
        <y>{ coordinates.y() }</y>
      </coordinates>
      <creation-date>{ creationDate }</creation-date>
      <area>{ area }</area>  <!-- can be null-->
      <number-of-rooms>{ numberOfRooms }</number-of-rooms>
      <furnish>{ furnish }</furnish>  <!-- can be null-->
      <view>{ view }</view>
      <transport>{ transport }</transport>  <!-- can be null-->
      <house>
        <name>{ house.name() }</name>
        <year>{ house.year() }</year>
        <number-of-lifts>{ house.numberOfFloors() }</number-of-lifts>
      </house>
    </flat>
  }
}

/**
 * parse xml node
 * @return Flat object
 */
//  TODO: add validation for input
object FlatReader {
  def fromXml(node: Node): Flat = {
    val id = (node \ "id").text.toInt
    val name = (node \ "name").text
    val coordinates = new Coordinates((node \ "coordinates" \ "x").text.toLong, (node \ "coordinates" \ "y").text.toFloat)
    val creationDate = LocalDate.parse((node \ "creation-date").text)
    val area = (node \ "area").text.toFloat
    val numberOfRooms = (node \ "number-of-rooms").text.toInt
    val furnish = Furnish.withName((node \ "furnish").text)
    val view = View.withName((node \ "view").text)
    val transport = Transport.withName((node \ "transport").text)
    val house = new House((node \ "house" \ "name").text, (node \ "house" \ "year").text.toInt, (node \ "house" \ "number-of-lifts").text.toInt)

    new Flat(id, name, coordinates, creationDate, area, numberOfRooms, furnish, view, transport, house)
  }
}
