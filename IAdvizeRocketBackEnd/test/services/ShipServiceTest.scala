package services

import models.IAdvizeShip
import org.scalatestplus.play.PlaySpec
import org.scalamock.scalatest.MockFactory
import scala.util.{Failure, Success, Try}

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

    "be successful and return an spaceX rocket with spaceX request" in {

      // Before
      val spaceXRocketService: SpaceXRocketService = mock[SpaceXRocketService]
      (spaceXRocketService.getRocket _)
        .expects("id")
        .returns(IAdvizeShip("1", "testRocket", "Appolo", 17000, "spaceX"))
      val swapiStarshipService: SwapiStarshipService = mock[SwapiStarshipService]
      val shipService: ShipService = new ShipService(spaceXRocketService, swapiStarshipService)

      val expectedOutputShip = new IAdvizeShip("1", "testRocket", "Appolo", 17000, "spaceX")

      // When
      val result = shipService.getShip("spaceX", "id")

      // Then
      result.equals(expectedOutputShip) mustBe true
    }

    "return an error when requested ship provider does not exist" in {

      // Before
      val spaceXRocketService: SpaceXRocketService = mock[SpaceXRocketService]
      val swapiStarshipService: SwapiStarshipService = mock[SwapiStarshipService]
      val shipService: ShipService = new ShipService(spaceXRocketService, swapiStarshipService)


      // When
      val result = Try(
        shipService.getShip("tesla", "id")
      )

      // Then
      result match {
        case Failure(e) => e mustBe a[UnsupportedOperationException]
        case Success(v) => fail(s"Expected the test to fail but got $v instead")
      }

    }
  }
}
