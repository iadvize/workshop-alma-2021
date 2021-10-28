package model

import play.api.libs.json.{Json, Writes}

// TODO ISSUE 1 : complete the model to enrich our local spaceship view -> discover case classes
case class IAdvizeShip(id: String, name: String, model: String, height: Double, from: String)

object IAdvizeShip {
  implicit val jsonWrites: Writes[IAdvizeShip] = Json.writes[IAdvizeShip]
}
