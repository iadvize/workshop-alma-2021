package mapper

import client.SpaceXGraphQLClient.{Distance, Force, Mass, Rocket, RocketEngines, RocketFirstStage, RocketLandingLegs, RocketPayloadWeight, RocketSecondStage, RocketSecondStagePayloadCompositeFairing, RocketSecondStagePayloads}
import client.SwapiGraphQLClient.Starship
import model.IAdvizeShip

class ShipMapper {

  def mapSwapiStarshipToIAdvizeShip(swapiStarship: Starship.StarshipView): IAdvizeShip =
    IAdvizeShip(swapiStarship.id, swapiStarship.name.getOrElse(""), swapiStarship.starshipClass.getOrElse(""), swapiStarship.length.getOrElse(0), "swapi")

  def mapSwapiStarshipsToIAdvizeShips(swapiStarships: Seq[Starship.StarshipView]): Seq[IAdvizeShip] =
    swapiStarships.map(starship => mapSwapiStarshipToIAdvizeShip(starship))

  def mapSpaceXRocketToIAdvizeShip(rocket: Rocket.RocketView[
    Distance.DistanceView,
    RocketEngines.RocketEnginesView[Force.ForceView, Force.ForceView],
    RocketFirstStage.RocketFirstStageView[Force.ForceView, Force.ForceView],
    Distance.DistanceView,
    RocketLandingLegs.RocketLandingLegsView,
    Mass.MassView,
    RocketPayloadWeight.RocketPayloadWeightView,
    RocketSecondStage.RocketSecondStageView[RocketSecondStagePayloads.RocketSecondStagePayloadsView[
      RocketSecondStagePayloadCompositeFairing.RocketSecondStagePayloadCompositeFairingView[Distance.DistanceView, Distance.DistanceView]],
      Force.ForceView]
  ]): IAdvizeShip = {
    IAdvizeShip(rocket.id.getOrElse(""), rocket.name.getOrElse(""), rocket.`type`.getOrElse(""), rocket.height.get.meters.getOrElse(0), "spaceX") // TODO le premier get n'est pas safe
  }

  def mapSpaceXRocketsToIAdvizeShips(rockets: Seq[Rocket.RocketView[
    Distance.DistanceView,
    RocketEngines.RocketEnginesView[Force.ForceView, Force.ForceView],
    RocketFirstStage.RocketFirstStageView[Force.ForceView, Force.ForceView],
    Distance.DistanceView,
    RocketLandingLegs.RocketLandingLegsView,
    Mass.MassView,
    RocketPayloadWeight.RocketPayloadWeightView,
    RocketSecondStage.RocketSecondStageView[RocketSecondStagePayloads.RocketSecondStagePayloadsView[
      RocketSecondStagePayloadCompositeFairing.RocketSecondStagePayloadCompositeFairingView[Distance.DistanceView, Distance.DistanceView]],
      Force.ForceView]
  ]]): Seq[IAdvizeShip] = {
    rockets.map(rocket => mapSpaceXRocketToIAdvizeShip(rocket))
  }

}
