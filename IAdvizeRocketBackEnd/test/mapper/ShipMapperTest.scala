package mapper

import client.SwapiGraphQLClient.Starship.StarshipView
import model.IAdvizeShip
import org.scalatestplus.play.PlaySpec

class ShipMapperTest extends PlaySpec {

  "mapSwapiStarshipToIAdvizeShip" should {

    "be successful and return an IAdvize Ship" in {

      // Before
      val shipMapper: ShipMapper = new ShipMapper()

      val inputStarShipView = StarshipView("1", Some("testShip"), Some("Cruiser"), Some(17000))

      val expectedOutputShip = new IAdvizeShip("1", "testShip", "Cruiser", 17000, "swapi")

      // When
      val result: IAdvizeShip = shipMapper.mapSwapiStarshipToIAdvizeShip(inputStarShipView)

      // Then
      result.equals(expectedOutputShip) mustBe true
    }

  }

}
