package clients

import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client._
import caliban.client.__Value._

object SpaceXGraphQLClient {

  type uuid = String

  type timestamptz = String

  type ID = String

  type Date = String

  type ObjectID = String

  sealed trait users_select_column
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object users_select_column {
    case object id extends users_select_column { val value: String = "id" }
    case object name extends users_select_column { val value: String = "name" }
    case object rocket extends users_select_column {
      val value: String = "rocket"
    }
    case object timestamp extends users_select_column {
      val value: String = "timestamp"
    }
    case object twitter extends users_select_column {
      val value: String = "twitter"
    }

    implicit val decoder: ScalarDecoder[users_select_column] = {
      case __StringValue("id")        => Right(users_select_column.id)
      case __StringValue("name")      => Right(users_select_column.name)
      case __StringValue("rocket")    => Right(users_select_column.rocket)
      case __StringValue("timestamp") => Right(users_select_column.timestamp)
      case __StringValue("twitter")   => Right(users_select_column.twitter)
      case other =>
        Left(
          DecodingError(s"Can't build users_select_column from input $other")
        )
    }
    implicit val encoder: ArgEncoder[users_select_column] = {
      case users_select_column.id        => __EnumValue("id")
      case users_select_column.name      => __EnumValue("name")
      case users_select_column.rocket    => __EnumValue("rocket")
      case users_select_column.timestamp => __EnumValue("timestamp")
      case users_select_column.twitter   => __EnumValue("twitter")
    }

    val values: Vector[users_select_column] =
      Vector(id, name, rocket, timestamp, twitter)
  }

  sealed trait order_by extends scala.Product with scala.Serializable {
    def value: String
  }
  object order_by {
    case object asc extends order_by { val value: String = "asc" }
    case object asc_nulls_first extends order_by {
      val value: String = "asc_nulls_first"
    }
    case object asc_nulls_last extends order_by {
      val value: String = "asc_nulls_last"
    }
    case object desc extends order_by { val value: String = "desc" }
    case object desc_nulls_first extends order_by {
      val value: String = "desc_nulls_first"
    }
    case object desc_nulls_last extends order_by {
      val value: String = "desc_nulls_last"
    }

    implicit val decoder: ScalarDecoder[order_by] = {
      case __StringValue("asc")              => Right(order_by.asc)
      case __StringValue("asc_nulls_first")  => Right(order_by.asc_nulls_first)
      case __StringValue("asc_nulls_last")   => Right(order_by.asc_nulls_last)
      case __StringValue("desc")             => Right(order_by.desc)
      case __StringValue("desc_nulls_first") => Right(order_by.desc_nulls_first)
      case __StringValue("desc_nulls_last")  => Right(order_by.desc_nulls_last)
      case other =>
        Left(DecodingError(s"Can't build order_by from input $other"))
    }
    implicit val encoder: ArgEncoder[order_by] = {
      case order_by.asc              => __EnumValue("asc")
      case order_by.asc_nulls_first  => __EnumValue("asc_nulls_first")
      case order_by.asc_nulls_last   => __EnumValue("asc_nulls_last")
      case order_by.desc             => __EnumValue("desc")
      case order_by.desc_nulls_first => __EnumValue("desc_nulls_first")
      case order_by.desc_nulls_last  => __EnumValue("desc_nulls_last")
    }

    val values: Vector[order_by] = Vector(
      asc,
      asc_nulls_first,
      asc_nulls_last,
      desc,
      desc_nulls_first,
      desc_nulls_last
    )
  }

  sealed trait users_constraint extends scala.Product with scala.Serializable {
    def value: String
  }
  object users_constraint {
    case object users_pkey extends users_constraint {
      val value: String = "users_pkey"
    }

    implicit val decoder: ScalarDecoder[users_constraint] = {
      case __StringValue("users_pkey") => Right(users_constraint.users_pkey)
      case other =>
        Left(DecodingError(s"Can't build users_constraint from input $other"))
    }
    implicit val encoder: ArgEncoder[users_constraint] = {
      case users_constraint.users_pkey => __EnumValue("users_pkey")
    }

    val values: Vector[users_constraint] = Vector(users_pkey)
  }

  sealed trait users_update_column
      extends scala.Product
      with scala.Serializable {
    def value: String
  }
  object users_update_column {
    case object id extends users_update_column { val value: String = "id" }
    case object name extends users_update_column { val value: String = "name" }
    case object rocket extends users_update_column {
      val value: String = "rocket"
    }
    case object timestamp extends users_update_column {
      val value: String = "timestamp"
    }
    case object twitter extends users_update_column {
      val value: String = "twitter"
    }

    implicit val decoder: ScalarDecoder[users_update_column] = {
      case __StringValue("id")        => Right(users_update_column.id)
      case __StringValue("name")      => Right(users_update_column.name)
      case __StringValue("rocket")    => Right(users_update_column.rocket)
      case __StringValue("timestamp") => Right(users_update_column.timestamp)
      case __StringValue("twitter")   => Right(users_update_column.twitter)
      case other =>
        Left(
          DecodingError(s"Can't build users_update_column from input $other")
        )
    }
    implicit val encoder: ArgEncoder[users_update_column] = {
      case users_update_column.id        => __EnumValue("id")
      case users_update_column.name      => __EnumValue("name")
      case users_update_column.rocket    => __EnumValue("rocket")
      case users_update_column.timestamp => __EnumValue("timestamp")
      case users_update_column.twitter   => __EnumValue("twitter")
    }

    val values: Vector[users_update_column] =
      Vector(id, name, rocket, timestamp, twitter)
  }

  sealed trait conflict_action extends scala.Product with scala.Serializable {
    def value: String
  }
  object conflict_action {
    case object ignore extends conflict_action { val value: String = "ignore" }
    case object update extends conflict_action { val value: String = "update" }

    implicit val decoder: ScalarDecoder[conflict_action] = {
      case __StringValue("ignore") => Right(conflict_action.ignore)
      case __StringValue("update") => Right(conflict_action.update)
      case other =>
        Left(DecodingError(s"Can't build conflict_action from input $other"))
    }
    implicit val encoder: ArgEncoder[conflict_action] = {
      case conflict_action.ignore => __EnumValue("ignore")
      case conflict_action.update => __EnumValue("update")
    }

    val values: Vector[conflict_action] = Vector(ignore, update)
  }

  type users
  object users {

    final case class usersView(
        id: uuid,
        name: Option[String],
        rocket: Option[String],
        timestamp: timestamptz,
        twitter: Option[String]
    )

    type ViewSelection = SelectionBuilder[users, usersView]

    def view: ViewSelection = (id ~ name ~ rocket ~ timestamp ~ twitter).map {
      case ((((id, name), rocket), timestamp), twitter) =>
        usersView(id, name, rocket, timestamp, twitter)
    }

