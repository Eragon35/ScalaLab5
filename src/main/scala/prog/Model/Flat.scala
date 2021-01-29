package prog.Model

import prog.Model.Furnish.Furnish
import prog.Model.Transport.Transport
import prog.Model.View.View

import java.util.{Calendar, Date}

class Flat(name: String, coordinates: Coordinates, area: Float, numberOfRooms : Int,
           furnish: Furnish, view: View, transport: Transport, house: House){
  val id: Int = IdGenerator.getId
  val creationDate: Date = Calendar.getInstance().getTime // Fri Jan 08 01:39:17 MSK 2021
  if (id <= 0) throw new IllegalArgumentException("id must be more than 0")
  if (name == null) throw new IllegalArgumentException("name can't be null")
  if (name.isEmpty) throw new IllegalArgumentException("name must be longer than 0")
  if (coordinates == null) throw new IllegalArgumentException("coordinates can't be null")
  if (creationDate == null) throw new IllegalArgumentException("creationDate can't be null")
  if (area <= 0) throw new IllegalArgumentException("area must be more than 0")
  if (numberOfRooms <= 0) throw new IllegalArgumentException("numberOfRooms must be more than 0")
  if (furnish == null) throw new IllegalArgumentException("furnish can't be null")
  if (house == null) throw new IllegalArgumentException("house can't be null")


//  TODO: finish toString
  override def toString: String = {
    val checkNulls = checkingNulls()
    "Flat - " +
    "id: " + id +
    ", name: " + name +
    ", " + coordinates.toString +
    ", creation date: " + creationDate +
    ", area: " + area +
    ", number of rooms: " + numberOfRooms +
    ", furnish: " + furnish +
    checkNulls +
    ", " + house.toString
  }

  def checkingNulls(): String = {
    var result = ""
    if (view != null) result += ", view:" + view
    if( transport != null) result += ", transport: " + transport
    result
  }
}
