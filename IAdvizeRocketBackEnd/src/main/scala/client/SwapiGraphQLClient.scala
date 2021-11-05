package client

import caliban.client.FieldBuilder._
import caliban.client._

object SwapiGraphQLClient {

  type ID = String

  type FilmsConnection
  object FilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmsEdge, A]
    ): SelectionBuilder[FilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[FilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PageInfo
  object PageInfo {

    /** When paginating forwards, are there more items?
      */
    def hasNextPage: SelectionBuilder[PageInfo, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("hasNextPage", Scalar())

    /** When paginating backwards, are there more items?
      */
    def hasPreviousPage: SelectionBuilder[PageInfo, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("hasPreviousPage", Scalar())

    /** When paginating backwards, the cursor to continue.
      */
    def startCursor: SelectionBuilder[PageInfo, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("startCursor", OptionOf(Scalar()))

    /** When paginating forwards, the cursor to continue.
      */
    def endCursor: SelectionBuilder[PageInfo, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("endCursor", OptionOf(Scalar()))
  }

  type FilmsEdge
  object FilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[FilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Film
  object Film {

    /** The title of this film.
      */
    def title: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("title", OptionOf(Scalar()))

    /** The episode number of this film.
      */
    def episodeID: SelectionBuilder[Film, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("episodeID", OptionOf(Scalar()))

    /** The opening paragraphs at the beginning of this film.
      */
    def openingCrawl: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("openingCrawl", OptionOf(Scalar()))

    /** The name of the director of this film.
      */
    def director: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("director", OptionOf(Scalar()))

    /** The name(s) of the producer(s) of this film.
      */
    def producers: SelectionBuilder[Film, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("producers", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The ISO 8601 date format of film release at original creator country.
      */
    def releaseDate: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("releaseDate", OptionOf(Scalar()))
    def speciesConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmSpeciesConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Film, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "speciesConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def starshipConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmStarshipsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Film, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "starshipConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def vehicleConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmVehiclesConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Film, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "vehicleConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def characterConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmCharactersConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Film, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "characterConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def planetConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmPlanetsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Film, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "planetConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Film, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Film, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type FilmSpeciesConnection
  object FilmSpeciesConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmSpeciesConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmSpeciesEdge, A]
    ): SelectionBuilder[FilmSpeciesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmSpeciesConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def species[A](
        innerSelection: SelectionBuilder[Species, A]
    ): SelectionBuilder[FilmSpeciesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("species", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type FilmSpeciesEdge
  object FilmSpeciesEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Species, A]
    ): SelectionBuilder[FilmSpeciesEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmSpeciesEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Species
  object Species {

    /** The name of this species.
      */
    def name: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))

    /** The classification of this species, such as "mammal" or "reptile".
      */
    def classification: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("classification", OptionOf(Scalar()))

    /** The designation of this species, such as "sentient".
      */
    def designation: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("designation", OptionOf(Scalar()))

    /** The average height of this species in centimeters.
      */
    def averageHeight: SelectionBuilder[Species, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("averageHeight", OptionOf(Scalar()))

    /** The average lifespan of this species in years, null if unknown.
      */
    def averageLifespan: SelectionBuilder[Species, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("averageLifespan", OptionOf(Scalar()))

    /** Common eye colors for this species, null if this species does not typically
      * have eyes.
      */
    def eyeColors: SelectionBuilder[Species, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("eyeColors", OptionOf(ListOf(OptionOf(Scalar()))))

    /** Common hair colors for this species, null if this species does not typically
      * have hair.
      */
    def hairColors: SelectionBuilder[Species, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("hairColors", OptionOf(ListOf(OptionOf(Scalar()))))

    /** Common skin colors for this species, null if this species does not typically
      * have skin.
      */
    def skinColors: SelectionBuilder[Species, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("skinColors", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The language commonly spoken by this species.
      */
    def language: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("language", OptionOf(Scalar()))

    /** A planet that this species originates from.
      */
    def homeworld[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[Species, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("homeworld", OptionOf(Obj(innerSelection)))
    def personConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[SpeciesPeopleConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Species, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "personConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def filmConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[SpeciesFilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Species, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "filmConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Species, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Species, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type Planet
  object Planet {

    /** The name of this planet.
      */
    def name: SelectionBuilder[Planet, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))

    /** The diameter of this planet in kilometers.
      */
    def diameter: SelectionBuilder[Planet, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("diameter", OptionOf(Scalar()))

    /** The number of standard hours it takes for this planet to complete a single
      * rotation on its axis.
      */
    def rotationPeriod: SelectionBuilder[Planet, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rotationPeriod", OptionOf(Scalar()))

    /** The number of standard days it takes for this planet to complete a single orbit
      * of its local star.
      */
    def orbitalPeriod: SelectionBuilder[Planet, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("orbitalPeriod", OptionOf(Scalar()))

    /** A number denoting the gravity of this planet, where "1" is normal or 1 standard
      * G. "2" is twice or 2 standard Gs. "0.5" is half or 0.5 standard Gs.
      */
    def gravity: SelectionBuilder[Planet, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("gravity", OptionOf(Scalar()))

    /** The average population of sentient beings inhabiting this planet.
      */
    def population: SelectionBuilder[Planet, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("population", OptionOf(Scalar()))

    /** The climates of this planet.
      */
    def climates: SelectionBuilder[Planet, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("climates", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The terrains of this planet.
      */
    def terrains: SelectionBuilder[Planet, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("terrains", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The percentage of the planet surface that is naturally occurring water or bodies
      * of water.
      */
    def surfaceWater: SelectionBuilder[Planet, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("surfaceWater", OptionOf(Scalar()))
    def residentConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PlanetResidentsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Planet, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "residentConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def filmConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PlanetFilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Planet, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "filmConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Planet, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Planet, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Planet, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type PlanetResidentsConnection
  object PlanetResidentsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PlanetResidentsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PlanetResidentsEdge, A]
    ): SelectionBuilder[PlanetResidentsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PlanetResidentsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def residents[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[PlanetResidentsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("residents", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PlanetResidentsEdge
  object PlanetResidentsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[PlanetResidentsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PlanetResidentsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Person
  object Person {

    /** The name of this person.
      */
    def name: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))

    /** The birth year of the person, using the in-universe standard of BBY or ABY -
      * Before the Battle of Yavin or After the Battle of Yavin. The Battle of Yavin is
      * a battle that occurs at the end of Star Wars episode IV: A New Hope.
      */
    def birthYear: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("birthYear", OptionOf(Scalar()))

    /** The eye color of this person. Will be "unknown" if not known or "n/a" if the
      * person does not have an eye.
      */
    def eyeColor: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("eyeColor", OptionOf(Scalar()))

    /** The gender of this person. Either "Male", "Female" or "unknown",
      * "n/a" if the person does not have a gender.
      */
    def gender: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("gender", OptionOf(Scalar()))

    /** The hair color of this person. Will be "unknown" if not known or "n/a" if the
      * person does not have hair.
      */
    def hairColor: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("hairColor", OptionOf(Scalar()))

    /** The height of the person in centimeters.
      */
    def height: SelectionBuilder[Person, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("height", OptionOf(Scalar()))

    /** The mass of the person in kilograms.
      */
    def mass: SelectionBuilder[Person, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("mass", OptionOf(Scalar()))

    /** The skin color of this person.
      */
    def skinColor: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("skinColor", OptionOf(Scalar()))

    /** A planet that this person was born on or inhabits.
      */
    def homeworld[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[Person, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("homeworld", OptionOf(Obj(innerSelection)))
    def filmConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PersonFilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Person, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "filmConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The species that this person belongs to, or null if unknown.
      */
    def species[A](
        innerSelection: SelectionBuilder[Species, A]
    ): SelectionBuilder[Person, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("species", OptionOf(Obj(innerSelection)))
    def starshipConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PersonStarshipsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Person, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "starshipConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def vehicleConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PersonVehiclesConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Person, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "vehicleConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Person, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Person, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type PersonFilmsConnection
  object PersonFilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PersonFilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PersonFilmsEdge, A]
    ): SelectionBuilder[PersonFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PersonFilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[PersonFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PersonFilmsEdge
  object PersonFilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[PersonFilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PersonFilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type PersonStarshipsConnection
  object PersonStarshipsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PersonStarshipsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PersonStarshipsEdge, A]
    ): SelectionBuilder[PersonStarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PersonStarshipsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def starships[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[PersonStarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("starships", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PersonStarshipsEdge
  object PersonStarshipsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[PersonStarshipsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PersonStarshipsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Starship
  object Starship {

    final case class StarshipView(id: String, name: Option[String], starshipClass: Option[String], length: Option[Double])

    /** The name of this starship. The common name, such as "Death Star".
      */
    def name: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))

    /** The model or official name of this starship. Such as "T-65 X-wing" or "DS-1
      * Orbital Battle Station".
      */
    def model: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("model", OptionOf(Scalar()))

    /** The class of this starship, such as "Starfighter" or "Deep Space Mobile
      * Battlestation"
      */
    def starshipClass: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("starshipClass", OptionOf(Scalar()))

    /** The manufacturers of this starship.
      */
    def manufacturers
        : SelectionBuilder[Starship, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("manufacturers", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The cost of this starship new, in galactic credits.
      */
    def costInCredits: SelectionBuilder[Starship, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("costInCredits", OptionOf(Scalar()))

    /** The length of this starship in meters.
      */
    def length: SelectionBuilder[Starship, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("length", OptionOf(Scalar()))

    /** The number of personnel needed to run or pilot this starship.
      */
    def crew: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("crew", OptionOf(Scalar()))

    /** The number of non-essential people this starship can transport.
      */
    def passengers: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("passengers", OptionOf(Scalar()))

    /** The maximum speed of this starship in atmosphere. null if this starship is
      * incapable of atmosphering flight.
      */
    def maxAtmospheringSpeed: SelectionBuilder[Starship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("maxAtmospheringSpeed", OptionOf(Scalar()))

    /** The class of this starships hyperdrive.
      */
    def hyperdriveRating: SelectionBuilder[Starship, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("hyperdriveRating", OptionOf(Scalar()))

    /** The Maximum number of Megalights this starship can travel in a standard hour.
      * A "Megalight" is a standard unit of distance and has never been defined before
      * within the Star Wars universe. This figure is only really useful for measuring
      * the difference in speed of starships. We can assume it is similar to AU, the
      * distance between our Sun (Sol) and Earth.
      */
    def MGLT: SelectionBuilder[Starship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("MGLT", OptionOf(Scalar()))

    /** The maximum number of kilograms that this starship can transport.
      */
    def cargoCapacity: SelectionBuilder[Starship, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cargoCapacity", OptionOf(Scalar()))

    /** The maximum length of time that this starship can provide consumables for its
      * entire crew without having to resupply.
      */
    def consumables: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("consumables", OptionOf(Scalar()))
    def pilotConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[StarshipPilotsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Starship, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "pilotConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def filmConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[StarshipFilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Starship, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "filmConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Starship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Starship, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type StarshipPilotsConnection
  object StarshipPilotsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[StarshipPilotsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[StarshipPilotsEdge, A]
    ): SelectionBuilder[StarshipPilotsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[StarshipPilotsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def pilots[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[StarshipPilotsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pilots", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type StarshipPilotsEdge
  object StarshipPilotsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[StarshipPilotsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[StarshipPilotsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type StarshipFilmsConnection
  object StarshipFilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[StarshipFilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[StarshipFilmsEdge, A]
    ): SelectionBuilder[StarshipFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[StarshipFilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[StarshipFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type StarshipFilmsEdge
  object StarshipFilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[StarshipFilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[StarshipFilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type PersonVehiclesConnection
  object PersonVehiclesConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PersonVehiclesConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PersonVehiclesEdge, A]
    ): SelectionBuilder[PersonVehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PersonVehiclesConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def vehicles[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[PersonVehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("vehicles", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PersonVehiclesEdge
  object PersonVehiclesEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[PersonVehiclesEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PersonVehiclesEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Vehicle
  object Vehicle {

    /** The name of this vehicle. The common name, such as "Sand Crawler" or "Speeder
      * bike".
      */
    def name: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))

    /** The model or official name of this vehicle. Such as "All-Terrain Attack
      * Transport".
      */
    def model: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("model", OptionOf(Scalar()))

    /** The class of this vehicle, such as "Wheeled" or "Repulsorcraft".
      */
    def vehicleClass: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("vehicleClass", OptionOf(Scalar()))

    /** The manufacturers of this vehicle.
      */
    def manufacturers: SelectionBuilder[Vehicle, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("manufacturers", OptionOf(ListOf(OptionOf(Scalar()))))

    /** The cost of this vehicle new, in Galactic Credits.
      */
    def costInCredits: SelectionBuilder[Vehicle, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("costInCredits", OptionOf(Scalar()))

    /** The length of this vehicle in meters.
      */
    def length: SelectionBuilder[Vehicle, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("length", OptionOf(Scalar()))

    /** The number of personnel needed to run or pilot this vehicle.
      */
    def crew: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("crew", OptionOf(Scalar()))

    /** The number of non-essential people this vehicle can transport.
      */
    def passengers: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("passengers", OptionOf(Scalar()))

    /** The maximum speed of this vehicle in atmosphere.
      */
    def maxAtmospheringSpeed: SelectionBuilder[Vehicle, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("maxAtmospheringSpeed", OptionOf(Scalar()))

    /** The maximum number of kilograms that this vehicle can transport.
      */
    def cargoCapacity: SelectionBuilder[Vehicle, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cargoCapacity", OptionOf(Scalar()))

    /** The maximum length of time that this vehicle can provide consumables for its
      * entire crew without having to resupply.
      */
    def consumables: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("consumables", OptionOf(Scalar()))
    def pilotConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[VehiclePilotsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Vehicle, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "pilotConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def filmConnection[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[VehicleFilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[Vehicle, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "filmConnection",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** The ISO 8601 date format of the time that this resource was created.
      */
    def created: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("created", OptionOf(Scalar()))

    /** The ISO 8601 date format of the time that this resource was edited.
      */
    def edited: SelectionBuilder[Vehicle, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("edited", OptionOf(Scalar()))

    /** The ID of an object
      */
    def id: SelectionBuilder[Vehicle, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
  }

  type VehiclePilotsConnection
  object VehiclePilotsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[VehiclePilotsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[VehiclePilotsEdge, A]
    ): SelectionBuilder[VehiclePilotsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[VehiclePilotsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def pilots[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[VehiclePilotsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pilots", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type VehiclePilotsEdge
  object VehiclePilotsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[VehiclePilotsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[VehiclePilotsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type VehicleFilmsConnection
  object VehicleFilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[VehicleFilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[VehicleFilmsEdge, A]
    ): SelectionBuilder[VehicleFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[VehicleFilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[VehicleFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type VehicleFilmsEdge
  object VehicleFilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[VehicleFilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[VehicleFilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type PlanetFilmsConnection
  object PlanetFilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PlanetFilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PlanetFilmsEdge, A]
    ): SelectionBuilder[PlanetFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PlanetFilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[PlanetFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PlanetFilmsEdge
  object PlanetFilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[PlanetFilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PlanetFilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type SpeciesPeopleConnection
  object SpeciesPeopleConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SpeciesPeopleConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SpeciesPeopleEdge, A]
    ): SelectionBuilder[SpeciesPeopleConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[SpeciesPeopleConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def people[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[SpeciesPeopleConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("people", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type SpeciesPeopleEdge
  object SpeciesPeopleEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[SpeciesPeopleEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[SpeciesPeopleEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type SpeciesFilmsConnection
  object SpeciesFilmsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SpeciesFilmsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SpeciesFilmsEdge, A]
    ): SelectionBuilder[SpeciesFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[SpeciesFilmsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def films[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[SpeciesFilmsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("films", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type SpeciesFilmsEdge
  object SpeciesFilmsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Film, A]
    ): SelectionBuilder[SpeciesFilmsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[SpeciesFilmsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type FilmStarshipsConnection
  object FilmStarshipsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmStarshipsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmStarshipsEdge, A]
    ): SelectionBuilder[FilmStarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmStarshipsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def starships[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[FilmStarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("starships", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type FilmStarshipsEdge
  object FilmStarshipsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[FilmStarshipsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmStarshipsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type FilmVehiclesConnection
  object FilmVehiclesConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmVehiclesConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmVehiclesEdge, A]
    ): SelectionBuilder[FilmVehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmVehiclesConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def vehicles[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[FilmVehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("vehicles", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type FilmVehiclesEdge
  object FilmVehiclesEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[FilmVehiclesEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmVehiclesEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type FilmCharactersConnection
  object FilmCharactersConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmCharactersConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmCharactersEdge, A]
    ): SelectionBuilder[FilmCharactersConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmCharactersConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def characters[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[FilmCharactersConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("characters", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type FilmCharactersEdge
  object FilmCharactersEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[FilmCharactersEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmCharactersEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type FilmPlanetsConnection
  object FilmPlanetsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[FilmPlanetsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[FilmPlanetsEdge, A]
    ): SelectionBuilder[FilmPlanetsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[FilmPlanetsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def planets[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[FilmPlanetsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("planets", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type FilmPlanetsEdge
  object FilmPlanetsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[FilmPlanetsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[FilmPlanetsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type PeopleConnection
  object PeopleConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PeopleConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PeopleEdge, A]
    ): SelectionBuilder[PeopleConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PeopleConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def people[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[PeopleConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("people", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PeopleEdge
  object PeopleEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Person, A]
    ): SelectionBuilder[PeopleEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PeopleEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type PlanetsConnection
  object PlanetsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PlanetsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PlanetsEdge, A]
    ): SelectionBuilder[PlanetsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[PlanetsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def planets[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[PlanetsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("planets", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type PlanetsEdge
  object PlanetsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Planet, A]
    ): SelectionBuilder[PlanetsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[PlanetsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type SpeciesConnection
  object SpeciesConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SpeciesConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SpeciesEdge, A]
    ): SelectionBuilder[SpeciesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[SpeciesConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def species[A](
        innerSelection: SelectionBuilder[Species, A]
    ): SelectionBuilder[SpeciesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("species", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type SpeciesEdge
  object SpeciesEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Species, A]
    ): SelectionBuilder[SpeciesEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[SpeciesEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type StarshipsConnection
  object StarshipsConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[StarshipsConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[StarshipsEdge, A]
    ): SelectionBuilder[StarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[StarshipsConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def starships[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[StarshipsConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("starships", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type StarshipsEdge
  object StarshipsEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Starship, A]
    ): SelectionBuilder[StarshipsEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[StarshipsEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type VehiclesConnection
  object VehiclesConnection {

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[VehiclesConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[VehiclesEdge, A]
    ): SelectionBuilder[VehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /** A count of the total number of objects in this connection, ignoring pagination.
      * This allows a client to fetch the first five objects by passing "5" as the
      * argument to "first", then fetch the total count so it could display "5 of 83",
      * for example.
      */
    def totalCount: SelectionBuilder[VehiclesConnection, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))

    /** A list of all of the objects returned in the connection. This is a convenience
      * field provided for quickly exploring the API; rather than querying for
      * "{ edges { node } }" when no edge data is needed, this field can be be used
      * instead. Note that when clients like Relay need to fetch the "cursor" field on
      * the edge to enable efficient pagination, this shortcut cannot be used, and the
      * full "{ edges { node } }" version should be used instead.
      */
    def vehicles[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[VehiclesConnection, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("vehicles", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type VehiclesEdge
  object VehiclesEdge {

    /** The item at the end of the edge
      */
    def node[A](
        innerSelection: SelectionBuilder[Vehicle, A]
    ): SelectionBuilder[VehiclesEdge, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))

    /** A cursor for use in pagination
      */
    def cursor: SelectionBuilder[VehiclesEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())
  }

  type Root = _root_.caliban.client.Operations.RootQuery
  object Root {
    def allFilms[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[FilmsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allFilms",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def film[A](id: Option[String] = None, filmID: Option[String] = None)(
        innerSelection: SelectionBuilder[Film, A]
    )(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "film",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("filmID", filmID, "ID")(encoder1)
        )
      )
    def allPeople[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PeopleConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allPeople",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def person[A](id: Option[String] = None, personID: Option[String] = None)(
        innerSelection: SelectionBuilder[Person, A]
    )(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "person",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("personID", personID, "ID")(encoder1)
        )
      )
    def allPlanets[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[PlanetsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allPlanets",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def planet[A](id: Option[String] = None, planetID: Option[String] = None)(
        innerSelection: SelectionBuilder[Planet, A]
    )(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "planet",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("planetID", planetID, "ID")(encoder1)
        )
      )
    def allSpecies[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[SpeciesConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allSpecies",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def species[A](id: Option[String] = None, speciesID: Option[String] = None)(
        innerSelection: SelectionBuilder[Species, A]
    )(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "species",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("speciesID", speciesID, "ID")(encoder1)
        )
      )
    def allStarships[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[StarshipsConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allStarships",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def starship[A](
        id: Option[String] = None,
        starshipID: Option[String] = None
    )(innerSelection: SelectionBuilder[Starship, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "starship",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("starshipID", starshipID, "ID")(encoder1)
        )
      )
    def allVehicles[A](
        after: Option[String] = None,
        first: Option[Int] = None,
        before: Option[String] = None,
        last: Option[Int] = None
    )(innerSelection: SelectionBuilder[VehiclesConnection, A])(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[String]],
        encoder3: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "allVehicles",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("first", first, "Int")(encoder1),
          Argument("before", before, "String")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
    def vehicle[A](id: Option[String] = None, vehicleID: Option[String] = None)(
        innerSelection: SelectionBuilder[Vehicle, A]
    )(implicit
        encoder0: ArgEncoder[Option[String]],
        encoder1: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "vehicle",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("id", id, "ID")(encoder0),
          Argument("vehicleID", vehicleID, "ID")(encoder1)
        )
      )

    /** Fetches an object given its ID
      */
    def node[A](id: String)(
        onFilm: Option[SelectionBuilder[Film, A]] = None,
        onPerson: Option[SelectionBuilder[Person, A]] = None,
        onPlanet: Option[SelectionBuilder[Planet, A]] = None,
        onSpecies: Option[SelectionBuilder[Species, A]] = None,
        onStarship: Option[SelectionBuilder[Starship, A]] = None,
        onVehicle: Option[SelectionBuilder[Vehicle, A]] = None
    )(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "node",
        OptionOf(
          ChoiceOf(
            Map(
              "Film" -> onFilm,
              "Person" -> onPerson,
              "Planet" -> onPlanet,
              "Species" -> onSpecies,
              "Starship" -> onStarship,
              "Vehicle" -> onVehicle
            ).collect { case (k, Some(v)) => k -> Obj(v) }
          )
        ),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
  }

}
