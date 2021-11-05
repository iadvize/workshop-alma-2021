package services

import caliban.client.SelectionBuilder
import clients.SwapiGraphQLClient.Root.{allStarships, starship}
import clients.SwapiGraphQLClient._
import mappers.ShipMapper
import models.IAdvizeShip
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
    // TODO ISSUE 2 Handle exceptions when communication error or empty result -> discover pattern matching
    val swapiStarship = response.body match {
      case Right(value) => value.get
    }
    mapper.mapSwapiStarshipToIAdvizeShip(swapiStarship)
  }

  def getStarShips(): Seq[IAdvizeShip] = {

    val query = allStarships()(swapiAllStarshipsView)
    val response = HttpURLConnectionBackend().send(query.toRequest(serverUrl))
    // TODO ISSUE 2 Handle exceptions when communication error or empty result -> discover pattern matching
    val swapiStarship = response.body match {
      case Right(Some(value)) => value.get
    }
    mapper.mapSwapiStarshipsToIAdvizeShips(swapiStarship.flatten)
  }
}
