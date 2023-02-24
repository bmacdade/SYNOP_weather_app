import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseHandler {
    companion object{
        private val database by lazy{Database.connect("jdbc:sqlite:weather_stations.db", driver = "org.sqlite.JDBC")}
    }
    fun writeData(data:ITableData,table:Table){
        if(data.associatedTable != table) throw Exception("Data's table and given table don't match")
        databaseTransaction(database) {
            table.insert {

            }
        }
    }

    fun insertWeatherStation(data:WeatherStation):Int{
        var stationId:Int = -1
        databaseTransaction(database) {
            stationId = WeatherStations.insertIgnore {
                it[StationId] = data.stationId
                it[StationName] = data.stationName
            } get WeatherStations.StationId
        }
        return stationId
    }

    fun initializeDatabase(vararg tables:Table){
        databaseTransaction(database) {
            tables.forEach { table ->
                println("Table: ${table.tableName}, was created in the database.")
                SchemaUtils.create(table)
            }
        }
    }

    fun createTable(table:Table){
        databaseTransaction(database) {
            SchemaUtils.create(table)
            println("Table: ${table.tableName}, was created in the database.")
        }
    }

//    fun listTables():List<Table>{
//        databaseTransaction {maps
//            SchemaUtils.
//        }
//    }

    fun readTable(table:Table) = databaseTransaction(database)  { table.selectAll().forEach {
        println("SQL line: $it") } }
}

data class WeatherStation(val stationId:Int, val stationName:String, override val associatedTable: Table = WeatherStations):ITableData

interface ITableData{
    val associatedTable:Table
}

private fun databaseTransaction(db:Database,callback: () -> Unit){
    transaction(db){
        addLogger(StdOutSqlLogger)
        callback()
    }
}