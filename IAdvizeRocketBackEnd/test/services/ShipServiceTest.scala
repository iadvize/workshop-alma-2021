package services

import model.IAdvizeShip
import org.scalatestplus.play.PlaySpec
import org.scalamock.scalatest.MockFactory

class ShipServiceTest extends PlaySpec with MockFactory {

  "getShip" should {

    "be successful and return an star wars ship with swapi request" in {

      // Before
      val spaceXRocketService: SpaceXRocketService = mock[SpaceXRocketService]
      val swapiStarshipService: SwapiStarshipService = mock[SwapiStarshipService]
      (swapiStarshipService.getStarShip _)
        .expects("id")
        .returns(IAdvizeShip("1", "testShip", "Cruiser", 17000, "swapi"))
      val shipService: ShipService = new ShipService(spaceXRocketService, swapiStarshipService)

      val expectedOutputShip = new IAdvizeShip("1", "testShip", "Cruiser", 17000, "swapi")

      // When
      val result = shipService.getShip("swapi", "id")

      // Then
      result.equals(expectedOutputShip) mustBe true
    }

  }

}
