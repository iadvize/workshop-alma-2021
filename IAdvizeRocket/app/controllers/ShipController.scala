package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import services.ShipService

import scala.concurrent.ExecutionContext

@Singleton
class ShipController @Inject()(cc: ControllerComponents, shipService: ShipService)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  def ship(from: String, shipId: String) = Action {
    Ok(Json.toJson(shipService.getShip(from, shipId)))
  }

  def ships() = Action {
    Ok(Json.toJson(shipService.getShips()))
  }

}
