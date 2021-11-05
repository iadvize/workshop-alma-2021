package services

import caliban.client.SelectionBuilder
import client.SwapiGraphQLClient.Root.{allStarships, starship}
import client.SwapiGraphQLClient._
import mapper.ShipMapper
import model.IAdvizeShip
import sttp.client3._

import javax.inject.Inject

class SwapiStarshipService @Inject()(mapper: ShipMapper) {

  val serverUrl = uri"https://swapi-graphql.netlify.app/.netlify/functions/index"

  val swapiStarshipView: SelectionBuilder[Starship, Starship.StarshipView] = {
    (Starship.id ~ Starship.name ~ Starship.starshipClass ~ Starship.length).mapN(Starship.StarshipView)
  }

  val swapiAllStarshipsView: SelectionBuilder[StarshipsConnection, Option[List[Option[Starship.StarshipView]]]] = {
    StarshipsConnection.starships(swapiStarshipView)
  }

  def getStarShip(id: String): IAdvizeShip = {

    val query = starship(Some(id))(swapiStarshipView)
    val response = HttpURLConnectionBackend().send(query.toRequest(serverUrl))
    val swapiStarship = response.body match {
      case Right(value) => value.get
      case Left(exception) => throw new RuntimeException(s"there is an error with swapi response. error : $exception")
    }
    mapper.mapSwapiStarshipToIAdvizeShip(swapiStarship)
  }

  def getStarShips(): Seq[IAdvizeShip] = {

    val query = allStarships()(swapiAllStarshipsView)
    val response = HttpURLConnectionBackend().send(query.toRequest(serverUrl))
    val swapiStarship = response.body match {
      case Right(Some(value)) => value.get
      case Left(exception) => throw new RuntimeException(s"there is an error with swapi response. error : $exception")
    }
    mapper.mapSwapiStarshipsToIAdvizeShips(swapiStarship.flatten)
  }
}
