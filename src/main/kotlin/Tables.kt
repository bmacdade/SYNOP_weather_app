import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object WeatherStations: Table(){
    override val tableName: String = this::class.java.simpleName
    val StationId: Column<Int> = integer("STATION_ID")
    val StationName: Column<String> = varchar("STATION_NAME",50)
    override val primaryKey = PrimaryKey(StationId)
}

object WeatherReadings: Table(){
    override val tableName: String = this::class.java.simpleName

}