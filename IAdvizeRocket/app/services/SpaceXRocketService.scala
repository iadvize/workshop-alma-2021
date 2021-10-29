package services

import caliban.client.SelectionBuilder
import client.SpaceXGraphQLClient._
import mapper.ShipMapper
import model.IAdvizeShip
import sttp.client3.UriContext

import javax.inject.Inject
import sttp.client3._

class SpaceXRocketService @Inject()(mapper: ShipMapper) {

  val serverUrl = uri"https://api.spacex.land/graphql"

  val spaceXRocketView: SelectionBuilder[Rocket, Rocket.RocketView[
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
  ]] = {
    Rocket.view(Distance.view,
      RocketEngines.view(Force.view, Force.view),
      RocketFirstStage.view(Force.view, Force.view),
      Distance.view,
      RocketLandingLegs.view,
      Mass.view,
      RocketPayloadWeight.view,
      RocketSecondStage.view(RocketSecondStagePayloads.view(RocketSecondStagePayloadCompositeFairing.view(Distance.view, Distance.view)), Force.view)
    )
  }

  def getRocket(id: String): IAdvizeShip = {

    val query = Query.rocket(id)(spaceXRocketView)
    val response = HttpURLConnectionBackend().send(query.toRequest(serverUrl))
    // TODO ISSUE 2 Handle exceptions when communication error or empty result -> discover pattern matching
    val spaceXRocket = response.body match {
      case Right(value) => value.get
      case Left(exception) => throw new RuntimeException(s"there is an error with spacex response. error : $exception")
    }
    mapper.mapSpaceXRocketToIAdvizeShip(spaceXRocket)
  }

  def getRockets(): Seq[IAdvizeShip] = {

    val query = Query.rockets()(spaceXRocketView)
    val response = HttpURLConnectionBackend().send(query.toRequest(serverUrl))
    val spaceXRockets = response.body match {
      case Right(value) => value.get
      case Left(exception) => throw new RuntimeException(s"there is an error with spacex response. error : $exception")

    }
    mapper.mapSpaceXRocketsToIAdvizeShips(spaceXRockets.flatten)
  }
}