    def id: SelectionBuilder[users, uuid] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())
    def name: SelectionBuilder[users, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def rocket: SelectionBuilder[users, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("rocket", OptionOf(Scalar()))
    def timestamp: SelectionBuilder[users, timestamptz] =
      _root_.caliban.client.SelectionBuilder.Field("timestamp", Scalar())
    def twitter: SelectionBuilder[users, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitter", OptionOf(Scalar()))
  }

  type users_aggregate
  object users_aggregate {

    final case class users_aggregateView[AggregateSelection, NodesSelection](
        aggregate: Option[AggregateSelection],
        nodes: List[NodesSelection]
    )

    type ViewSelection[AggregateSelection, NodesSelection] = SelectionBuilder[
      users_aggregate,
      users_aggregateView[AggregateSelection, NodesSelection]
    ]

    def view[AggregateSelection, NodesSelection](
        aggregateSelection: SelectionBuilder[
          users_aggregate_fields,
          AggregateSelection
        ],
        nodesSelection: SelectionBuilder[users, NodesSelection]
    ): ViewSelection[AggregateSelection, NodesSelection] =
      (aggregate(aggregateSelection) ~ nodes(nodesSelection)).map {
        case (aggregate, nodes) => users_aggregateView(aggregate, nodes)
      }

    def aggregate[A](
        innerSelection: SelectionBuilder[users_aggregate_fields, A]
    ): SelectionBuilder[users_aggregate, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("aggregate", OptionOf(Obj(innerSelection)))
    def nodes[A](
        innerSelection: SelectionBuilder[users, A]
    ): SelectionBuilder[users_aggregate, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("nodes", ListOf(Obj(innerSelection)))
  }

  type users_aggregate_fields
  object users_aggregate_fields {

    final case class users_aggregate_fieldsView[MaxSelection, MinSelection](
        count: Option[Int],
        max: Option[MaxSelection],
        min: Option[MinSelection]
    )

    type ViewSelection[MaxSelection, MinSelection] = SelectionBuilder[
      users_aggregate_fields,
      users_aggregate_fieldsView[MaxSelection, MinSelection]
    ]

    def view[MaxSelection, MinSelection](
        countColumns: Option[List[users_select_column]] = None,
        countDistinct: Option[Boolean] = None
    )(
        maxSelection: SelectionBuilder[users_max_fields, MaxSelection],
        minSelection: SelectionBuilder[users_min_fields, MinSelection]
    ): ViewSelection[MaxSelection, MinSelection] =
      (count(countColumns, countDistinct) ~ max(maxSelection) ~ min(
        minSelection
      )).map { case ((count, max), min) =>
        users_aggregate_fieldsView(count, max, min)
      }

    def count(
        columns: Option[List[users_select_column]] = None,
        distinct: Option[Boolean] = None
    )(implicit
        encoder0: ArgEncoder[Option[List[users_select_column]]],
        encoder1: ArgEncoder[Option[Boolean]]
    ): SelectionBuilder[users_aggregate_fields, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "count",
        OptionOf(Scalar()),
        arguments = List(
          Argument("columns", columns, "[users_select_column!]")(encoder0),
          Argument("distinct", distinct, "Boolean")(encoder1)
        )
      )
    def max[A](
        innerSelection: SelectionBuilder[users_max_fields, A]
    ): SelectionBuilder[users_aggregate_fields, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("max", OptionOf(Obj(innerSelection)))
    def min[A](
        innerSelection: SelectionBuilder[users_min_fields, A]
    ): SelectionBuilder[users_aggregate_fields, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("min", OptionOf(Obj(innerSelection)))
  }

  type users_max_fields
  object users_max_fields {

    final case class users_max_fieldsView(
        name: Option[String],
        rocket: Option[String],
        timestamp: Option[timestamptz],
        twitter: Option[String]
    )

    type ViewSelection =
      SelectionBuilder[users_max_fields, users_max_fieldsView]

    def view: ViewSelection = (name ~ rocket ~ timestamp ~ twitter).map {
      case (((name, rocket), timestamp), twitter) =>
        users_max_fieldsView(name, rocket, timestamp, twitter)
    }

    def name: SelectionBuilder[users_max_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def rocket: SelectionBuilder[users_max_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("rocket", OptionOf(Scalar()))
    def timestamp: SelectionBuilder[users_max_fields, Option[timestamptz]] =
      _root_.caliban.client.SelectionBuilder
        .Field("timestamp", OptionOf(Scalar()))
    def twitter: SelectionBuilder[users_max_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitter", OptionOf(Scalar()))
  }

  type users_min_fields
  object users_min_fields {

    final case class users_min_fieldsView(
        name: Option[String],
        rocket: Option[String],
        timestamp: Option[timestamptz],
        twitter: Option[String]
    )

    type ViewSelection =
      SelectionBuilder[users_min_fields, users_min_fieldsView]

    def view: ViewSelection = (name ~ rocket ~ timestamp ~ twitter).map {
      case (((name, rocket), timestamp), twitter) =>
        users_min_fieldsView(name, rocket, timestamp, twitter)
    }

    def name: SelectionBuilder[users_min_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def rocket: SelectionBuilder[users_min_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("rocket", OptionOf(Scalar()))
    def timestamp: SelectionBuilder[users_min_fields, Option[timestamptz]] =
      _root_.caliban.client.SelectionBuilder
        .Field("timestamp", OptionOf(Scalar()))
    def twitter: SelectionBuilder[users_min_fields, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitter", OptionOf(Scalar()))
  }

  type Capsule
  object Capsule {

    final case class CapsuleView[MissionsSelection, DragonSelection](
        id: Option[String],
        landings: Option[Int],
        missions: Option[List[Option[MissionsSelection]]],
        original_launch: Option[Date],
        reuse_count: Option[Int],
        status: Option[String],
        `type`: Option[String],
        dragon: Option[DragonSelection]
    )

    type ViewSelection[MissionsSelection, DragonSelection] =
      SelectionBuilder[Capsule, CapsuleView[MissionsSelection, DragonSelection]]

    def view[MissionsSelection, DragonSelection](
        missionsSelection: SelectionBuilder[CapsuleMission, MissionsSelection],
        dragonSelection: SelectionBuilder[Dragon, DragonSelection]
    ): ViewSelection[MissionsSelection, DragonSelection] =
      (id ~ landings ~ missions(
        missionsSelection
      ) ~ original_launch ~ reuse_count ~ status ~ `type` ~ dragon(
        dragonSelection
      )).map {
        case (
              (
                (
                  ((((id, landings), missions), original_launch), reuse_count),
                  status
                ),
                type$
              ),
              dragon
            ) =>
          CapsuleView(
            id,
            landings,
            missions,
            original_launch,
            reuse_count,
            status,
            type$,
            dragon
          )
      }

    def id: SelectionBuilder[Capsule, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def landings: SelectionBuilder[Capsule, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landings", OptionOf(Scalar()))
    def missions[A](
        innerSelection: SelectionBuilder[CapsuleMission, A]
    ): SelectionBuilder[Capsule, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("missions", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def original_launch: SelectionBuilder[Capsule, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("original_launch", OptionOf(Scalar()))
    def reuse_count: SelectionBuilder[Capsule, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reuse_count", OptionOf(Scalar()))
    def status: SelectionBuilder[Capsule, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def `type`: SelectionBuilder[Capsule, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
    def dragon[A](
        innerSelection: SelectionBuilder[Dragon, A]
    ): SelectionBuilder[Capsule, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("dragon", OptionOf(Obj(innerSelection)))
  }

  type CapsuleMission
  object CapsuleMission {

    final case class CapsuleMissionView(
        flight: Option[Int],
        name: Option[String]
    )

    type ViewSelection = SelectionBuilder[CapsuleMission, CapsuleMissionView]

    def view: ViewSelection = (flight ~ name).map { case (flight, name) =>
      CapsuleMissionView(flight, name)
    }

    def flight: SelectionBuilder[CapsuleMission, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("flight", OptionOf(Scalar()))
    def name: SelectionBuilder[CapsuleMission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
  }

  type Dragon
  object Dragon {

    final case class DragonView[
        DiameterSelection,
        Heat_shieldSelection,
        Height_w_trunkSelection,
        Launch_payload_massSelection,
        Launch_payload_volSelection,
        Pressurized_capsuleSelection,
        Return_payload_massSelection,
        Return_payload_volSelection,
        ThrustersSelection,
        TrunkSelection
    ](
        active: Option[Boolean],
        crew_capacity: Option[Int],
        description: Option[String],
        diameter: Option[DiameterSelection],
        dry_mass_kg: Option[Int],
        dry_mass_lb: Option[Int],
        first_flight: Option[String],
        heat_shield: Option[Heat_shieldSelection],
        height_w_trunk: Option[Height_w_trunkSelection],
        id: Option[String],
        launch_payload_mass: Option[Launch_payload_massSelection],
        launch_payload_vol: Option[Launch_payload_volSelection],
        name: Option[String],
        orbit_duration_yr: Option[Int],
        pressurized_capsule: Option[Pressurized_capsuleSelection],
        return_payload_mass: Option[Return_payload_massSelection],
        return_payload_vol: Option[Return_payload_volSelection],
        sidewall_angle_deg: Option[Double],
        thrusters: Option[List[Option[ThrustersSelection]]],
        trunk: Option[TrunkSelection],
        `type`: Option[String],
        wikipedia: Option[String]
    )

    type ViewSelection[
        DiameterSelection,
        Heat_shieldSelection,
        Height_w_trunkSelection,
        Launch_payload_massSelection,
        Launch_payload_volSelection,
        Pressurized_capsuleSelection,
        Return_payload_massSelection,
        Return_payload_volSelection,
        ThrustersSelection,
        TrunkSelection
    ] = SelectionBuilder[Dragon, DragonView[
      DiameterSelection,
      Heat_shieldSelection,
      Height_w_trunkSelection,
      Launch_payload_massSelection,
      Launch_payload_volSelection,
      Pressurized_capsuleSelection,
      Return_payload_massSelection,
      Return_payload_volSelection,
      ThrustersSelection,
      TrunkSelection
    ]]

    def view[
        DiameterSelection,
        Heat_shieldSelection,
        Height_w_trunkSelection,
        Launch_payload_massSelection,
        Launch_payload_volSelection,
        Pressurized_capsuleSelection,
        Return_payload_massSelection,
        Return_payload_volSelection,
        ThrustersSelection,
        TrunkSelection
    ](
        diameterSelection: SelectionBuilder[Distance, DiameterSelection],
        heat_shieldSelection: SelectionBuilder[
          DragonHeatShield,
          Heat_shieldSelection
        ],
        height_w_trunkSelection: SelectionBuilder[
          Distance,
          Height_w_trunkSelection
        ],
        launch_payload_massSelection: SelectionBuilder[
          Mass,
          Launch_payload_massSelection
        ],
        launch_payload_volSelection: SelectionBuilder[
          Volume,
          Launch_payload_volSelection
        ],
        pressurized_capsuleSelection: SelectionBuilder[
          DragonPressurizedCapsule,
          Pressurized_capsuleSelection
        ],
        return_payload_massSelection: SelectionBuilder[
          Mass,
          Return_payload_massSelection
        ],
        return_payload_volSelection: SelectionBuilder[
          Volume,
          Return_payload_volSelection
        ],
        thrustersSelection: SelectionBuilder[DragonThrust, ThrustersSelection],
        trunkSelection: SelectionBuilder[DragonTrunk, TrunkSelection]
    ): ViewSelection[
      DiameterSelection,
      Heat_shieldSelection,
      Height_w_trunkSelection,
      Launch_payload_massSelection,
      Launch_payload_volSelection,
      Pressurized_capsuleSelection,
      Return_payload_massSelection,
      Return_payload_volSelection,
      ThrustersSelection,
      TrunkSelection
    ] = (active ~ crew_capacity ~ description ~ diameter(
      diameterSelection
    ) ~ dry_mass_kg ~ dry_mass_lb ~ first_flight ~ heat_shield(
      heat_shieldSelection
    ) ~ height_w_trunk(height_w_trunkSelection) ~ id ~ launch_payload_mass(
      launch_payload_massSelection
    ) ~ launch_payload_vol(
      launch_payload_volSelection
    ) ~ name ~ orbit_duration_yr ~ pressurized_capsule(
      pressurized_capsuleSelection
    ) ~ return_payload_mass(return_payload_massSelection) ~ return_payload_vol(
      return_payload_volSelection
    ) ~ sidewall_angle_deg ~ thrusters(thrustersSelection) ~ trunk(
      trunkSelection
    ) ~ `type` ~ wikipedia).map {
      case (
            (
              (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            (
                                              (
                                                (
                                                  (active, crew_capacity),
                                                  description
                                                ),
                                                diameter
                                              ),
                                              dry_mass_kg
                                            ),
                                            dry_mass_lb
                                          ),
                                          first_flight
                                        ),
                                        heat_shield
                                      ),
                                      height_w_trunk
                                    ),
                                    id
                                  ),
                                  launch_payload_mass
                                ),
                                launch_payload_vol
                              ),
                              name
                            ),
                            orbit_duration_yr
                          ),
                          pressurized_capsule
                        ),
                        return_payload_mass
                      ),
                      return_payload_vol
                    ),
                    sidewall_angle_deg
                  ),
                  thrusters
                ),
                trunk
              ),
              type$
            ),
            wikipedia
          ) =>
        DragonView(
          active,
          crew_capacity,
          description,
          diameter,
          dry_mass_kg,
          dry_mass_lb,
          first_flight,
          heat_shield,
          height_w_trunk,
          id,
          launch_payload_mass,
          launch_payload_vol,
          name,
          orbit_duration_yr,
          pressurized_capsule,
          return_payload_mass,
          return_payload_vol,
          sidewall_angle_deg,
          thrusters,
          trunk,
          type$,
          wikipedia
        )
    }

    def active: SelectionBuilder[Dragon, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("active", OptionOf(Scalar()))
    def crew_capacity: SelectionBuilder[Dragon, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("crew_capacity", OptionOf(Scalar()))
    def description: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def diameter[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("diameter", OptionOf(Obj(innerSelection)))
    def dry_mass_kg: SelectionBuilder[Dragon, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("dry_mass_kg", OptionOf(Scalar()))
    def dry_mass_lb: SelectionBuilder[Dragon, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("dry_mass_lb", OptionOf(Scalar()))
    def first_flight: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("first_flight", OptionOf(Scalar()))
    def heat_shield[A](
        innerSelection: SelectionBuilder[DragonHeatShield, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("heat_shield", OptionOf(Obj(innerSelection)))
    def height_w_trunk[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("height_w_trunk", OptionOf(Obj(innerSelection)))
    def id: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def launch_payload_mass[A](
        innerSelection: SelectionBuilder[Mass, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_payload_mass", OptionOf(Obj(innerSelection)))
    def launch_payload_vol[A](
        innerSelection: SelectionBuilder[Volume, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_payload_vol", OptionOf(Obj(innerSelection)))
    def name: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def orbit_duration_yr: SelectionBuilder[Dragon, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("orbit_duration_yr", OptionOf(Scalar()))
    def pressurized_capsule[A](
        innerSelection: SelectionBuilder[DragonPressurizedCapsule, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("pressurized_capsule", OptionOf(Obj(innerSelection)))
    def return_payload_mass[A](
        innerSelection: SelectionBuilder[Mass, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("return_payload_mass", OptionOf(Obj(innerSelection)))
    def return_payload_vol[A](
        innerSelection: SelectionBuilder[Volume, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("return_payload_vol", OptionOf(Obj(innerSelection)))
    def sidewall_angle_deg: SelectionBuilder[Dragon, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("sidewall_angle_deg", OptionOf(Scalar()))
    def thrusters[A](
        innerSelection: SelectionBuilder[DragonThrust, A]
    ): SelectionBuilder[Dragon, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrusters", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def trunk[A](
        innerSelection: SelectionBuilder[DragonTrunk, A]
    ): SelectionBuilder[Dragon, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("trunk", OptionOf(Obj(innerSelection)))
    def `type`: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Dragon, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type Distance
  object Distance {

    final case class DistanceView(feet: Option[Double], meters: Option[Double])

    type ViewSelection = SelectionBuilder[Distance, DistanceView]

    def view: ViewSelection = (feet ~ meters).map { case (feet, meters) =>
      DistanceView(feet, meters)
    }

    def feet: SelectionBuilder[Distance, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("feet", OptionOf(Scalar()))
    def meters: SelectionBuilder[Distance, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("meters", OptionOf(Scalar()))
  }

  type DragonHeatShield
  object DragonHeatShield {

    final case class DragonHeatShieldView(
        dev_partner: Option[String],
        material: Option[String],
        size_meters: Option[Double],
        temp_degrees: Option[Int]
    )

    type ViewSelection =
      SelectionBuilder[DragonHeatShield, DragonHeatShieldView]

    def view: ViewSelection =
      (dev_partner ~ material ~ size_meters ~ temp_degrees).map {
        case (((dev_partner, material), size_meters), temp_degrees) =>
          DragonHeatShieldView(dev_partner, material, size_meters, temp_degrees)
      }

    def dev_partner: SelectionBuilder[DragonHeatShield, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("dev_partner", OptionOf(Scalar()))
    def material: SelectionBuilder[DragonHeatShield, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("material", OptionOf(Scalar()))
    def size_meters: SelectionBuilder[DragonHeatShield, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("size_meters", OptionOf(Scalar()))
    def temp_degrees: SelectionBuilder[DragonHeatShield, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("temp_degrees", OptionOf(Scalar()))
  }

  type Mass
  object Mass {

    final case class MassView(kg: Option[Int], lb: Option[Int])

    type ViewSelection = SelectionBuilder[Mass, MassView]

    def view: ViewSelection = (kg ~ lb).map { case (kg, lb) =>
      MassView(kg, lb)
    }

    def kg: SelectionBuilder[Mass, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("kg", OptionOf(Scalar()))
    def lb: SelectionBuilder[Mass, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("lb", OptionOf(Scalar()))
  }

  type Volume
  object Volume {

    final case class VolumeView(
        cubic_feet: Option[Int],
        cubic_meters: Option[Int]
    )

    type ViewSelection = SelectionBuilder[Volume, VolumeView]

    def view: ViewSelection = (cubic_feet ~ cubic_meters).map {
      case (cubic_feet, cubic_meters) => VolumeView(cubic_feet, cubic_meters)
    }

    def cubic_feet: SelectionBuilder[Volume, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cubic_feet", OptionOf(Scalar()))
    def cubic_meters: SelectionBuilder[Volume, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cubic_meters", OptionOf(Scalar()))
  }

  type DragonPressurizedCapsule
  object DragonPressurizedCapsule {

    final case class DragonPressurizedCapsuleView[Payload_volumeSelection](
        payload_volume: Option[Payload_volumeSelection]
    )

    type ViewSelection[Payload_volumeSelection] =
      SelectionBuilder[DragonPressurizedCapsule, DragonPressurizedCapsuleView[
        Payload_volumeSelection
      ]]

    def view[Payload_volumeSelection](
        payload_volumeSelection: SelectionBuilder[
          Volume,
          Payload_volumeSelection
        ]
    ): ViewSelection[Payload_volumeSelection] = payload_volume(
      payload_volumeSelection
    ).map(payload_volume => DragonPressurizedCapsuleView(payload_volume))

    def payload_volume[A](
        innerSelection: SelectionBuilder[Volume, A]
    ): SelectionBuilder[DragonPressurizedCapsule, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payload_volume", OptionOf(Obj(innerSelection)))
  }

  type DragonThrust
  object DragonThrust {

    final case class DragonThrustView[ThrustSelection](
        amount: Option[Int],
        fuel_1: Option[String],
        fuel_2: Option[String],
        pods: Option[Int],
        thrust: Option[ThrustSelection],
        `type`: Option[String]
    )

    type ViewSelection[ThrustSelection] =
      SelectionBuilder[DragonThrust, DragonThrustView[ThrustSelection]]

    def view[ThrustSelection](
        thrustSelection: SelectionBuilder[Force, ThrustSelection]
    ): ViewSelection[ThrustSelection] =
      (amount ~ fuel_1 ~ fuel_2 ~ pods ~ thrust(thrustSelection) ~ `type`).map {
        case (((((amount, fuel_1), fuel_2), pods), thrust), type$) =>
          DragonThrustView(amount, fuel_1, fuel_2, pods, thrust, type$)
      }

    def amount: SelectionBuilder[DragonThrust, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("amount", OptionOf(Scalar()))
    def fuel_1: SelectionBuilder[DragonThrust, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("fuel_1", OptionOf(Scalar()))
    def fuel_2: SelectionBuilder[DragonThrust, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("fuel_2", OptionOf(Scalar()))
    def pods: SelectionBuilder[DragonThrust, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("pods", OptionOf(Scalar()))
    def thrust[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[DragonThrust, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust", OptionOf(Obj(innerSelection)))
    def `type`: SelectionBuilder[DragonThrust, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
  }

  type Force
  object Force {

    final case class ForceView(kN: Option[Double], lbf: Option[Double])

    type ViewSelection = SelectionBuilder[Force, ForceView]

    def view: ViewSelection = (kN ~ lbf).map { case (kN, lbf) =>
      ForceView(kN, lbf)
    }

    def kN: SelectionBuilder[Force, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("kN", OptionOf(Scalar()))
    def lbf: SelectionBuilder[Force, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("lbf", OptionOf(Scalar()))
  }

  type DragonTrunk
  object DragonTrunk {

    final case class DragonTrunkView[CargoSelection, Trunk_volumeSelection](
        cargo: Option[CargoSelection],
        trunk_volume: Option[Trunk_volumeSelection]
    )

    type ViewSelection[CargoSelection, Trunk_volumeSelection] =
      SelectionBuilder[
        DragonTrunk,
        DragonTrunkView[CargoSelection, Trunk_volumeSelection]
      ]

    def view[CargoSelection, Trunk_volumeSelection](
        cargoSelection: SelectionBuilder[DragonTrunkCargo, CargoSelection],
        trunk_volumeSelection: SelectionBuilder[Volume, Trunk_volumeSelection]
    ): ViewSelection[CargoSelection, Trunk_volumeSelection] =
      (cargo(cargoSelection) ~ trunk_volume(trunk_volumeSelection)).map {
        case (cargo, trunk_volume) => DragonTrunkView(cargo, trunk_volume)
      }

    def cargo[A](
        innerSelection: SelectionBuilder[DragonTrunkCargo, A]
    ): SelectionBuilder[DragonTrunk, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cargo", OptionOf(Obj(innerSelection)))
    def trunk_volume[A](
        innerSelection: SelectionBuilder[Volume, A]
    ): SelectionBuilder[DragonTrunk, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("trunk_volume", OptionOf(Obj(innerSelection)))
  }

  type DragonTrunkCargo
  object DragonTrunkCargo {

    final case class DragonTrunkCargoView(
        solar_array: Option[Int],
        unpressurized_cargo: Option[Boolean]
    )

    type ViewSelection =
      SelectionBuilder[DragonTrunkCargo, DragonTrunkCargoView]

    def view: ViewSelection = (solar_array ~ unpressurized_cargo).map {
      case (solar_array, unpressurized_cargo) =>
        DragonTrunkCargoView(solar_array, unpressurized_cargo)
    }

    def solar_array: SelectionBuilder[DragonTrunkCargo, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("solar_array", OptionOf(Scalar()))
    def unpressurized_cargo
        : SelectionBuilder[DragonTrunkCargo, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("unpressurized_cargo", OptionOf(Scalar()))
  }

  type Info
  object Info {

    final case class InfoView[HeadquartersSelection, LinksSelection](
        ceo: Option[String],
        coo: Option[String],
        cto_propulsion: Option[String],
        cto: Option[String],
        employees: Option[Int],
        founded: Option[Int],
        founder: Option[String],
        headquarters: Option[HeadquartersSelection],
        launch_sites: Option[Int],
        links: Option[LinksSelection],
        name: Option[String],
        summary: Option[String],
        test_sites: Option[Int],
        valuation: Option[Double],
        vehicles: Option[Int]
    )

    type ViewSelection[HeadquartersSelection, LinksSelection] =
      SelectionBuilder[Info, InfoView[HeadquartersSelection, LinksSelection]]

    def view[HeadquartersSelection, LinksSelection](
        headquartersSelection: SelectionBuilder[Address, HeadquartersSelection],
        linksSelection: SelectionBuilder[InfoLinks, LinksSelection]
    ): ViewSelection[HeadquartersSelection, LinksSelection] =
      (ceo ~ coo ~ cto_propulsion ~ cto ~ employees ~ founded ~ founder ~ headquarters(
        headquartersSelection
      ) ~ launch_sites ~ links(
        linksSelection
      ) ~ name ~ summary ~ test_sites ~ valuation ~ vehicles).map {
        case (
              (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (((ceo, coo), cto_propulsion), cto),
                                  employees
                                ),
                                founded
                              ),
                              founder
                            ),
                            headquarters
                          ),
                          launch_sites
                        ),
                        links
                      ),
                      name
                    ),
                    summary
                  ),
                  test_sites
                ),
                valuation
              ),
              vehicles
            ) =>
          InfoView(
            ceo,
            coo,
            cto_propulsion,
            cto,
            employees,
            founded,
            founder,
            headquarters,
            launch_sites,
            links,
            name,
            summary,
            test_sites,
            valuation,
            vehicles
          )
      }

    def ceo: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("ceo", OptionOf(Scalar()))
    def coo: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("coo", OptionOf(Scalar()))
    def cto_propulsion: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cto_propulsion", OptionOf(Scalar()))
    def cto: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("cto", OptionOf(Scalar()))
    def employees: SelectionBuilder[Info, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("employees", OptionOf(Scalar()))
    def founded: SelectionBuilder[Info, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("founded", OptionOf(Scalar()))
    def founder: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("founder", OptionOf(Scalar()))
    def headquarters[A](
        innerSelection: SelectionBuilder[Address, A]
    ): SelectionBuilder[Info, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("headquarters", OptionOf(Obj(innerSelection)))
    def launch_sites: SelectionBuilder[Info, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_sites", OptionOf(Scalar()))
    def links[A](
        innerSelection: SelectionBuilder[InfoLinks, A]
    ): SelectionBuilder[Info, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("links", OptionOf(Obj(innerSelection)))
    def name: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def summary: SelectionBuilder[Info, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("summary", OptionOf(Scalar()))
    def test_sites: SelectionBuilder[Info, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("test_sites", OptionOf(Scalar()))
    def valuation: SelectionBuilder[Info, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("valuation", OptionOf(Scalar()))
    def vehicles: SelectionBuilder[Info, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("vehicles", OptionOf(Scalar()))
  }

  type Address
  object Address {

    final case class AddressView(
        address: Option[String],
        city: Option[String],
        state: Option[String]
    )

    type ViewSelection = SelectionBuilder[Address, AddressView]

    def view: ViewSelection = (address ~ city ~ state).map {
      case ((address, city), state) => AddressView(address, city, state)
    }

    def address: SelectionBuilder[Address, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("address", OptionOf(Scalar()))
    def city: SelectionBuilder[Address, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("city", OptionOf(Scalar()))
    def state: SelectionBuilder[Address, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("state", OptionOf(Scalar()))
  }

  type InfoLinks
  object InfoLinks {

    final case class InfoLinksView(
        elon_twitter: Option[String],
        flickr: Option[String],
        twitter: Option[String],
        website: Option[String]
    )

    type ViewSelection = SelectionBuilder[InfoLinks, InfoLinksView]

    def view: ViewSelection = (elon_twitter ~ flickr ~ twitter ~ website).map {
      case (((elon_twitter, flickr), twitter), website) =>
        InfoLinksView(elon_twitter, flickr, twitter, website)
    }

    def elon_twitter: SelectionBuilder[InfoLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("elon_twitter", OptionOf(Scalar()))
    def flickr: SelectionBuilder[InfoLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("flickr", OptionOf(Scalar()))
    def twitter: SelectionBuilder[InfoLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitter", OptionOf(Scalar()))
    def website: SelectionBuilder[InfoLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("website", OptionOf(Scalar()))
  }

  type Core
  object Core {

    final case class CoreView[MissionsSelection](
        asds_attempts: Option[Int],
        asds_landings: Option[Int],
        block: Option[Int],
        id: Option[String],
        missions: Option[List[Option[MissionsSelection]]],
        original_launch: Option[Date],
        reuse_count: Option[Int],
        rtls_attempts: Option[Int],
        rtls_landings: Option[Int],
        status: Option[String],
        water_landing: Option[Boolean]
    )

    type ViewSelection[MissionsSelection] =
      SelectionBuilder[Core, CoreView[MissionsSelection]]

    def view[MissionsSelection](
        missionsSelection: SelectionBuilder[CapsuleMission, MissionsSelection]
    ): ViewSelection[MissionsSelection] =
      (asds_attempts ~ asds_landings ~ block ~ id ~ missions(
        missionsSelection
      ) ~ original_launch ~ reuse_count ~ rtls_attempts ~ rtls_landings ~ status ~ water_landing)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (((asds_attempts, asds_landings), block), id),
                            missions
                          ),
                          original_launch
                        ),
                        reuse_count
                      ),
                      rtls_attempts
                    ),
                    rtls_landings
                  ),
                  status
                ),
                water_landing
              ) =>
            CoreView(
              asds_attempts,
              asds_landings,
              block,
              id,
              missions,
              original_launch,
              reuse_count,
              rtls_attempts,
              rtls_landings,
              status,
              water_landing
            )
        }

    def asds_attempts: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("asds_attempts", OptionOf(Scalar()))
    def asds_landings: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("asds_landings", OptionOf(Scalar()))
    def block: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("block", OptionOf(Scalar()))
    def id: SelectionBuilder[Core, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def missions[A](
        innerSelection: SelectionBuilder[CapsuleMission, A]
    ): SelectionBuilder[Core, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("missions", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def original_launch: SelectionBuilder[Core, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("original_launch", OptionOf(Scalar()))
    def reuse_count: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reuse_count", OptionOf(Scalar()))
    def rtls_attempts: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rtls_attempts", OptionOf(Scalar()))
    def rtls_landings: SelectionBuilder[Core, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rtls_landings", OptionOf(Scalar()))
    def status: SelectionBuilder[Core, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def water_landing: SelectionBuilder[Core, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("water_landing", OptionOf(Scalar()))
  }

  type History
  object History {

    final case class HistoryView[LinksSelection, FlightSelection](
        details: Option[String],
        event_date_unix: Option[Date],
        event_date_utc: Option[Date],
        id: Option[String],
        links: Option[LinksSelection],
        title: Option[String],
        flight: Option[FlightSelection]
    )

    type ViewSelection[LinksSelection, FlightSelection] =
      SelectionBuilder[History, HistoryView[LinksSelection, FlightSelection]]

    def view[LinksSelection, FlightSelection](
        linksSelection: SelectionBuilder[Link, LinksSelection],
        flightSelection: SelectionBuilder[Launch, FlightSelection]
    ): ViewSelection[LinksSelection, FlightSelection] =
      (details ~ event_date_unix ~ event_date_utc ~ id ~ links(
        linksSelection
      ) ~ title ~ flight(flightSelection)).map {
        case (
              (
                ((((details, event_date_unix), event_date_utc), id), links),
                title
              ),
              flight
            ) =>
          HistoryView(
            details,
            event_date_unix,
            event_date_utc,
            id,
            links,
            title,
            flight
          )
      }

    def details: SelectionBuilder[History, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("details", OptionOf(Scalar()))
    def event_date_unix: SelectionBuilder[History, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("event_date_unix", OptionOf(Scalar()))
    def event_date_utc: SelectionBuilder[History, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("event_date_utc", OptionOf(Scalar()))
    def id: SelectionBuilder[History, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def links[A](
        innerSelection: SelectionBuilder[Link, A]
    ): SelectionBuilder[History, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("links", OptionOf(Obj(innerSelection)))
    def title: SelectionBuilder[History, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("title", OptionOf(Scalar()))
    def flight[A](
        innerSelection: SelectionBuilder[Launch, A]
    ): SelectionBuilder[History, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("flight", OptionOf(Obj(innerSelection)))
  }

  type Link
  object Link {

    final case class LinkView(
        article: Option[String],
        reddit: Option[String],
        wikipedia: Option[String]
    )

    type ViewSelection = SelectionBuilder[Link, LinkView]

    def view: ViewSelection = (article ~ reddit ~ wikipedia).map {
      case ((article, reddit), wikipedia) =>
        LinkView(article, reddit, wikipedia)
    }

    def article: SelectionBuilder[Link, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("article", OptionOf(Scalar()))
    def reddit: SelectionBuilder[Link, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("reddit", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Link, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type Launch
  object Launch {

    final case class LaunchView[
        Launch_siteSelection,
        LinksSelection,
        RocketSelection,
        TelemetrySelection,
        ShipsSelection
    ](
        details: Option[String],
        id: Option[String],
        is_tentative: Option[Boolean],
        launch_date_local: Option[Date],
        launch_date_unix: Option[Date],
        launch_date_utc: Option[Date],
        launch_site: Option[Launch_siteSelection],
        launch_success: Option[Boolean],
        launch_year: Option[String],
        links: Option[LinksSelection],
        mission_id: Option[List[Option[String]]],
        mission_name: Option[String],
        rocket: Option[RocketSelection],
        static_fire_date_unix: Option[Date],
        static_fire_date_utc: Option[Date],
        telemetry: Option[TelemetrySelection],
        tentative_max_precision: Option[String],
        upcoming: Option[Boolean],
        ships: Option[List[Option[ShipsSelection]]]
    )

    type ViewSelection[
        Launch_siteSelection,
        LinksSelection,
        RocketSelection,
        TelemetrySelection,
        ShipsSelection
    ] = SelectionBuilder[Launch, LaunchView[
      Launch_siteSelection,
      LinksSelection,
      RocketSelection,
      TelemetrySelection,
      ShipsSelection
    ]]

    def view[
        Launch_siteSelection,
        LinksSelection,
        RocketSelection,
        TelemetrySelection,
        ShipsSelection
    ](
        launch_siteSelection: SelectionBuilder[
          LaunchSite,
          Launch_siteSelection
        ],
        linksSelection: SelectionBuilder[LaunchLinks, LinksSelection],
        rocketSelection: SelectionBuilder[LaunchRocket, RocketSelection],
        telemetrySelection: SelectionBuilder[
          LaunchTelemetry,
          TelemetrySelection
        ],
        shipsSelection: SelectionBuilder[Ship, ShipsSelection]
    ): ViewSelection[
      Launch_siteSelection,
      LinksSelection,
      RocketSelection,
      TelemetrySelection,
      ShipsSelection
    ] =
      (details ~ id ~ is_tentative ~ launch_date_local ~ launch_date_unix ~ launch_date_utc ~ launch_site(
        launch_siteSelection
      ) ~ launch_success ~ launch_year ~ links(
        linksSelection
      ) ~ mission_id ~ mission_name ~ rocket(
        rocketSelection
      ) ~ static_fire_date_unix ~ static_fire_date_utc ~ telemetry(
        telemetrySelection
      ) ~ tentative_max_precision ~ upcoming ~ ships(shipsSelection)).map {
        case (
              (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            ((details, id), is_tentative),
                                            launch_date_local
                                          ),
                                          launch_date_unix
                                        ),
                                        launch_date_utc
                                      ),
                                      launch_site
                                    ),
                                    launch_success
                                  ),
                                  launch_year
                                ),
                                links
                              ),
                              mission_id
                            ),
                            mission_name
                          ),
                          rocket
                        ),
                        static_fire_date_unix
                      ),
                      static_fire_date_utc
                    ),
                    telemetry
                  ),
                  tentative_max_precision
                ),
                upcoming
              ),
              ships
            ) =>
          LaunchView(
            details,
            id,
            is_tentative,
            launch_date_local,
            launch_date_unix,
            launch_date_utc,
            launch_site,
            launch_success,
            launch_year,
            links,
            mission_id,
            mission_name,
            rocket,
            static_fire_date_unix,
            static_fire_date_utc,
            telemetry,
            tentative_max_precision,
            upcoming,
            ships
          )
      }

    def details: SelectionBuilder[Launch, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("details", OptionOf(Scalar()))
    def id: SelectionBuilder[Launch, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def is_tentative: SelectionBuilder[Launch, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("is_tentative", OptionOf(Scalar()))
    def launch_date_local: SelectionBuilder[Launch, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_date_local", OptionOf(Scalar()))
    def launch_date_unix: SelectionBuilder[Launch, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_date_unix", OptionOf(Scalar()))
    def launch_date_utc: SelectionBuilder[Launch, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_date_utc", OptionOf(Scalar()))
    def launch_site[A](
        innerSelection: SelectionBuilder[LaunchSite, A]
    ): SelectionBuilder[Launch, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_site", OptionOf(Obj(innerSelection)))
    def launch_success: SelectionBuilder[Launch, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_success", OptionOf(Scalar()))
    def launch_year: SelectionBuilder[Launch, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_year", OptionOf(Scalar()))
    def links[A](
        innerSelection: SelectionBuilder[LaunchLinks, A]
    ): SelectionBuilder[Launch, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("links", OptionOf(Obj(innerSelection)))
    def mission_id: SelectionBuilder[Launch, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mission_id", OptionOf(ListOf(OptionOf(Scalar()))))
    def mission_name: SelectionBuilder[Launch, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mission_name", OptionOf(Scalar()))
    def rocket[A](
        innerSelection: SelectionBuilder[LaunchRocket, A]
    ): SelectionBuilder[Launch, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rocket", OptionOf(Obj(innerSelection)))
    def static_fire_date_unix: SelectionBuilder[Launch, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("static_fire_date_unix", OptionOf(Scalar()))
    def static_fire_date_utc: SelectionBuilder[Launch, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("static_fire_date_utc", OptionOf(Scalar()))
    def telemetry[A](
        innerSelection: SelectionBuilder[LaunchTelemetry, A]
    ): SelectionBuilder[Launch, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("telemetry", OptionOf(Obj(innerSelection)))
    def tentative_max_precision: SelectionBuilder[Launch, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("tentative_max_precision", OptionOf(Scalar()))
    def upcoming: SelectionBuilder[Launch, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("upcoming", OptionOf(Scalar()))
    def ships[A](
        innerSelection: SelectionBuilder[Ship, A]
    ): SelectionBuilder[Launch, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("ships", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type LaunchSite
  object LaunchSite {

    final case class LaunchSiteView(
        site_id: Option[String],
        site_name_long: Option[String],
        site_name: Option[String]
    )

    type ViewSelection = SelectionBuilder[LaunchSite, LaunchSiteView]

    def view: ViewSelection = (site_id ~ site_name_long ~ site_name).map {
      case ((site_id, site_name_long), site_name) =>
        LaunchSiteView(site_id, site_name_long, site_name)
    }

    def site_id: SelectionBuilder[LaunchSite, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("site_id", OptionOf(Scalar()))
    def site_name_long: SelectionBuilder[LaunchSite, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("site_name_long", OptionOf(Scalar()))
    def site_name: SelectionBuilder[LaunchSite, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("site_name", OptionOf(Scalar()))
  }

  type LaunchLinks
  object LaunchLinks {

    final case class LaunchLinksView(
        article_link: Option[String],
        flickr_images: Option[List[Option[String]]],
        mission_patch_small: Option[String],
        mission_patch: Option[String],
        presskit: Option[String],
        reddit_campaign: Option[String],
        reddit_launch: Option[String],
        reddit_media: Option[String],
        reddit_recovery: Option[String],
        video_link: Option[String],
        wikipedia: Option[String]
    )

    type ViewSelection = SelectionBuilder[LaunchLinks, LaunchLinksView]

    def view: ViewSelection =
      (article_link ~ flickr_images ~ mission_patch_small ~ mission_patch ~ presskit ~ reddit_campaign ~ reddit_launch ~ reddit_media ~ reddit_recovery ~ video_link ~ wikipedia)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (article_link, flickr_images),
                                mission_patch_small
                              ),
                              mission_patch
                            ),
                            presskit
                          ),
                          reddit_campaign
                        ),
                        reddit_launch
                      ),
                      reddit_media
                    ),
                    reddit_recovery
                  ),
                  video_link
                ),
                wikipedia
              ) =>
            LaunchLinksView(
              article_link,
              flickr_images,
              mission_patch_small,
              mission_patch,
              presskit,
              reddit_campaign,
              reddit_launch,
              reddit_media,
              reddit_recovery,
              video_link,
              wikipedia
            )
        }

    def article_link: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("article_link", OptionOf(Scalar()))
    def flickr_images
        : SelectionBuilder[LaunchLinks, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("flickr_images", OptionOf(ListOf(OptionOf(Scalar()))))
    def mission_patch_small: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mission_patch_small", OptionOf(Scalar()))
    def mission_patch: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mission_patch", OptionOf(Scalar()))
    def presskit: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("presskit", OptionOf(Scalar()))
    def reddit_campaign: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reddit_campaign", OptionOf(Scalar()))
    def reddit_launch: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reddit_launch", OptionOf(Scalar()))
    def reddit_media: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reddit_media", OptionOf(Scalar()))
    def reddit_recovery: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reddit_recovery", OptionOf(Scalar()))
    def video_link: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("video_link", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[LaunchLinks, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type LaunchRocket
  object LaunchRocket {

    final case class LaunchRocketView[
        FairingsSelection,
        First_stageSelection,
        RocketSelection,
        Second_stageSelection
    ](
        fairings: Option[FairingsSelection],
        first_stage: Option[First_stageSelection],
        rocket_name: Option[String],
        rocket_type: Option[String],
        rocket: Option[RocketSelection],
        second_stage: Option[Second_stageSelection]
    )

    type ViewSelection[
        FairingsSelection,
        First_stageSelection,
        RocketSelection,
        Second_stageSelection
    ] = SelectionBuilder[LaunchRocket, LaunchRocketView[
      FairingsSelection,
      First_stageSelection,
      RocketSelection,
      Second_stageSelection
    ]]

    def view[
        FairingsSelection,
        First_stageSelection,
        RocketSelection,
        Second_stageSelection
    ](
        fairingsSelection: SelectionBuilder[
          LaunchRocketFairings,
          FairingsSelection
        ],
        first_stageSelection: SelectionBuilder[
          LaunchRocketFirstStage,
          First_stageSelection
        ],
        rocketSelection: SelectionBuilder[Rocket, RocketSelection],
        second_stageSelection: SelectionBuilder[
          LaunchRocketSecondStage,
          Second_stageSelection
        ]
    ): ViewSelection[
      FairingsSelection,
      First_stageSelection,
      RocketSelection,
      Second_stageSelection
    ] = (fairings(fairingsSelection) ~ first_stage(
      first_stageSelection
    ) ~ rocket_name ~ rocket_type ~ rocket(rocketSelection) ~ second_stage(
      second_stageSelection
    )).map {
      case (
            ((((fairings, first_stage), rocket_name), rocket_type), rocket),
            second_stage
          ) =>
        LaunchRocketView(
          fairings,
          first_stage,
          rocket_name,
          rocket_type,
          rocket,
          second_stage
        )
    }

    def fairings[A](
        innerSelection: SelectionBuilder[LaunchRocketFairings, A]
    ): SelectionBuilder[LaunchRocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("fairings", OptionOf(Obj(innerSelection)))
    def first_stage[A](
        innerSelection: SelectionBuilder[LaunchRocketFirstStage, A]
    ): SelectionBuilder[LaunchRocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("first_stage", OptionOf(Obj(innerSelection)))
    def rocket_name: SelectionBuilder[LaunchRocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rocket_name", OptionOf(Scalar()))
    def rocket_type: SelectionBuilder[LaunchRocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rocket_type", OptionOf(Scalar()))
    def rocket[A](
        innerSelection: SelectionBuilder[Rocket, A]
    ): SelectionBuilder[LaunchRocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("rocket", OptionOf(Obj(innerSelection)))
    def second_stage[A](
        innerSelection: SelectionBuilder[LaunchRocketSecondStage, A]
    ): SelectionBuilder[LaunchRocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("second_stage", OptionOf(Obj(innerSelection)))
  }

  type LaunchRocketFairings
  object LaunchRocketFairings {

    final case class LaunchRocketFairingsView(
        recovered: Option[Boolean],
        recovery_attempt: Option[Boolean],
        reused: Option[Boolean],
        ship: Option[String]
    )

    type ViewSelection =
      SelectionBuilder[LaunchRocketFairings, LaunchRocketFairingsView]

    def view: ViewSelection =
      (recovered ~ recovery_attempt ~ reused ~ ship).map {
        case (((recovered, recovery_attempt), reused), ship) =>
          LaunchRocketFairingsView(recovered, recovery_attempt, reused, ship)
      }

    def recovered: SelectionBuilder[LaunchRocketFairings, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("recovered", OptionOf(Scalar()))
    def recovery_attempt
        : SelectionBuilder[LaunchRocketFairings, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("recovery_attempt", OptionOf(Scalar()))
    def reused: SelectionBuilder[LaunchRocketFairings, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("reused", OptionOf(Scalar()))
    def ship: SelectionBuilder[LaunchRocketFairings, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("ship", OptionOf(Scalar()))
  }

  type LaunchRocketFirstStage
  object LaunchRocketFirstStage {

    final case class LaunchRocketFirstStageView[CoresSelection](
        cores: Option[List[Option[CoresSelection]]]
    )

    type ViewSelection[CoresSelection] =
      SelectionBuilder[LaunchRocketFirstStage, LaunchRocketFirstStageView[
        CoresSelection
      ]]

    def view[CoresSelection](
        coresSelection: SelectionBuilder[
          LaunchRocketFirstStageCore,
          CoresSelection
        ]
    ): ViewSelection[CoresSelection] =
      cores(coresSelection).map(cores => LaunchRocketFirstStageView(cores))

    def cores[A](
        innerSelection: SelectionBuilder[LaunchRocketFirstStageCore, A]
    ): SelectionBuilder[LaunchRocketFirstStage, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cores", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type LaunchRocketFirstStageCore
  object LaunchRocketFirstStageCore {

    final case class LaunchRocketFirstStageCoreView[CoreSelection](
        block: Option[Int],
        core: Option[CoreSelection],
        flight: Option[Int],
        gridfins: Option[Boolean],
        land_success: Option[Boolean],
        landing_intent: Option[Boolean],
        landing_type: Option[String],
        landing_vehicle: Option[String],
        legs: Option[Boolean],
        reused: Option[Boolean]
    )

    type ViewSelection[CoreSelection] = SelectionBuilder[
      LaunchRocketFirstStageCore,
      LaunchRocketFirstStageCoreView[CoreSelection]
    ]

    def view[CoreSelection](
        coreSelection: SelectionBuilder[Core, CoreSelection]
    ): ViewSelection[CoreSelection] = (block ~ core(
      coreSelection
    ) ~ flight ~ gridfins ~ land_success ~ landing_intent ~ landing_type ~ landing_vehicle ~ legs ~ reused)
      .map {
        case (
              (
                (
                  (
                    (
                      ((((block, core), flight), gridfins), land_success),
                      landing_intent
                    ),
                    landing_type
                  ),
                  landing_vehicle
                ),
                legs
              ),
              reused
            ) =>
          LaunchRocketFirstStageCoreView(
            block,
            core,
            flight,
            gridfins,
            land_success,
            landing_intent,
            landing_type,
            landing_vehicle,
            legs,
            reused
          )
      }

    def block: SelectionBuilder[LaunchRocketFirstStageCore, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("block", OptionOf(Scalar()))
    def core[A](
        innerSelection: SelectionBuilder[Core, A]
    ): SelectionBuilder[LaunchRocketFirstStageCore, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("core", OptionOf(Obj(innerSelection)))
    def flight: SelectionBuilder[LaunchRocketFirstStageCore, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("flight", OptionOf(Scalar()))
    def gridfins
        : SelectionBuilder[LaunchRocketFirstStageCore, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("gridfins", OptionOf(Scalar()))
    def land_success
        : SelectionBuilder[LaunchRocketFirstStageCore, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("land_success", OptionOf(Scalar()))
    def landing_intent
        : SelectionBuilder[LaunchRocketFirstStageCore, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landing_intent", OptionOf(Scalar()))
    def landing_type
        : SelectionBuilder[LaunchRocketFirstStageCore, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landing_type", OptionOf(Scalar()))
    def landing_vehicle
        : SelectionBuilder[LaunchRocketFirstStageCore, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landing_vehicle", OptionOf(Scalar()))
    def legs: SelectionBuilder[LaunchRocketFirstStageCore, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("legs", OptionOf(Scalar()))
    def reused: SelectionBuilder[LaunchRocketFirstStageCore, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("reused", OptionOf(Scalar()))
  }

  type Rocket
  object Rocket {

    final case class RocketView[
        DiameterSelection,
        EnginesSelection,
        First_stageSelection,
        HeightSelection,
        Landing_legsSelection,
        MassSelection,
        Payload_weightsSelection,
        Second_stageSelection
    ](
        active: Option[Boolean],
        boosters: Option[Int],
        company: Option[String],
        cost_per_launch: Option[Int],
        country: Option[String],
        description: Option[String],
        diameter: Option[DiameterSelection],
        engines: Option[EnginesSelection],
        first_flight: Option[Date],
        first_stage: Option[First_stageSelection],
        height: Option[HeightSelection],
        id: Option[String],
        landing_legs: Option[Landing_legsSelection],
        mass: Option[MassSelection],
        name: Option[String],
        payload_weights: Option[List[Option[Payload_weightsSelection]]],
        second_stage: Option[Second_stageSelection],
        stages: Option[Int],
        success_rate_pct: Option[Int],
        `type`: Option[String],
        wikipedia: Option[String]
    )

    type ViewSelection[
        DiameterSelection,
        EnginesSelection,
        First_stageSelection,
        HeightSelection,
        Landing_legsSelection,
        MassSelection,
        Payload_weightsSelection,
        Second_stageSelection
    ] = SelectionBuilder[Rocket, RocketView[
      DiameterSelection,
      EnginesSelection,
      First_stageSelection,
      HeightSelection,
      Landing_legsSelection,
      MassSelection,
      Payload_weightsSelection,
      Second_stageSelection
    ]]

    def view[
        DiameterSelection,
        EnginesSelection,
        First_stageSelection,
        HeightSelection,
        Landing_legsSelection,
        MassSelection,
        Payload_weightsSelection,
        Second_stageSelection
    ](
        diameterSelection: SelectionBuilder[Distance, DiameterSelection],
        enginesSelection: SelectionBuilder[RocketEngines, EnginesSelection],
        first_stageSelection: SelectionBuilder[
          RocketFirstStage,
          First_stageSelection
        ],
        heightSelection: SelectionBuilder[Distance, HeightSelection],
        landing_legsSelection: SelectionBuilder[
          RocketLandingLegs,
          Landing_legsSelection
        ],
        massSelection: SelectionBuilder[Mass, MassSelection],
        payload_weightsSelection: SelectionBuilder[
          RocketPayloadWeight,
          Payload_weightsSelection
        ],
        second_stageSelection: SelectionBuilder[
          RocketSecondStage,
          Second_stageSelection
        ]
    ): ViewSelection[
      DiameterSelection,
      EnginesSelection,
      First_stageSelection,
      HeightSelection,
      Landing_legsSelection,
      MassSelection,
      Payload_weightsSelection,
      Second_stageSelection
    ] =
      (active ~ boosters ~ company ~ cost_per_launch ~ country ~ description ~ diameter(
        diameterSelection
      ) ~ engines(enginesSelection) ~ first_flight ~ first_stage(
        first_stageSelection
      ) ~ height(heightSelection) ~ id ~ landing_legs(
        landing_legsSelection
      ) ~ mass(massSelection) ~ name ~ payload_weights(
        payload_weightsSelection
      ) ~ second_stage(
        second_stageSelection
      ) ~ stages ~ success_rate_pct ~ `type` ~ wikipedia).map {
        case (
              (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            (
                                              (
                                                ((active, boosters), company),
                                                cost_per_launch
                                              ),
                                              country
                                            ),
                                            description
                                          ),
                                          diameter
                                        ),
                                        engines
                                      ),
                                      first_flight
                                    ),
                                    first_stage
                                  ),
                                  height
                                ),
                                id
                              ),
                              landing_legs
                            ),
                            mass
                          ),
                          name
                        ),
                        payload_weights
                      ),
                      second_stage
                    ),
                    stages
                  ),
                  success_rate_pct
                ),
                type$
              ),
              wikipedia
            ) =>
          RocketView(
            active,
            boosters,
            company,
            cost_per_launch,
            country,
            description,
            diameter,
            engines,
            first_flight,
            first_stage,
            height,
            id,
            landing_legs,
            mass,
            name,
            payload_weights,
            second_stage,
            stages,
            success_rate_pct,
            type$,
            wikipedia
          )
      }

    def active: SelectionBuilder[Rocket, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("active", OptionOf(Scalar()))
    def boosters: SelectionBuilder[Rocket, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("boosters", OptionOf(Scalar()))
    def company: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("company", OptionOf(Scalar()))
    def cost_per_launch: SelectionBuilder[Rocket, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("cost_per_launch", OptionOf(Scalar()))
    def country: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("country", OptionOf(Scalar()))
    def description: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def diameter[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("diameter", OptionOf(Obj(innerSelection)))
    def engines[A](
        innerSelection: SelectionBuilder[RocketEngines, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("engines", OptionOf(Obj(innerSelection)))
    def first_flight: SelectionBuilder[Rocket, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("first_flight", OptionOf(Scalar()))
    def first_stage[A](
        innerSelection: SelectionBuilder[RocketFirstStage, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("first_stage", OptionOf(Obj(innerSelection)))
    def height[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("height", OptionOf(Obj(innerSelection)))
    def id: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def landing_legs[A](
        innerSelection: SelectionBuilder[RocketLandingLegs, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landing_legs", OptionOf(Obj(innerSelection)))
    def mass[A](
        innerSelection: SelectionBuilder[Mass, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mass", OptionOf(Obj(innerSelection)))
    def name: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def payload_weights[A](
        innerSelection: SelectionBuilder[RocketPayloadWeight, A]
    ): SelectionBuilder[Rocket, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "payload_weights",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def second_stage[A](
        innerSelection: SelectionBuilder[RocketSecondStage, A]
    ): SelectionBuilder[Rocket, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("second_stage", OptionOf(Obj(innerSelection)))
    def stages: SelectionBuilder[Rocket, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("stages", OptionOf(Scalar()))
    def success_rate_pct: SelectionBuilder[Rocket, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("success_rate_pct", OptionOf(Scalar()))
    def `type`: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Rocket, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type RocketEngines
  object RocketEngines {

    final case class RocketEnginesView[
        Thrust_sea_levelSelection,
        Thrust_vacuumSelection
    ](
        number: Option[Int],
        `type`: Option[String],
        version: Option[String],
        layout: Option[String],
        engine_loss_max: Option[String],
        propellant_1: Option[String],
        propellant_2: Option[String],
        thrust_sea_level: Option[Thrust_sea_levelSelection],
        thrust_vacuum: Option[Thrust_vacuumSelection],
        thrust_to_weight: Option[Double]
    )

    type ViewSelection[Thrust_sea_levelSelection, Thrust_vacuumSelection] =
      SelectionBuilder[
        RocketEngines,
        RocketEnginesView[Thrust_sea_levelSelection, Thrust_vacuumSelection]
      ]

    def view[Thrust_sea_levelSelection, Thrust_vacuumSelection](
        thrust_sea_levelSelection: SelectionBuilder[
          Force,
          Thrust_sea_levelSelection
        ],
        thrust_vacuumSelection: SelectionBuilder[Force, Thrust_vacuumSelection]
    ): ViewSelection[Thrust_sea_levelSelection, Thrust_vacuumSelection] =
      (number ~ `type` ~ version ~ layout ~ engine_loss_max ~ propellant_1 ~ propellant_2 ~ thrust_sea_level(
        thrust_sea_levelSelection
      ) ~ thrust_vacuum(thrust_vacuumSelection) ~ thrust_to_weight).map {
        case (
              (
                (
                  (
                    (
                      ((((number, type$), version), layout), engine_loss_max),
                      propellant_1
                    ),
                    propellant_2
                  ),
                  thrust_sea_level
                ),
                thrust_vacuum
              ),
              thrust_to_weight
            ) =>
          RocketEnginesView(
            number,
            type$,
            version,
            layout,
            engine_loss_max,
            propellant_1,
            propellant_2,
            thrust_sea_level,
            thrust_vacuum,
            thrust_to_weight
          )
      }

    def number: SelectionBuilder[RocketEngines, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("number", OptionOf(Scalar()))
    def `type`: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
    def version: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("version", OptionOf(Scalar()))
    def layout: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("layout", OptionOf(Scalar()))
    def engine_loss_max: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("engine_loss_max", OptionOf(Scalar()))
    def propellant_1: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("propellant_1", OptionOf(Scalar()))
    def propellant_2: SelectionBuilder[RocketEngines, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("propellant_2", OptionOf(Scalar()))
    def thrust_sea_level[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[RocketEngines, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust_sea_level", OptionOf(Obj(innerSelection)))
    def thrust_vacuum[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[RocketEngines, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust_vacuum", OptionOf(Obj(innerSelection)))
    def thrust_to_weight: SelectionBuilder[RocketEngines, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust_to_weight", OptionOf(Scalar()))
  }

  type RocketFirstStage
  object RocketFirstStage {

    final case class RocketFirstStageView[
        Thrust_sea_levelSelection,
        Thrust_vacuumSelection
    ](
        burn_time_sec: Option[Int],
        engines: Option[Int],
        fuel_amount_tons: Option[Double],
        reusable: Option[Boolean],
        thrust_sea_level: Option[Thrust_sea_levelSelection],
        thrust_vacuum: Option[Thrust_vacuumSelection]
    )

    type ViewSelection[Thrust_sea_levelSelection, Thrust_vacuumSelection] =
      SelectionBuilder[
        RocketFirstStage,
        RocketFirstStageView[Thrust_sea_levelSelection, Thrust_vacuumSelection]
      ]

    def view[Thrust_sea_levelSelection, Thrust_vacuumSelection](
        thrust_sea_levelSelection: SelectionBuilder[
          Force,
          Thrust_sea_levelSelection
        ],
        thrust_vacuumSelection: SelectionBuilder[Force, Thrust_vacuumSelection]
    ): ViewSelection[Thrust_sea_levelSelection, Thrust_vacuumSelection] =
      (burn_time_sec ~ engines ~ fuel_amount_tons ~ reusable ~ thrust_sea_level(
        thrust_sea_levelSelection
      ) ~ thrust_vacuum(thrust_vacuumSelection)).map {
        case (
              (
                (((burn_time_sec, engines), fuel_amount_tons), reusable),
                thrust_sea_level
              ),
              thrust_vacuum
            ) =>
          RocketFirstStageView(
            burn_time_sec,
            engines,
            fuel_amount_tons,
            reusable,
            thrust_sea_level,
            thrust_vacuum
          )
      }

    def burn_time_sec: SelectionBuilder[RocketFirstStage, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("burn_time_sec", OptionOf(Scalar()))
    def engines: SelectionBuilder[RocketFirstStage, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("engines", OptionOf(Scalar()))
    def fuel_amount_tons: SelectionBuilder[RocketFirstStage, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("fuel_amount_tons", OptionOf(Scalar()))
    def reusable: SelectionBuilder[RocketFirstStage, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reusable", OptionOf(Scalar()))
    def thrust_sea_level[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[RocketFirstStage, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust_sea_level", OptionOf(Obj(innerSelection)))
    def thrust_vacuum[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[RocketFirstStage, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust_vacuum", OptionOf(Obj(innerSelection)))
  }

  type RocketLandingLegs
  object RocketLandingLegs {

    final case class RocketLandingLegsView(
        number: Option[Int],
        material: Option[String]
    )

    type ViewSelection =
      SelectionBuilder[RocketLandingLegs, RocketLandingLegsView]

    def view: ViewSelection = (number ~ material).map {
      case (number, material) => RocketLandingLegsView(number, material)
    }

    def number: SelectionBuilder[RocketLandingLegs, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("number", OptionOf(Scalar()))
    def material: SelectionBuilder[RocketLandingLegs, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("material", OptionOf(Scalar()))
  }

  type RocketPayloadWeight
  object RocketPayloadWeight {

    final case class RocketPayloadWeightView(
        id: Option[String],
        kg: Option[Int],
        lb: Option[Int],
        name: Option[String]
    )

    type ViewSelection =
      SelectionBuilder[RocketPayloadWeight, RocketPayloadWeightView]

    def view: ViewSelection = (id ~ kg ~ lb ~ name).map {
      case (((id, kg), lb), name) => RocketPayloadWeightView(id, kg, lb, name)
    }

    def id: SelectionBuilder[RocketPayloadWeight, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def kg: SelectionBuilder[RocketPayloadWeight, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("kg", OptionOf(Scalar()))
    def lb: SelectionBuilder[RocketPayloadWeight, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("lb", OptionOf(Scalar()))
    def name: SelectionBuilder[RocketPayloadWeight, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
  }

  type RocketSecondStage
  object RocketSecondStage {

    final case class RocketSecondStageView[PayloadsSelection, ThrustSelection](
        burn_time_sec: Option[Int],
        engines: Option[Int],
        fuel_amount_tons: Option[Double],
        payloads: Option[PayloadsSelection],
        thrust: Option[ThrustSelection]
    )

    type ViewSelection[PayloadsSelection, ThrustSelection] = SelectionBuilder[
      RocketSecondStage,
      RocketSecondStageView[PayloadsSelection, ThrustSelection]
    ]

    def view[PayloadsSelection, ThrustSelection](
        payloadsSelection: SelectionBuilder[
          RocketSecondStagePayloads,
          PayloadsSelection
        ],
        thrustSelection: SelectionBuilder[Force, ThrustSelection]
    ): ViewSelection[PayloadsSelection, ThrustSelection] =
      (burn_time_sec ~ engines ~ fuel_amount_tons ~ payloads(
        payloadsSelection
      ) ~ thrust(thrustSelection)).map {
        case (
              (((burn_time_sec, engines), fuel_amount_tons), payloads),
              thrust
            ) =>
          RocketSecondStageView(
            burn_time_sec,
            engines,
            fuel_amount_tons,
            payloads,
            thrust
          )
      }

    def burn_time_sec: SelectionBuilder[RocketSecondStage, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("burn_time_sec", OptionOf(Scalar()))
    def engines: SelectionBuilder[RocketSecondStage, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("engines", OptionOf(Scalar()))
    def fuel_amount_tons: SelectionBuilder[RocketSecondStage, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("fuel_amount_tons", OptionOf(Scalar()))
    def payloads[A](
        innerSelection: SelectionBuilder[RocketSecondStagePayloads, A]
    ): SelectionBuilder[RocketSecondStage, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payloads", OptionOf(Obj(innerSelection)))
    def thrust[A](
        innerSelection: SelectionBuilder[Force, A]
    ): SelectionBuilder[RocketSecondStage, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thrust", OptionOf(Obj(innerSelection)))
  }

  type RocketSecondStagePayloads
  object RocketSecondStagePayloads {

    final case class RocketSecondStagePayloadsView[Composite_fairingSelection](
        option_1: Option[String],
        composite_fairing: Option[Composite_fairingSelection]
    )

    type ViewSelection[Composite_fairingSelection] =
      SelectionBuilder[RocketSecondStagePayloads, RocketSecondStagePayloadsView[
        Composite_fairingSelection
      ]]

    def view[Composite_fairingSelection](
        composite_fairingSelection: SelectionBuilder[
          RocketSecondStagePayloadCompositeFairing,
          Composite_fairingSelection
        ]
    ): ViewSelection[Composite_fairingSelection] =
      (option_1 ~ composite_fairing(composite_fairingSelection)).map {
        case (option_1, composite_fairing) =>
          RocketSecondStagePayloadsView(option_1, composite_fairing)
      }

    def option_1: SelectionBuilder[RocketSecondStagePayloads, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("option_1", OptionOf(Scalar()))
    def composite_fairing[A](
        innerSelection: SelectionBuilder[
          RocketSecondStagePayloadCompositeFairing,
          A
        ]
    ): SelectionBuilder[RocketSecondStagePayloads, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("composite_fairing", OptionOf(Obj(innerSelection)))
  }

  type RocketSecondStagePayloadCompositeFairing
  object RocketSecondStagePayloadCompositeFairing {

    final case class RocketSecondStagePayloadCompositeFairingView[
        HeightSelection,
        DiameterSelection
    ](height: Option[HeightSelection], diameter: Option[DiameterSelection])

    type ViewSelection[HeightSelection, DiameterSelection] = SelectionBuilder[
      RocketSecondStagePayloadCompositeFairing,
      RocketSecondStagePayloadCompositeFairingView[
        HeightSelection,
        DiameterSelection
      ]
    ]

    def view[HeightSelection, DiameterSelection](
        heightSelection: SelectionBuilder[Distance, HeightSelection],
        diameterSelection: SelectionBuilder[Distance, DiameterSelection]
    ): ViewSelection[HeightSelection, DiameterSelection] =
      (height(heightSelection) ~ diameter(diameterSelection)).map {
        case (height, diameter) =>
          RocketSecondStagePayloadCompositeFairingView(height, diameter)
      }

    def height[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[RocketSecondStagePayloadCompositeFairing, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("height", OptionOf(Obj(innerSelection)))
    def diameter[A](
        innerSelection: SelectionBuilder[Distance, A]
    ): SelectionBuilder[RocketSecondStagePayloadCompositeFairing, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("diameter", OptionOf(Obj(innerSelection)))
  }

  type LaunchRocketSecondStage
  object LaunchRocketSecondStage {

    final case class LaunchRocketSecondStageView[PayloadsSelection](
        block: Option[Int],
        payloads: Option[List[Option[PayloadsSelection]]]
    )

    type ViewSelection[PayloadsSelection] =
      SelectionBuilder[LaunchRocketSecondStage, LaunchRocketSecondStageView[
        PayloadsSelection
      ]]

    def view[PayloadsSelection](
        payloadsSelection: SelectionBuilder[Payload, PayloadsSelection]
    ): ViewSelection[PayloadsSelection] =
      (block ~ payloads(payloadsSelection)).map { case (block, payloads) =>
        LaunchRocketSecondStageView(block, payloads)
      }

    def block: SelectionBuilder[LaunchRocketSecondStage, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("block", OptionOf(Scalar()))
    def payloads[A](
        innerSelection: SelectionBuilder[Payload, A]
    ): SelectionBuilder[LaunchRocketSecondStage, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payloads", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type Payload
  object Payload {

    final case class PayloadView[Orbit_paramsSelection](
        customers: Option[List[Option[String]]],
        id: Option[String],
        manufacturer: Option[String],
        nationality: Option[String],
        norad_id: Option[List[Option[Int]]],
        orbit_params: Option[Orbit_paramsSelection],
        orbit: Option[String],
        payload_mass_kg: Option[Double],
        payload_mass_lbs: Option[Double],
        payload_type: Option[String],
        reused: Option[Boolean]
    )

    type ViewSelection[Orbit_paramsSelection] =
      SelectionBuilder[Payload, PayloadView[Orbit_paramsSelection]]

    def view[Orbit_paramsSelection](
        orbit_paramsSelection: SelectionBuilder[
          PayloadOrbitParams,
          Orbit_paramsSelection
        ]
    ): ViewSelection[Orbit_paramsSelection] =
      (customers ~ id ~ manufacturer ~ nationality ~ norad_id ~ orbit_params(
        orbit_paramsSelection
      ) ~ orbit ~ payload_mass_kg ~ payload_mass_lbs ~ payload_type ~ reused)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (((customers, id), manufacturer), nationality),
                            norad_id
                          ),
                          orbit_params
                        ),
                        orbit
                      ),
                      payload_mass_kg
                    ),
                    payload_mass_lbs
                  ),
                  payload_type
                ),
                reused
              ) =>
            PayloadView(
              customers,
              id,
              manufacturer,
              nationality,
              norad_id,
              orbit_params,
              orbit,
              payload_mass_kg,
              payload_mass_lbs,
              payload_type,
              reused
            )
        }

    def customers: SelectionBuilder[Payload, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("customers", OptionOf(ListOf(OptionOf(Scalar()))))
    def id: SelectionBuilder[Payload, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def manufacturer: SelectionBuilder[Payload, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("manufacturer", OptionOf(Scalar()))
    def nationality: SelectionBuilder[Payload, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("nationality", OptionOf(Scalar()))
    def norad_id: SelectionBuilder[Payload, Option[List[Option[Int]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("norad_id", OptionOf(ListOf(OptionOf(Scalar()))))
    def orbit_params[A](
        innerSelection: SelectionBuilder[PayloadOrbitParams, A]
    ): SelectionBuilder[Payload, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("orbit_params", OptionOf(Obj(innerSelection)))
    def orbit: SelectionBuilder[Payload, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("orbit", OptionOf(Scalar()))
    def payload_mass_kg: SelectionBuilder[Payload, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payload_mass_kg", OptionOf(Scalar()))
    def payload_mass_lbs: SelectionBuilder[Payload, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payload_mass_lbs", OptionOf(Scalar()))
    def payload_type: SelectionBuilder[Payload, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payload_type", OptionOf(Scalar()))
    def reused: SelectionBuilder[Payload, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("reused", OptionOf(Scalar()))
  }

  type PayloadOrbitParams
  object PayloadOrbitParams {

    final case class PayloadOrbitParamsView(
        apoapsis_km: Option[Double],
        arg_of_pericenter: Option[Double],
        eccentricity: Option[Double],
        epoch: Option[Date],
        inclination_deg: Option[Double],
        lifespan_years: Option[Double],
        longitude: Option[Double],
        mean_anomaly: Option[Double],
        mean_motion: Option[Double],
        periapsis_km: Option[Double],
        period_min: Option[Double],
        raan: Option[Double],
        reference_system: Option[String],
        regime: Option[String],
        semi_major_axis_km: Option[Double]
    )

    type ViewSelection =
      SelectionBuilder[PayloadOrbitParams, PayloadOrbitParamsView]

    def view: ViewSelection =
      (apoapsis_km ~ arg_of_pericenter ~ eccentricity ~ epoch ~ inclination_deg ~ lifespan_years ~ longitude ~ mean_anomaly ~ mean_motion ~ periapsis_km ~ period_min ~ raan ~ reference_system ~ regime ~ semi_major_axis_km)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (apoapsis_km, arg_of_pericenter),
                                        eccentricity
                                      ),
                                      epoch
                                    ),
                                    inclination_deg
                                  ),
                                  lifespan_years
                                ),
                                longitude
                              ),
                              mean_anomaly
                            ),
                            mean_motion
                          ),
                          periapsis_km
                        ),
                        period_min
                      ),
                      raan
                    ),
                    reference_system
                  ),
                  regime
                ),
                semi_major_axis_km
              ) =>
            PayloadOrbitParamsView(
              apoapsis_km,
              arg_of_pericenter,
              eccentricity,
              epoch,
              inclination_deg,
              lifespan_years,
              longitude,
              mean_anomaly,
              mean_motion,
              periapsis_km,
              period_min,
              raan,
              reference_system,
              regime,
              semi_major_axis_km
            )
        }

    def apoapsis_km: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("apoapsis_km", OptionOf(Scalar()))
    def arg_of_pericenter
        : SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("arg_of_pericenter", OptionOf(Scalar()))
    def eccentricity: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("eccentricity", OptionOf(Scalar()))
    def epoch: SelectionBuilder[PayloadOrbitParams, Option[Date]] =
      _root_.caliban.client.SelectionBuilder.Field("epoch", OptionOf(Scalar()))
    def inclination_deg: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("inclination_deg", OptionOf(Scalar()))
    def lifespan_years: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("lifespan_years", OptionOf(Scalar()))
    def longitude: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("longitude", OptionOf(Scalar()))
    def mean_anomaly: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mean_anomaly", OptionOf(Scalar()))
    def mean_motion: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mean_motion", OptionOf(Scalar()))
    def periapsis_km: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("periapsis_km", OptionOf(Scalar()))
    def period_min: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("period_min", OptionOf(Scalar()))
    def raan: SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder.Field("raan", OptionOf(Scalar()))
    def reference_system: SelectionBuilder[PayloadOrbitParams, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("reference_system", OptionOf(Scalar()))
    def regime: SelectionBuilder[PayloadOrbitParams, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("regime", OptionOf(Scalar()))
    def semi_major_axis_km
        : SelectionBuilder[PayloadOrbitParams, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("semi_major_axis_km", OptionOf(Scalar()))
  }

  type LaunchTelemetry
  object LaunchTelemetry {

    final case class LaunchTelemetryView(flight_club: Option[String])

    type ViewSelection = SelectionBuilder[LaunchTelemetry, LaunchTelemetryView]

    def view: ViewSelection =
      flight_club.map(flight_club => LaunchTelemetryView(flight_club))

    def flight_club: SelectionBuilder[LaunchTelemetry, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("flight_club", OptionOf(Scalar()))
  }

  type Ship
  object Ship {

    final case class ShipView[MissionsSelection, PositionSelection](
        abs: Option[Int],
        active: Option[Boolean],
        attempted_landings: Option[Int],
        `class`: Option[Int],
        course_deg: Option[Int],
        home_port: Option[String],
        id: Option[String],
        image: Option[String],
        imo: Option[Int],
        missions: Option[List[Option[MissionsSelection]]],
        mmsi: Option[Int],
        model: Option[String],
        name: Option[String],
        position: Option[PositionSelection],
        roles: Option[List[Option[String]]],
        speed_kn: Option[Double],
        status: Option[String],
        successful_landings: Option[Int],
        `type`: Option[String],
        url: Option[String],
        weight_kg: Option[Int],
        weight_lbs: Option[Int],
        year_built: Option[Int]
    )

    type ViewSelection[MissionsSelection, PositionSelection] =
      SelectionBuilder[Ship, ShipView[MissionsSelection, PositionSelection]]

    def view[MissionsSelection, PositionSelection](
        missionsSelection: SelectionBuilder[ShipMission, MissionsSelection],
        positionSelection: SelectionBuilder[ShipLocation, PositionSelection]
    ): ViewSelection[MissionsSelection, PositionSelection] =
      (abs ~ active ~ attempted_landings ~ `class` ~ course_deg ~ home_port ~ id ~ image ~ imo ~ missions(
        missionsSelection
      ) ~ mmsi ~ model ~ name ~ position(
        positionSelection
      ) ~ roles ~ speed_kn ~ status ~ successful_landings ~ `type` ~ url ~ weight_kg ~ weight_lbs ~ year_built)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            (
                                              (
                                                (
                                                  (
                                                    (
                                                      (
                                                        (abs, active),
                                                        attempted_landings
                                                      ),
                                                      class$
                                                    ),
                                                    course_deg
                                                  ),
                                                  home_port
                                                ),
                                                id
                                              ),
                                              image
                                            ),
                                            imo
                                          ),
                                          missions
                                        ),
                                        mmsi
                                      ),
                                      model
                                    ),
                                    name
                                  ),
                                  position
                                ),
                                roles
                              ),
                              speed_kn
                            ),
                            status
                          ),
                          successful_landings
                        ),
                        type$
                      ),
                      url
                    ),
                    weight_kg
                  ),
                  weight_lbs
                ),
                year_built
              ) =>
            ShipView(
              abs,
              active,
              attempted_landings,
              class$,
              course_deg,
              home_port,
              id,
              image,
              imo,
              missions,
              mmsi,
              model,
              name,
              position,
              roles,
              speed_kn,
              status,
              successful_landings,
              type$,
              url,
              weight_kg,
              weight_lbs,
              year_built
            )
        }

    def abs: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("abs", OptionOf(Scalar()))
    def active: SelectionBuilder[Ship, Option[Boolean]] =
      _root_.caliban.client.SelectionBuilder.Field("active", OptionOf(Scalar()))
    def attempted_landings: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("attempted_landings", OptionOf(Scalar()))
    def `class`: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("class", OptionOf(Scalar()))
    def course_deg: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("course_deg", OptionOf(Scalar()))
    def home_port: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("home_port", OptionOf(Scalar()))
    def id: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def image: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("image", OptionOf(Scalar()))
    def imo: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("imo", OptionOf(Scalar()))
    def missions[A](
        innerSelection: SelectionBuilder[ShipMission, A]
    ): SelectionBuilder[Ship, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("missions", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
    def mmsi: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("mmsi", OptionOf(Scalar()))
    def model: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("models", OptionOf(Scalar()))
    def name: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def position[A](
        innerSelection: SelectionBuilder[ShipLocation, A]
    ): SelectionBuilder[Ship, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("position", OptionOf(Obj(innerSelection)))
    def roles: SelectionBuilder[Ship, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("roles", OptionOf(ListOf(OptionOf(Scalar()))))
    def speed_kn: SelectionBuilder[Ship, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("speed_kn", OptionOf(Scalar()))
    def status: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def successful_landings: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("successful_landings", OptionOf(Scalar()))
    def `type`: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("type", OptionOf(Scalar()))
    def url: SelectionBuilder[Ship, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("url", OptionOf(Scalar()))
    def weight_kg: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("weight_kg", OptionOf(Scalar()))
    def weight_lbs: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("weight_lbs", OptionOf(Scalar()))
    def year_built: SelectionBuilder[Ship, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("year_built", OptionOf(Scalar()))
  }

  type ShipMission
  object ShipMission {

    final case class ShipMissionView(
        flight: Option[String],
        name: Option[String]
    )

    type ViewSelection = SelectionBuilder[ShipMission, ShipMissionView]

    def view: ViewSelection = (flight ~ name).map { case (flight, name) =>
      ShipMissionView(flight, name)
    }

    def flight: SelectionBuilder[ShipMission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("flight", OptionOf(Scalar()))
    def name: SelectionBuilder[ShipMission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
  }

  type ShipLocation
  object ShipLocation {

    final case class ShipLocationView(
        latitude: Option[Double],
        longitude: Option[Double]
    )

    type ViewSelection = SelectionBuilder[ShipLocation, ShipLocationView]

    def view: ViewSelection = (latitude ~ longitude).map {
      case (latitude, longitude) => ShipLocationView(latitude, longitude)
    }

    def latitude: SelectionBuilder[ShipLocation, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("latitude", OptionOf(Scalar()))
    def longitude: SelectionBuilder[ShipLocation, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("longitude", OptionOf(Scalar()))
  }

  type HistoriesResult
  object HistoriesResult {

    final case class HistoriesResultView[ResultSelection, DataSelection](
        result: Option[ResultSelection],
        data: Option[List[Option[DataSelection]]]
    )

    type ViewSelection[ResultSelection, DataSelection] = SelectionBuilder[
      HistoriesResult,
      HistoriesResultView[ResultSelection, DataSelection]
    ]

    def view[ResultSelection, DataSelection](
        resultSelection: SelectionBuilder[Result, ResultSelection],
        dataSelection: SelectionBuilder[History, DataSelection]
    ): ViewSelection[ResultSelection, DataSelection] =
      (result(resultSelection) ~ data(dataSelection)).map {
        case (result, data) => HistoriesResultView(result, data)
      }

    def result[A](
        innerSelection: SelectionBuilder[Result, A]
    ): SelectionBuilder[HistoriesResult, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("result", OptionOf(Obj(innerSelection)))
    def data[A](
        innerSelection: SelectionBuilder[History, A]
    ): SelectionBuilder[HistoriesResult, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("data", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type Result
  object Result {

    final case class ResultView(totalCount: Option[Int])

    type ViewSelection = SelectionBuilder[Result, ResultView]

    def view: ViewSelection =
      totalCount.map(totalCount => ResultView(totalCount))

    def totalCount: SelectionBuilder[Result, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("totalCount", OptionOf(Scalar()))
  }

  type Landpad
  object Landpad {

    final case class LandpadView[LocationSelection](
        attempted_landings: Option[String],
        details: Option[String],
        full_name: Option[String],
        id: Option[String],
        landing_type: Option[String],
        location: Option[LocationSelection],
        status: Option[String],
        successful_landings: Option[String],
        wikipedia: Option[String]
    )

    type ViewSelection[LocationSelection] =
      SelectionBuilder[Landpad, LandpadView[LocationSelection]]

    def view[LocationSelection](
        locationSelection: SelectionBuilder[Location, LocationSelection]
    ): ViewSelection[LocationSelection] =
      (attempted_landings ~ details ~ full_name ~ id ~ landing_type ~ location(
        locationSelection
      ) ~ status ~ successful_landings ~ wikipedia).map {
        case (
              (
                (
                  (
                    (
                      (((attempted_landings, details), full_name), id),
                      landing_type
                    ),
                    location
                  ),
                  status
                ),
                successful_landings
              ),
              wikipedia
            ) =>
          LandpadView(
            attempted_landings,
            details,
            full_name,
            id,
            landing_type,
            location,
            status,
            successful_landings,
            wikipedia
          )
      }

    def attempted_landings: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("attempted_landings", OptionOf(Scalar()))
    def details: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("details", OptionOf(Scalar()))
    def full_name: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("full_name", OptionOf(Scalar()))
    def id: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def landing_type: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("landing_type", OptionOf(Scalar()))
    def location[A](
        innerSelection: SelectionBuilder[Location, A]
    ): SelectionBuilder[Landpad, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("location", OptionOf(Obj(innerSelection)))
    def status: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def successful_landings: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("successful_landings", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Landpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type Location
  object Location {

    final case class LocationView(
        latitude: Option[Double],
        longitude: Option[Double],
        name: Option[String],
        region: Option[String]
    )

    type ViewSelection = SelectionBuilder[Location, LocationView]

    def view: ViewSelection = (latitude ~ longitude ~ name ~ region).map {
      case (((latitude, longitude), name), region) =>
        LocationView(latitude, longitude, name, region)
    }

    def latitude: SelectionBuilder[Location, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("latitude", OptionOf(Scalar()))
    def longitude: SelectionBuilder[Location, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("longitude", OptionOf(Scalar()))
    def name: SelectionBuilder[Location, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def region: SelectionBuilder[Location, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("region", OptionOf(Scalar()))
  }

  type LaunchesPastResult
  object LaunchesPastResult {

    final case class LaunchesPastResultView[ResultSelection, DataSelection](
        result: Option[ResultSelection],
        data: Option[List[Option[DataSelection]]]
    )

    type ViewSelection[ResultSelection, DataSelection] = SelectionBuilder[
      LaunchesPastResult,
      LaunchesPastResultView[ResultSelection, DataSelection]
    ]

    def view[ResultSelection, DataSelection](
        resultSelection: SelectionBuilder[Result, ResultSelection],
        dataSelection: SelectionBuilder[Launch, DataSelection]
    ): ViewSelection[ResultSelection, DataSelection] =
      (result(resultSelection) ~ data(dataSelection)).map {
        case (result, data) => LaunchesPastResultView(result, data)
      }

    def result[A](
        innerSelection: SelectionBuilder[Result, A]
    ): SelectionBuilder[LaunchesPastResult, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("result", OptionOf(Obj(innerSelection)))
    def data[A](
        innerSelection: SelectionBuilder[Launch, A]
    ): SelectionBuilder[LaunchesPastResult, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("data", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type Launchpad
  object Launchpad {

    final case class LaunchpadView[
        LocationSelection,
        Vehicles_launchedSelection
    ](
        attempted_launches: Option[Int],
        details: Option[String],
        id: Option[String],
        location: Option[LocationSelection],
        name: Option[String],
        status: Option[String],
        successful_launches: Option[Int],
        vehicles_launched: Option[List[Option[Vehicles_launchedSelection]]],
        wikipedia: Option[String]
    )

    type ViewSelection[LocationSelection, Vehicles_launchedSelection] =
      SelectionBuilder[
        Launchpad,
        LaunchpadView[LocationSelection, Vehicles_launchedSelection]
      ]

    def view[LocationSelection, Vehicles_launchedSelection](
        locationSelection: SelectionBuilder[Location, LocationSelection],
        vehicles_launchedSelection: SelectionBuilder[
          Rocket,
          Vehicles_launchedSelection
        ]
    ): ViewSelection[LocationSelection, Vehicles_launchedSelection] =
      (attempted_launches ~ details ~ id ~ location(
        locationSelection
      ) ~ name ~ status ~ successful_launches ~ vehicles_launched(
        vehicles_launchedSelection
      ) ~ wikipedia).map {
        case (
              (
                (
                  (
                    ((((attempted_launches, details), id), location), name),
                    status
                  ),
                  successful_launches
                ),
                vehicles_launched
              ),
              wikipedia
            ) =>
          LaunchpadView(
            attempted_launches,
            details,
            id,
            location,
            name,
            status,
            successful_launches,
            vehicles_launched,
            wikipedia
          )
      }

    def attempted_launches: SelectionBuilder[Launchpad, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("attempted_launches", OptionOf(Scalar()))
    def details: SelectionBuilder[Launchpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("details", OptionOf(Scalar()))
    def id: SelectionBuilder[Launchpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def location[A](
        innerSelection: SelectionBuilder[Location, A]
    ): SelectionBuilder[Launchpad, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("location", OptionOf(Obj(innerSelection)))
    def name: SelectionBuilder[Launchpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def status: SelectionBuilder[Launchpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("status", OptionOf(Scalar()))
    def successful_launches: SelectionBuilder[Launchpad, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("successful_launches", OptionOf(Scalar()))
    def vehicles_launched[A](
        innerSelection: SelectionBuilder[Rocket, A]
    ): SelectionBuilder[Launchpad, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "vehicles_launched",
        OptionOf(ListOf(OptionOf(Obj(innerSelection))))
      )
    def wikipedia: SelectionBuilder[Launchpad, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type Mission
  object Mission {

    final case class MissionView[PayloadsSelection](
        description: Option[String],
        id: Option[String],
        manufacturers: Option[List[Option[String]]],
        name: Option[String],
        twitter: Option[String],
        website: Option[String],
        wikipedia: Option[String],
        payloads: Option[List[Option[PayloadsSelection]]]
    )

    type ViewSelection[PayloadsSelection] =
      SelectionBuilder[Mission, MissionView[PayloadsSelection]]

    def view[PayloadsSelection](
        payloadsSelection: SelectionBuilder[Payload, PayloadsSelection]
    ): ViewSelection[PayloadsSelection] =
      (description ~ id ~ manufacturers ~ name ~ twitter ~ website ~ wikipedia ~ payloads(
        payloadsSelection
      )).map {
        case (
              (
                (
                  ((((description, id), manufacturers), name), twitter),
                  website
                ),
                wikipedia
              ),
              payloads
            ) =>
          MissionView(
            description,
            id,
            manufacturers,
            name,
            twitter,
            website,
            wikipedia,
            payloads
          )
      }

    def description: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))
    def id: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("id", OptionOf(Scalar()))
    def manufacturers: SelectionBuilder[Mission, Option[List[Option[String]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("manufacturers", OptionOf(ListOf(OptionOf(Scalar()))))
    def name: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def twitter: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitter", OptionOf(Scalar()))
    def website: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("website", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Mission, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
    def payloads[A](
        innerSelection: SelectionBuilder[Payload, A]
    ): SelectionBuilder[Mission, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("payloads", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type MissionResult
  object MissionResult {

    final case class MissionResultView[ResultSelection, DataSelection](
        result: Option[ResultSelection],
        data: Option[List[Option[DataSelection]]]
    )

    type ViewSelection[ResultSelection, DataSelection] = SelectionBuilder[
      MissionResult,
      MissionResultView[ResultSelection, DataSelection]
    ]

    def view[ResultSelection, DataSelection](
        resultSelection: SelectionBuilder[Result, ResultSelection],
        dataSelection: SelectionBuilder[Mission, DataSelection]
    ): ViewSelection[ResultSelection, DataSelection] =
      (result(resultSelection) ~ data(dataSelection)).map {
        case (result, data) => MissionResultView(result, data)
      }

    def result[A](
        innerSelection: SelectionBuilder[Result, A]
    ): SelectionBuilder[MissionResult, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("result", OptionOf(Obj(innerSelection)))
    def data[A](
        innerSelection: SelectionBuilder[Mission, A]
    ): SelectionBuilder[MissionResult, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("data", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type Roadster
  object Roadster {

    final case class RoadsterView(
        apoapsis_au: Option[Double],
        details: Option[String],
        earth_distance_km: Option[Double],
        earth_distance_mi: Option[Double],
        eccentricity: Option[Double],
        epoch_jd: Option[Double],
        inclination: Option[Double],
        launch_date_unix: Option[Date],
        launch_date_utc: Option[Date],
        launch_mass_kg: Option[Int],
        launch_mass_lbs: Option[Int],
        longitude: Option[Double],
        mars_distance_km: Option[Double],
        mars_distance_mi: Option[Double],
        name: Option[String],
        norad_id: Option[Int],
        orbit_type: Option[Double],
        periapsis_arg: Option[Double],
        periapsis_au: Option[Double],
        period_days: Option[Double],
        semi_major_axis_au: Option[Double],
        speed_kph: Option[Double],
        speed_mph: Option[Double],
        wikipedia: Option[String]
    )

    type ViewSelection = SelectionBuilder[Roadster, RoadsterView]

    def view: ViewSelection =
      (apoapsis_au ~ details ~ earth_distance_km ~ earth_distance_mi ~ eccentricity ~ epoch_jd ~ inclination ~ launch_date_unix ~ launch_date_utc ~ launch_mass_kg ~ launch_mass_lbs ~ longitude ~ mars_distance_km ~ mars_distance_mi ~ name ~ norad_id ~ orbit_type ~ periapsis_arg ~ periapsis_au ~ period_days ~ semi_major_axis_au ~ speed_kph ~ speed_mph ~ wikipedia)
        .map {
          case (
                (
                  (
                    (
                      (
                        (
                          (
                            (
                              (
                                (
                                  (
                                    (
                                      (
                                        (
                                          (
                                            (
                                              (
                                                (
                                                  (
                                                    (
                                                      (
                                                        (
                                                          (
                                                            apoapsis_au,
                                                            details
                                                          ),
                                                          earth_distance_km
                                                        ),
                                                        earth_distance_mi
                                                      ),
                                                      eccentricity
                                                    ),
                                                    epoch_jd
                                                  ),
                                                  inclination
                                                ),
                                                launch_date_unix
                                              ),
                                              launch_date_utc
                                            ),
                                            launch_mass_kg
                                          ),
                                          launch_mass_lbs
                                        ),
                                        longitude
                                      ),
                                      mars_distance_km
                                    ),
                                    mars_distance_mi
                                  ),
                                  name
                                ),
                                norad_id
                              ),
                              orbit_type
                            ),
                            periapsis_arg
                          ),
                          periapsis_au
                        ),
                        period_days
                      ),
                      semi_major_axis_au
                    ),
                    speed_kph
                  ),
                  speed_mph
                ),
                wikipedia
              ) =>
            RoadsterView(
              apoapsis_au,
              details,
              earth_distance_km,
              earth_distance_mi,
              eccentricity,
              epoch_jd,
              inclination,
              launch_date_unix,
              launch_date_utc,
              launch_mass_kg,
              launch_mass_lbs,
              longitude,
              mars_distance_km,
              mars_distance_mi,
              name,
              norad_id,
              orbit_type,
              periapsis_arg,
              periapsis_au,
              period_days,
              semi_major_axis_au,
              speed_kph,
              speed_mph,
              wikipedia
            )
        }

    def apoapsis_au: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("apoapsis_au", OptionOf(Scalar()))
    def details: SelectionBuilder[Roadster, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("details", OptionOf(Scalar()))
    def earth_distance_km: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("earth_distance_km", OptionOf(Scalar()))
    def earth_distance_mi: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("earth_distance_mi", OptionOf(Scalar()))
    def eccentricity: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("eccentricity", OptionOf(Scalar()))
    def epoch_jd: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("epoch_jd", OptionOf(Scalar()))
    def inclination: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("inclination", OptionOf(Scalar()))
    def launch_date_unix: SelectionBuilder[Roadster, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_date_unix", OptionOf(Scalar()))
    def launch_date_utc: SelectionBuilder[Roadster, Option[Date]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_date_utc", OptionOf(Scalar()))
    def launch_mass_kg: SelectionBuilder[Roadster, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_mass_kg", OptionOf(Scalar()))
    def launch_mass_lbs: SelectionBuilder[Roadster, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("launch_mass_lbs", OptionOf(Scalar()))
    def longitude: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("longitude", OptionOf(Scalar()))
    def mars_distance_km: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mars_distance_km", OptionOf(Scalar()))
    def mars_distance_mi: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("mars_distance_mi", OptionOf(Scalar()))
    def name: SelectionBuilder[Roadster, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def norad_id: SelectionBuilder[Roadster, Option[Int]] =
      _root_.caliban.client.SelectionBuilder
        .Field("norad_id", OptionOf(Scalar()))
    def orbit_type: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("orbit_type", OptionOf(Scalar()))
    def periapsis_arg: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("periapsis_arg", OptionOf(Scalar()))
    def periapsis_au: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("periapsis_au", OptionOf(Scalar()))
    def period_days: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("period_days", OptionOf(Scalar()))
    def semi_major_axis_au: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("semi_major_axis_au", OptionOf(Scalar()))
    def speed_kph: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("speed_kph", OptionOf(Scalar()))
    def speed_mph: SelectionBuilder[Roadster, Option[Double]] =
      _root_.caliban.client.SelectionBuilder
        .Field("speed_mph", OptionOf(Scalar()))
    def wikipedia: SelectionBuilder[Roadster, Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("wikipedia", OptionOf(Scalar()))
  }

  type RocketsResult
  object RocketsResult {

    final case class RocketsResultView[ResultSelection, DataSelection](
        result: Option[ResultSelection],
        data: Option[List[Option[DataSelection]]]
    )

    type ViewSelection[ResultSelection, DataSelection] = SelectionBuilder[
      RocketsResult,
      RocketsResultView[ResultSelection, DataSelection]
    ]

    def view[ResultSelection, DataSelection](
        resultSelection: SelectionBuilder[Result, ResultSelection],
        dataSelection: SelectionBuilder[Rocket, DataSelection]
    ): ViewSelection[ResultSelection, DataSelection] =
      (result(resultSelection) ~ data(dataSelection)).map {
        case (result, data) => RocketsResultView(result, data)
      }

    def result[A](
        innerSelection: SelectionBuilder[Result, A]
    ): SelectionBuilder[RocketsResult, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("result", OptionOf(Obj(innerSelection)))
    def data[A](
        innerSelection: SelectionBuilder[Rocket, A]
    ): SelectionBuilder[RocketsResult, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("data", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type ShipsResult
  object ShipsResult {

    final case class ShipsResultView[ResultSelection, DataSelection](
        result: Option[ResultSelection],
        data: Option[List[Option[DataSelection]]]
    )

    type ViewSelection[ResultSelection, DataSelection] = SelectionBuilder[
      ShipsResult,
      ShipsResultView[ResultSelection, DataSelection]
    ]

    def view[ResultSelection, DataSelection](
        resultSelection: SelectionBuilder[Result, ResultSelection],
        dataSelection: SelectionBuilder[Ship, DataSelection]
    ): ViewSelection[ResultSelection, DataSelection] =
      (result(resultSelection) ~ data(dataSelection)).map {
        case (result, data) => ShipsResultView(result, data)
      }

    def result[A](
        innerSelection: SelectionBuilder[Result, A]
    ): SelectionBuilder[ShipsResult, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("result", OptionOf(Obj(innerSelection)))
    def data[A](
        innerSelection: SelectionBuilder[Ship, A]
    ): SelectionBuilder[ShipsResult, Option[List[Option[A]]]] =
      _root_.caliban.client.SelectionBuilder
        .Field("data", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))
  }

  type users_mutation_response
  object users_mutation_response {

    final case class users_mutation_responseView[ReturningSelection](
        affected_rows: Int,
        returning: List[ReturningSelection]
    )

    type ViewSelection[ReturningSelection] =
      SelectionBuilder[users_mutation_response, users_mutation_responseView[
        ReturningSelection
      ]]

    def view[ReturningSelection](
        returningSelection: SelectionBuilder[users, ReturningSelection]
    ): ViewSelection[ReturningSelection] =
      (affected_rows ~ returning(returningSelection)).map {
        case (affected_rows, returning) =>
          users_mutation_responseView(affected_rows, returning)
      }

    /** number of affected rows by the mutation
      */
    def affected_rows: SelectionBuilder[users_mutation_response, Int] =
      _root_.caliban.client.SelectionBuilder.Field("affected_rows", Scalar())

    /** data of the affected rows by the mutation
      */
    def returning[A](
        innerSelection: SelectionBuilder[users, A]
    ): SelectionBuilder[users_mutation_response, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("returning", ListOf(Obj(innerSelection)))
  }

  type CoreMission
  object CoreMission {

    final case class CoreMissionView(name: Option[String], flight: Option[Int])

    type ViewSelection = SelectionBuilder[CoreMission, CoreMissionView]

    def view: ViewSelection = (name ~ flight).map { case (name, flight) =>
      CoreMissionView(name, flight)
    }

    def name: SelectionBuilder[CoreMission, Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field("name", OptionOf(Scalar()))
    def flight: SelectionBuilder[CoreMission, Option[Int]] =
      _root_.caliban.client.SelectionBuilder.Field("flight", OptionOf(Scalar()))
  }

  final case class users_order_by(
      id: Option[order_by] = None,
      name: Option[order_by] = None,
      rocket: Option[order_by] = None,
      timestamp: Option[order_by] = None,
      twitter: Option[order_by] = None
  )
  object users_order_by {
    implicit val encoder: ArgEncoder[users_order_by] =
      new ArgEncoder[users_order_by] {
        override def encode(value: users_order_by): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              )
            )
          )
      }
  }
  final case class users_bool_exp(
      _and: Option[List[Option[users_bool_exp]]] = None,
      _not: Option[users_bool_exp] = None,
      _or: Option[List[Option[users_bool_exp]]] = None,
      id: Option[uuid_comparison_exp] = None,
      name: Option[String_comparison_exp] = None,
      rocket: Option[String_comparison_exp] = None,
      timestamp: Option[timestamptz_comparison_exp] = None,
      twitter: Option[String_comparison_exp] = None
  )
  object users_bool_exp {
    implicit val encoder: ArgEncoder[users_bool_exp] =
      new ArgEncoder[users_bool_exp] {
        override def encode(value: users_bool_exp): __Value =
          __ObjectValue(
            List(
              "_and" -> value._and.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    value.fold(__NullValue: __Value)(value => encode(value))
                  )
                )
              ),
              "_not" -> value._not.fold(__NullValue: __Value)(value =>
                encode(value)
              ),
              "_or" -> value._or.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    value.fold(__NullValue: __Value)(value => encode(value))
                  )
                )
              ),
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid_comparison_exp]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String_comparison_exp]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String_comparison_exp]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz_comparison_exp]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String_comparison_exp]].encode(value)
              )
            )
          )
      }
  }
  final case class uuid_comparison_exp(
      _eq: Option[uuid] = None,
      _gt: Option[uuid] = None,
      _gte: Option[uuid] = None,
      _in: Option[List[uuid]] = None,
      _is_null: Option[Boolean] = None,
      _lt: Option[uuid] = None,
      _lte: Option[uuid] = None,
      _neq: Option[uuid] = None,
      _nin: Option[List[uuid]] = None
  )
  object uuid_comparison_exp {
    implicit val encoder: ArgEncoder[uuid_comparison_exp] =
      new ArgEncoder[uuid_comparison_exp] {
        override def encode(value: uuid_comparison_exp): __Value =
          __ObjectValue(
            List(
              "_eq" -> value._eq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_gt" -> value._gt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_gte" -> value._gte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_in" -> value._in.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value => implicitly[ArgEncoder[uuid]].encode(value))
                )
              ),
              "_is_null" -> value._is_null.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "_lt" -> value._lt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_lte" -> value._lte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_neq" -> value._neq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "_nin" -> value._nin.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value => implicitly[ArgEncoder[uuid]].encode(value))
                )
              )
            )
          )
      }
  }
  final case class String_comparison_exp(
      _eq: Option[String] = None,
      _gt: Option[String] = None,
      _gte: Option[String] = None,
      _ilike: Option[String] = None,
      _in: Option[List[String]] = None,
      _is_null: Option[Boolean] = None,
      _like: Option[String] = None,
      _lt: Option[String] = None,
      _lte: Option[String] = None,
      _neq: Option[String] = None,
      _nilike: Option[String] = None,
      _nin: Option[List[String]] = None,
      _nlike: Option[String] = None,
      _nsimilar: Option[String] = None,
      _similar: Option[String] = None
  )
  object String_comparison_exp {
    implicit val encoder: ArgEncoder[String_comparison_exp] =
      new ArgEncoder[String_comparison_exp] {
        override def encode(value: String_comparison_exp): __Value =
          __ObjectValue(
            List(
              "_eq" -> value._eq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_gt" -> value._gt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_gte" -> value._gte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_ilike" -> value._ilike.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_in" -> value._in.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "_is_null" -> value._is_null.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "_like" -> value._like.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_lt" -> value._lt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_lte" -> value._lte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_neq" -> value._neq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_nilike" -> value._nilike.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_nin" -> value._nin.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "_nlike" -> value._nlike.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_nsimilar" -> value._nsimilar.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "_similar" -> value._similar.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class timestamptz_comparison_exp(
      _eq: Option[timestamptz] = None,
      _gt: Option[timestamptz] = None,
      _gte: Option[timestamptz] = None,
      _in: Option[List[timestamptz]] = None,
      _is_null: Option[Boolean] = None,
      _lt: Option[timestamptz] = None,
      _lte: Option[timestamptz] = None,
      _neq: Option[timestamptz] = None,
      _nin: Option[List[timestamptz]] = None
  )
  object timestamptz_comparison_exp {
    implicit val encoder: ArgEncoder[timestamptz_comparison_exp] =
      new ArgEncoder[timestamptz_comparison_exp] {
        override def encode(value: timestamptz_comparison_exp): __Value =
          __ObjectValue(
            List(
              "_eq" -> value._eq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_gt" -> value._gt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_gte" -> value._gte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_in" -> value._in.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[timestamptz]].encode(value)
                  )
                )
              ),
              "_is_null" -> value._is_null.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "_lt" -> value._lt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_lte" -> value._lte.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_neq" -> value._neq.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "_nin" -> value._nin.fold(__NullValue: __Value)(value =>
                __ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[timestamptz]].encode(value)
                  )
                )
              )
            )
          )
      }
  }
  final case class CapsulesFind(
      id: Option[String] = None,
      landings: Option[Int] = None,
      mission: Option[String] = None,
      original_launch: Option[Date] = None,
      reuse_count: Option[Int] = None,
      status: Option[String] = None,
      `type`: Option[String] = None
  )
  object CapsulesFind {
    implicit val encoder: ArgEncoder[CapsulesFind] =
      new ArgEncoder[CapsulesFind] {
        override def encode(value: CapsulesFind): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "landings" -> value.landings.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "mission" -> value.mission.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "original_launch" -> value.original_launch.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Date]].encode(value)),
              "reuse_count" -> value.reuse_count.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Int]].encode(value)
              ),
              "status" -> value.status.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "type" -> value.`type`.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class CoresFind(
      asds_attempts: Option[Int] = None,
      asds_landings: Option[Int] = None,
      block: Option[Int] = None,
      id: Option[String] = None,
      missions: Option[String] = None,
      original_launch: Option[Date] = None,
      reuse_count: Option[Int] = None,
      rtls_attempts: Option[Int] = None,
      rtls_landings: Option[Int] = None,
      status: Option[String] = None,
      water_landing: Option[Boolean] = None
  )
  object CoresFind {
    implicit val encoder: ArgEncoder[CoresFind] = new ArgEncoder[CoresFind] {
      override def encode(value: CoresFind): __Value =
        __ObjectValue(
          List(
            "asds_attempts" -> value.asds_attempts.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "asds_landings" -> value.asds_landings.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "block" -> value.block.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "id" -> value.id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "missions" -> value.missions.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "original_launch" -> value.original_launch.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Date]].encode(value)),
            "reuse_count" -> value.reuse_count.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "rtls_attempts" -> value.rtls_attempts.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "rtls_landings" -> value.rtls_landings.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "status" -> value.status.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "water_landing" -> value.water_landing.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Boolean]].encode(value)
            )
          )
        )
    }
  }
  final case class HistoryFind(
      end: Option[Date] = None,
      flight_number: Option[Int] = None,
      id: Option[String] = None,
      start: Option[Date] = None
  )
  object HistoryFind {
    implicit val encoder: ArgEncoder[HistoryFind] =
      new ArgEncoder[HistoryFind] {
        override def encode(value: HistoryFind): __Value =
          __ObjectValue(
            List(
              "end" -> value.end.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Date]].encode(value)
              ),
              "flight_number" -> value.flight_number.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Int]].encode(value)
              ),
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "start" -> value.start.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Date]].encode(value)
              )
            )
          )
      }
  }
  final case class LaunchFind(
      apoapsis_km: Option[Double] = None,
      block: Option[Int] = None,
      cap_serial: Option[String] = None,
      capsule_reuse: Option[String] = None,
      core_flight: Option[Int] = None,
      core_reuse: Option[String] = None,
      core_serial: Option[String] = None,
      customer: Option[String] = None,
      eccentricity: Option[Double] = None,
      end: Option[Date] = None,
      epoch: Option[Date] = None,
      fairings_recovered: Option[String] = None,
      fairings_recovery_attempt: Option[String] = None,
      fairings_reuse: Option[String] = None,
      fairings_reused: Option[String] = None,
      fairings_ship: Option[String] = None,
      gridfins: Option[String] = None,
      id: Option[String] = None,
      inclination_deg: Option[Double] = None,
      land_success: Option[String] = None,
      landing_intent: Option[String] = None,
      landing_type: Option[String] = None,
      landing_vehicle: Option[String] = None,
      launch_date_local: Option[Date] = None,
      launch_date_utc: Option[Date] = None,
      launch_success: Option[String] = None,
      launch_year: Option[String] = None,
      legs: Option[String] = None,
      lifespan_years: Option[Double] = None,
      longitude: Option[Double] = None,
      manufacturer: Option[String] = None,
      mean_motion: Option[Double] = None,
      mission_id: Option[String] = None,
      mission_name: Option[String] = None,
      nationality: Option[String] = None,
      norad_id: Option[Int] = None,
      orbit: Option[String] = None,
      payload_id: Option[String] = None,
      payload_type: Option[String] = None,
      periapsis_km: Option[Double] = None,
      period_min: Option[Double] = None,
      raan: Option[Double] = None,
      reference_system: Option[String] = None,
      regime: Option[String] = None,
      reused: Option[String] = None,
      rocket_id: Option[String] = None,
      rocket_name: Option[String] = None,
      rocket_type: Option[String] = None,
      second_stage_block: Option[String] = None,
      semi_major_axis_km: Option[Double] = None,
      ship: Option[String] = None,
      side_core1_reuse: Option[String] = None,
      side_core2_reuse: Option[String] = None,
      site_id: Option[String] = None,
      site_name_long: Option[String] = None,
      site_name: Option[String] = None,
      start: Option[Date] = None,
      tbd: Option[String] = None,
      tentative_max_precision: Option[String] = None,
      tentative: Option[String] = None
  )
  object LaunchFind {
    implicit val encoder: ArgEncoder[LaunchFind] = new ArgEncoder[LaunchFind] {
      override def encode(value: LaunchFind): __Value =
        __ObjectValue(
          List(
            "apoapsis_km" -> value.apoapsis_km.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Double]].encode(value)
            ),
            "block" -> value.block.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "cap_serial" -> value.cap_serial.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "capsule_reuse" -> value.capsule_reuse.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "core_flight" -> value.core_flight.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Int]].encode(value)
            ),
            "core_reuse" -> value.core_reuse.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "core_serial" -> value.core_serial.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "customer" -> value.customer.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "eccentricity" -> value.eccentricity.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Double]].encode(value)
            ),
            "end" -> value.end.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Date]].encode(value)
            ),
            "epoch" -> value.epoch.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Date]].encode(value)
            ),
            "fairings_recovered" -> value.fairings_recovered.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "fairings_recovery_attempt" -> value.fairings_recovery_attempt.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "fairings_reuse" -> value.fairings_reuse.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "fairings_reused" -> value.fairings_reused.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "fairings_ship" -> value.fairings_ship.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "gridfins" -> value.gridfins.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "id" -> value.id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "inclination_deg" -> value.inclination_deg.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Double]].encode(value)),
            "land_success" -> value.land_success.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "landing_intent" -> value.landing_intent.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "landing_type" -> value.landing_type.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "landing_vehicle" -> value.landing_vehicle.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "launch_date_local" -> value.launch_date_local.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Date]].encode(value)),
            "launch_date_utc" -> value.launch_date_utc.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Date]].encode(value)),
            "launch_success" -> value.launch_success.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "launch_year" -> value.launch_year.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "legs" -> value.legs.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "lifespan_years" -> value.lifespan_years.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Double]].encode(value)
            ),
            "longitude" -> value.longitude.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Double]].encode(value)
            ),
            "manufacturer" -> value.manufacturer.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "mean_motion" -> value.mean_motion.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Double]].encode(value)
            ),
            "mission_id" -> value.mission_id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "mission_name" -> value.mission_name.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "nationality" -> value.nationality.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "norad_id" -> value.norad_id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "orbit" -> value.orbit.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "payload_id" -> value.payload_id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "payload_type" -> value.payload_type.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "periapsis_km" -> value.periapsis_km.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[Double]].encode(value)
            ),
            "period_min" -> value.period_min.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Double]].encode(value)
            ),
            "raan" -> value.raan.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Double]].encode(value)
            ),
            "reference_system" -> value.reference_system.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "regime" -> value.regime.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "reused" -> value.reused.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "rocket_id" -> value.rocket_id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "rocket_name" -> value.rocket_name.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "rocket_type" -> value.rocket_type.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "second_stage_block" -> value.second_stage_block.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "semi_major_axis_km" -> value.semi_major_axis_km.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Double]].encode(value)),
            "ship" -> value.ship.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "side_core1_reuse" -> value.side_core1_reuse.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "side_core2_reuse" -> value.side_core2_reuse.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "site_id" -> value.site_id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "site_name_long" -> value.site_name_long.fold(__NullValue: __Value)(
              value => implicitly[ArgEncoder[String]].encode(value)
            ),
            "site_name" -> value.site_name.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "start" -> value.start.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Date]].encode(value)
            ),
            "tbd" -> value.tbd.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "tentative_max_precision" -> value.tentative_max_precision.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[String]].encode(value)),
            "tentative" -> value.tentative.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            )
          )
        )
    }
  }
  final case class MissionsFind(
      id: Option[String] = None,
      manufacturer: Option[String] = None,
      name: Option[String] = None,
      payload_id: Option[String] = None
  )
  object MissionsFind {
    implicit val encoder: ArgEncoder[MissionsFind] =
      new ArgEncoder[MissionsFind] {
        override def encode(value: MissionsFind): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "manufacturer" -> value.manufacturer.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "payload_id" -> value.payload_id.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class PayloadsFind(
      apoapsis_km: Option[Double] = None,
      customer: Option[String] = None,
      eccentricity: Option[Double] = None,
      epoch: Option[Date] = None,
      inclination_deg: Option[Double] = None,
      lifespan_years: Option[Double] = None,
      longitude: Option[Double] = None,
      manufacturer: Option[String] = None,
      mean_motion: Option[Double] = None,
      nationality: Option[String] = None,
      norad_id: Option[Int] = None,
      orbit: Option[String] = None,
      payload_id: Option[String] = None,
      payload_type: Option[String] = None,
      periapsis_km: Option[Double] = None,
      period_min: Option[Double] = None,
      raan: Option[Double] = None,
      reference_system: Option[String] = None,
      regime: Option[String] = None,
      reused: Option[Boolean] = None,
      semi_major_axis_km: Option[Double] = None
  )
  object PayloadsFind {
    implicit val encoder: ArgEncoder[PayloadsFind] =
      new ArgEncoder[PayloadsFind] {
        override def encode(value: PayloadsFind): __Value =
          __ObjectValue(
            List(
              "apoapsis_km" -> value.apoapsis_km.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "customer" -> value.customer.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "eccentricity" -> value.eccentricity.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "epoch" -> value.epoch.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Date]].encode(value)
              ),
              "inclination_deg" -> value.inclination_deg.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Double]].encode(value)),
              "lifespan_years" -> value.lifespan_years.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Double]].encode(value)),
              "longitude" -> value.longitude.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Double]].encode(value)
              ),
              "manufacturer" -> value.manufacturer.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "mean_motion" -> value.mean_motion.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "nationality" -> value.nationality.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "norad_id" -> value.norad_id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "orbit" -> value.orbit.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "payload_id" -> value.payload_id.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "payload_type" -> value.payload_type.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "periapsis_km" -> value.periapsis_km.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "period_min" -> value.period_min.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[Double]].encode(value)
              ),
              "raan" -> value.raan.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Double]].encode(value)
              ),
              "reference_system" -> value.reference_system.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "regime" -> value.regime.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "reused" -> value.reused.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "semi_major_axis_km" -> value.semi_major_axis_km.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[Double]].encode(value))
            )
          )
      }
  }
  final case class ShipsFind(
      id: Option[String] = None,
      name: Option[String] = None,
      model: Option[String] = None,
      `type`: Option[String] = None,
      role: Option[String] = None,
      active: Option[Boolean] = None,
      imo: Option[Int] = None,
      mmsi: Option[Int] = None,
      abs: Option[Int] = None,
      `class`: Option[Int] = None,
      weight_lbs: Option[Int] = None,
      weight_kg: Option[Int] = None,
      year_built: Option[Int] = None,
      home_port: Option[String] = None,
      status: Option[String] = None,
      speed_kn: Option[Int] = None,
      course_deg: Option[Int] = None,
      latitude: Option[Double] = None,
      longitude: Option[Double] = None,
      successful_landings: Option[Int] = None,
      attempted_landings: Option[Int] = None,
      mission: Option[String] = None
  )
  object ShipsFind {
    implicit val encoder: ArgEncoder[ShipsFind] = new ArgEncoder[ShipsFind] {
      override def encode(value: ShipsFind): __Value =
        __ObjectValue(
          List(
            "id" -> value.id.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "name" -> value.name.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "models" -> value.model.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "type" -> value.`type`.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "role" -> value.role.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "active" -> value.active.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Boolean]].encode(value)
            ),
            "imo" -> value.imo.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "mmsi" -> value.mmsi.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "abs" -> value.abs.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "class" -> value.`class`.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "weight_lbs" -> value.weight_lbs.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "weight_kg" -> value.weight_kg.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "year_built" -> value.year_built.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "home_port" -> value.home_port.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "status" -> value.status.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            ),
            "speed_kn" -> value.speed_kn.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "course_deg" -> value.course_deg.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Int]].encode(value)
            ),
            "latitude" -> value.latitude.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Double]].encode(value)
            ),
            "longitude" -> value.longitude.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[Double]].encode(value)
            ),
            "successful_landings" -> value.successful_landings.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Int]].encode(value)),
            "attempted_landings" -> value.attempted_landings.fold(
              __NullValue: __Value
            )(value => implicitly[ArgEncoder[Int]].encode(value)),
            "mission" -> value.mission.fold(__NullValue: __Value)(value =>
              implicitly[ArgEncoder[String]].encode(value)
            )
          )
        )
    }
  }
  final case class users_insert_input(
      id: Option[uuid] = None,
      name: Option[String] = None,
      rocket: Option[String] = None,
      timestamp: Option[timestamptz] = None,
      twitter: Option[String] = None
  )
  object users_insert_input {
    implicit val encoder: ArgEncoder[users_insert_input] =
      new ArgEncoder[users_insert_input] {
        override def encode(value: users_insert_input): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class users_on_conflict(
      constraint: users_constraint,
      update_columns: List[users_update_column] = Nil
  )
  object users_on_conflict {
    implicit val encoder: ArgEncoder[users_on_conflict] =
      new ArgEncoder[users_on_conflict] {
        override def encode(value: users_on_conflict): __Value =
          __ObjectValue(
            List(
              "constraint" -> implicitly[ArgEncoder[users_constraint]]
                .encode(value.constraint),
              "update_columns" -> __ListValue(
                value.update_columns.map(value =>
                  implicitly[ArgEncoder[users_update_column]].encode(value)
                )
              )
            )
          )
      }
  }
  final case class users_set_input(
      id: Option[uuid] = None,
      name: Option[String] = None,
      rocket: Option[String] = None,
      timestamp: Option[timestamptz] = None,
      twitter: Option[String] = None
  )
  object users_set_input {
    implicit val encoder: ArgEncoder[users_set_input] =
      new ArgEncoder[users_set_input] {
        override def encode(value: users_set_input): __Value =
          __ObjectValue(
            List(
              "id" -> value.id.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[uuid]].encode(value)
              ),
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[timestamptz]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class users_aggregate_order_by(
      count: Option[order_by] = None,
      max: Option[users_max_order_by] = None,
      min: Option[users_min_order_by] = None
  )
  object users_aggregate_order_by {
    implicit val encoder: ArgEncoder[users_aggregate_order_by] =
      new ArgEncoder[users_aggregate_order_by] {
        override def encode(value: users_aggregate_order_by): __Value =
          __ObjectValue(
            List(
              "count" -> value.count.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "max" -> value.max.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[users_max_order_by]].encode(value)
              ),
              "min" -> value.min.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[users_min_order_by]].encode(value)
              )
            )
          )
      }
  }
  final case class users_max_order_by(
      name: Option[order_by] = None,
      rocket: Option[order_by] = None,
      timestamp: Option[order_by] = None,
      twitter: Option[order_by] = None
  )
  object users_max_order_by {
    implicit val encoder: ArgEncoder[users_max_order_by] =
      new ArgEncoder[users_max_order_by] {
        override def encode(value: users_max_order_by): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              )
            )
          )
      }
  }
  final case class users_min_order_by(
      name: Option[order_by] = None,
      rocket: Option[order_by] = None,
      timestamp: Option[order_by] = None,
      twitter: Option[order_by] = None
  )
  object users_min_order_by {
    implicit val encoder: ArgEncoder[users_min_order_by] =
      new ArgEncoder[users_min_order_by] {
        override def encode(value: users_min_order_by): __Value =
          __ObjectValue(
            List(
              "name" -> value.name.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "rocket" -> value.rocket.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "timestamp" -> value.timestamp.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              ),
              "twitter" -> value.twitter.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[order_by]].encode(value)
              )
            )
          )
      }
  }
  final case class users_arr_rel_insert_input(
      data: List[users_insert_input] = Nil,
      on_conflict: Option[users_on_conflict] = None
  )
  object users_arr_rel_insert_input {
    implicit val encoder: ArgEncoder[users_arr_rel_insert_input] =
      new ArgEncoder[users_arr_rel_insert_input] {
        override def encode(value: users_arr_rel_insert_input): __Value =
          __ObjectValue(
            List(
              "data" -> __ListValue(
                value.data.map(value =>
                  implicitly[ArgEncoder[users_insert_input]].encode(value)
                )
              ),
              "on_conflict" -> value.on_conflict.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[users_on_conflict]].encode(value)
              )
            )
          )
      }
  }
  final case class users_obj_rel_insert_input(
      data: users_insert_input,
      on_conflict: Option[users_on_conflict] = None
  )
  object users_obj_rel_insert_input {
    implicit val encoder: ArgEncoder[users_obj_rel_insert_input] =
      new ArgEncoder[users_obj_rel_insert_input] {
        override def encode(value: users_obj_rel_insert_input): __Value =
          __ObjectValue(
            List(
              "data" -> implicitly[ArgEncoder[users_insert_input]]
                .encode(value.data),
              "on_conflict" -> value.on_conflict.fold(__NullValue: __Value)(
                value => implicitly[ArgEncoder[users_on_conflict]].encode(value)
              )
            )
          )
      }
  }
  type Query = _root_.caliban.client.Operations.RootQuery
  object Query {

    /** fetch data from the table: "users"
      */
    def users[A](
        distinct_on: Option[List[users_select_column]] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order_by: Option[List[users_order_by]] = None,
        where: Option[users_bool_exp] = None
    )(innerSelection: SelectionBuilder[users, A])(implicit
        encoder0: ArgEncoder[Option[List[users_select_column]]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[List[users_order_by]]],
        encoder4: ArgEncoder[Option[users_bool_exp]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, List[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "users",
        ListOf(Obj(innerSelection)),
        arguments = List(
          Argument("distinct_on", distinct_on, "[users_select_column!]")(
            encoder0
          ),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order_by", order_by, "[users_order_by!]")(encoder3),
          Argument("where", where, "users_bool_exp")(encoder4)
        )
      )

    /** fetch aggregated fields from the table: "users"
      */
    def users_aggregate[A](
        distinct_on: Option[List[users_select_column]] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order_by: Option[List[users_order_by]] = None,
        where: Option[users_bool_exp] = None
    )(innerSelection: SelectionBuilder[users_aggregate, A])(implicit
        encoder0: ArgEncoder[Option[List[users_select_column]]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[List[users_order_by]]],
        encoder4: ArgEncoder[Option[users_bool_exp]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "users_aggregate",
        Obj(innerSelection),
        arguments = List(
          Argument("distinct_on", distinct_on, "[users_select_column!]")(
            encoder0
          ),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order_by", order_by, "[users_order_by!]")(encoder3),
          Argument("where", where, "users_bool_exp")(encoder4)
        )
      )

    /** fetch data from the table: "users" using primary key columns
      */
    def users_by_pk[A](id: uuid)(innerSelection: SelectionBuilder[users, A])(
        implicit encoder0: ArgEncoder[uuid]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "users_by_pk",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "uuid!")(encoder0))
      )
    def capsules[A](
        find: Option[CapsulesFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Capsule, A])(implicit
        encoder0: ArgEncoder[Option[CapsulesFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "capsules",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CapsulesFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def capsulesPast[A](
        find: Option[CapsulesFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Capsule, A])(implicit
        encoder0: ArgEncoder[Option[CapsulesFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "capsulesPast",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CapsulesFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def capsulesUpcoming[A](
        find: Option[CapsulesFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Capsule, A])(implicit
        encoder0: ArgEncoder[Option[CapsulesFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "capsulesUpcoming",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CapsulesFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def capsule[A](id: String)(innerSelection: SelectionBuilder[Capsule, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "capsule",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def company[A](
        innerSelection: SelectionBuilder[Info, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("company", OptionOf(Obj(innerSelection)))
    def cores[A](
        find: Option[CoresFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Core, A])(implicit
        encoder0: ArgEncoder[Option[CoresFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "cores",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CoresFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def coresPast[A](
        find: Option[CoresFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Core, A])(implicit
        encoder0: ArgEncoder[Option[CoresFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "coresPast",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CoresFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def coresUpcoming[A](
        find: Option[CoresFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Core, A])(implicit
        encoder0: ArgEncoder[Option[CoresFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "coresUpcoming",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "CoresFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def core[A](id: String)(innerSelection: SelectionBuilder[Core, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "core",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def dragons[A](limit: Option[Int] = None, offset: Option[Int] = None)(
        innerSelection: SelectionBuilder[Dragon, A]
    )(implicit
        encoder0: ArgEncoder[Option[Int]],
        encoder1: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "dragons",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1)
      )
    )
    def dragon[A](id: String)(innerSelection: SelectionBuilder[Dragon, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "dragon",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def histories[A](
        find: Option[HistoryFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[History, A])(implicit
        encoder0: ArgEncoder[Option[HistoryFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "histories",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "HistoryFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def historiesResult[A](
        find: Option[HistoryFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[HistoriesResult, A])(implicit
        encoder0: ArgEncoder[Option[HistoryFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "historiesResult",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("find", find, "HistoryFind")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order", order, "String")(encoder3),
          Argument("sort", sort, "String")(encoder4)
        )
      )
    def history[A](id: String)(innerSelection: SelectionBuilder[History, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "history",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def landpads[A](limit: Option[Int] = None, offset: Option[Int] = None)(
        innerSelection: SelectionBuilder[Landpad, A]
    )(implicit
        encoder0: ArgEncoder[Option[Int]],
        encoder1: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "landpads",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1)
      )
    )
    def landpad[A](id: String)(innerSelection: SelectionBuilder[Landpad, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "landpad",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def launches[A](
        find: Option[LaunchFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Launch, A])(implicit
        encoder0: ArgEncoder[Option[LaunchFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "launches",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "LaunchFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def launchesPast[A](
        find: Option[LaunchFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Launch, A])(implicit
        encoder0: ArgEncoder[Option[LaunchFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "launchesPast",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "LaunchFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def launchesPastResult[A](
        find: Option[LaunchFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[LaunchesPastResult, A])(implicit
        encoder0: ArgEncoder[Option[LaunchFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "launchesPastResult",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("find", find, "LaunchFind")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order", order, "String")(encoder3),
          Argument("sort", sort, "String")(encoder4)
        )
      )
    def launchesUpcoming[A](
        find: Option[LaunchFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Launch, A])(implicit
        encoder0: ArgEncoder[Option[LaunchFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "launchesUpcoming",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "LaunchFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def launch[A](id: String)(innerSelection: SelectionBuilder[Launch, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "launch",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def launchLatest[A](
        offset: Option[Int] = None
    )(innerSelection: SelectionBuilder[Launch, A])(implicit
        encoder0: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "launchLatest",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("offset", offset, "Int")(encoder0))
      )
    def launchNext[A](
        offset: Option[Int] = None
    )(innerSelection: SelectionBuilder[Launch, A])(implicit
        encoder0: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "launchNext",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("offset", offset, "Int")(encoder0))
      )
    def launchpads[A](limit: Option[Int] = None, offset: Option[Int] = None)(
        innerSelection: SelectionBuilder[Launchpad, A]
    )(implicit
        encoder0: ArgEncoder[Option[Int]],
        encoder1: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "launchpads",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1)
      )
    )
    def launchpad[A](
        id: String
    )(innerSelection: SelectionBuilder[Launchpad, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "launchpad",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def missions[A](
        find: Option[MissionsFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None
    )(innerSelection: SelectionBuilder[Mission, A])(implicit
        encoder0: ArgEncoder[Option[MissionsFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "missions",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "MissionsFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2)
      )
    )
    def missionsResult[A](
        find: Option[MissionsFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None
    )(innerSelection: SelectionBuilder[MissionResult, A])(implicit
        encoder0: ArgEncoder[Option[MissionsFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "missionsResult",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("find", find, "MissionsFind")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2)
        )
      )
    def mission[A](id: String)(innerSelection: SelectionBuilder[Mission, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "mission",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def payloads[A](
        find: Option[PayloadsFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Payload, A])(implicit
        encoder0: ArgEncoder[Option[PayloadsFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "payloads",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "PayloadsFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def payload[A](id: String)(innerSelection: SelectionBuilder[Payload, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "payload",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def roadster[A](
        innerSelection: SelectionBuilder[Roadster, A]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("roadster", OptionOf(Obj(innerSelection)))
    def rockets[A](limit: Option[Int] = None, offset: Option[Int] = None)(
        innerSelection: SelectionBuilder[Rocket, A]
    )(implicit
        encoder0: ArgEncoder[Option[Int]],
        encoder1: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "rockets",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("limit", limit, "Int")(encoder0),
        Argument("offset", offset, "Int")(encoder1)
      )
    )
    def rocketsResult[A](limit: Option[Int] = None, offset: Option[Int] = None)(
        innerSelection: SelectionBuilder[RocketsResult, A]
    )(implicit
        encoder0: ArgEncoder[Option[Int]],
        encoder1: ArgEncoder[Option[Int]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "rocketsResult",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("limit", limit, "Int")(encoder0),
          Argument("offset", offset, "Int")(encoder1)
        )
      )
    def rocket[A](id: String)(innerSelection: SelectionBuilder[Rocket, A])(
        implicit encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "rocket",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
    def ships[A](
        find: Option[ShipsFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[Ship, A])(implicit
        encoder0: ArgEncoder[Option[ShipsFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[
      List[Option[A]]
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "ships",
      OptionOf(ListOf(OptionOf(Obj(innerSelection)))),
      arguments = List(
        Argument("find", find, "ShipsFind")(encoder0),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order", order, "String")(encoder3),
        Argument("sort", sort, "String")(encoder4)
      )
    )
    def shipsResult[A](
        find: Option[ShipsFind] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order: Option[String] = None,
        sort: Option[String] = None
    )(innerSelection: SelectionBuilder[ShipsResult, A])(implicit
        encoder0: ArgEncoder[Option[ShipsFind]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[String]],
        encoder4: ArgEncoder[Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "shipsResult",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("find", find, "ShipsFind")(encoder0),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order", order, "String")(encoder3),
          Argument("sort", sort, "String")(encoder4)
        )
      )
    def ship[A](id: String)(innerSelection: SelectionBuilder[Ship, A])(implicit
        encoder0: ArgEncoder[String]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, Option[A]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "ship",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id, "ID!")(encoder0))
      )
  }

  type Mutation = _root_.caliban.client.Operations.RootMutation
  object Mutation {

    /** delete data from the table: "users"
      */
    def delete_users[A](
        where: users_bool_exp
    )(innerSelection: SelectionBuilder[users_mutation_response, A])(implicit
        encoder0: ArgEncoder[users_bool_exp]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Option[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "delete_users",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("where", where, "users_bool_exp!")(encoder0))
    )

    /** insert data into the table: "users"
      */
    def insert_users[A](
        objects: List[users_insert_input] = Nil,
        on_conflict: Option[users_on_conflict] = None
    )(innerSelection: SelectionBuilder[users_mutation_response, A])(implicit
        encoder0: ArgEncoder[List[users_insert_input]],
        encoder1: ArgEncoder[Option[users_on_conflict]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Option[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "insert_users",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("objects", objects, "[users_insert_input!]!")(encoder0),
        Argument("on_conflict", on_conflict, "users_on_conflict")(encoder1)
      )
    )

    /** update data of the table: "users"
      */
    def update_users[A](
        _set: Option[users_set_input] = None,
        where: users_bool_exp
    )(innerSelection: SelectionBuilder[users_mutation_response, A])(implicit
        encoder0: ArgEncoder[Option[users_set_input]],
        encoder1: ArgEncoder[users_bool_exp]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, Option[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "update_users",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("_set", _set, "users_set_input")(encoder0),
        Argument("where", where, "users_bool_exp!")(encoder1)
      )
    )
  }

  type Subscription = _root_.caliban.client.Operations.RootSubscription
  object Subscription {

    /** fetch data from the table: "users"
      */
    def users[A](
        distinct_on: Option[List[users_select_column]] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order_by: Option[List[users_order_by]] = None,
        where: Option[users_bool_exp] = None
    )(innerSelection: SelectionBuilder[users, A])(implicit
        encoder0: ArgEncoder[Option[List[users_select_column]]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[List[users_order_by]]],
        encoder4: ArgEncoder[Option[users_bool_exp]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootSubscription, List[
      A
    ]] = _root_.caliban.client.SelectionBuilder.Field(
      "users",
      ListOf(Obj(innerSelection)),
      arguments = List(
        Argument("distinct_on", distinct_on, "[users_select_column!]")(
          encoder0
        ),
        Argument("limit", limit, "Int")(encoder1),
        Argument("offset", offset, "Int")(encoder2),
        Argument("order_by", order_by, "[users_order_by!]")(encoder3),
        Argument("where", where, "users_bool_exp")(encoder4)
      )
    )

    /** fetch aggregated fields from the table: "users"
      */
    def users_aggregate[A](
        distinct_on: Option[List[users_select_column]] = None,
        limit: Option[Int] = None,
        offset: Option[Int] = None,
        order_by: Option[List[users_order_by]] = None,
        where: Option[users_bool_exp] = None
    )(innerSelection: SelectionBuilder[users_aggregate, A])(implicit
        encoder0: ArgEncoder[Option[List[users_select_column]]],
        encoder1: ArgEncoder[Option[Int]],
        encoder2: ArgEncoder[Option[Int]],
        encoder3: ArgEncoder[Option[List[users_order_by]]],
        encoder4: ArgEncoder[Option[users_bool_exp]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootSubscription, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "users_aggregate",
        Obj(innerSelection),
        arguments = List(
          Argument("distinct_on", distinct_on, "[users_select_column!]")(
            encoder0
          ),
          Argument("limit", limit, "Int")(encoder1),
          Argument("offset", offset, "Int")(encoder2),
          Argument("order_by", order_by, "[users_order_by!]")(encoder3),
          Argument("where", where, "users_bool_exp")(encoder4)
        )
      )

    /** fetch data from the table: "users" using primary key columns
      */
    def users_by_pk[A](id: uuid)(
        innerSelection: SelectionBuilder[users, A]
    )(implicit encoder0: ArgEncoder[uuid]): SelectionBuilder[
      _root_.caliban.client.Operations.RootSubscription,
      Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "users_by_pk",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "uuid!")(encoder0))
    )
  }

}
