package services

import model.IAdvizeShip

import javax.inject.Inject

class ShipService @Inject()(spaceXRocketService: SpaceXRocketService, swapiStarshipService: SwapiStarshipService) {

  def getShip(from: String, id: String): IAdvizeShip = {
    from match {
      case "spaceX" => spaceXRocketService.getRocket(id)
      case "swapi" => swapiStarshipService.getStarShip(id)
      case str: String => throw new UnsupportedOperationException(s"$str content is not yet supported")
    }
  }

  def getShips: Seq[IAdvizeShip] = {
    spaceXRocketService.getRockets() ++ swapiStarshipService.getStarShips()
  }
}
