package mappers

import clients.SpaceXGraphQLClient.Distance.DistanceView
import clients.SpaceXGraphQLClient.{Distance, Force, Mass, Rocket, RocketEngines, RocketFirstStage, RocketLandingLegs, RocketPayloadWeight, RocketSecondStage, RocketSecondStagePayloadCompositeFairing, RocketSecondStagePayloads}
import clients.SwapiGraphQLClient.Starship
import models.IAdvizeShip

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
    val height = rocket.height.getOrElse(DistanceView(Some(0), Some(0)))
    IAdvizeShip(rocket.id.getOrElse(""), rocket.name.getOrElse(""), rocket.`type`.getOrElse(""), height.meters.getOrElse(0), "spaceX")
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
