private lateinit var db:DatabaseHandler


/**
 * Useful links:
 * https://github.com/JetBrains/Exposed/wiki/Transactions
 * https://github.com/JetBrains/Exposed/wiki/DSL
 * https://github.com/JetBrains/Exposed/wiki/DataBase-and-DataSource
 * https://github.com/JetBrains/Exposed
 *
 * */
fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")
    db = DatabaseHandler()
    println("Created DatabaseHandler")
    db.initializeDatabase(WeatherStations)
    println("Initialized Database!")

    stationIDMap.forEach {
        db.insertWeatherStation(WeatherStation(stationId = it.key, stationName = it.value))
    }

    db.readTable(WeatherStations)
    println("Read WeatherStations table!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

}


val stationIDMap = mapOf<Int,String>(
    93004 to "Cape Reinga",
    93014 to "Kaitaia Airport",
    93021 to "Kerikeri Airport",
    93057 to "Whangarei Airport",
    93069 to "Mokohinau Islands",
    93110 to "Auckland Airport",
    93129 to "Whitianga Airport",
    93173 to "Hamilton Airport",
    93186 to "Tauranga Airport",
    93196 to "Hicks Bay",
    93201 to "Port Taharoa",
    93245 to "Taupo Airport",
    93292 to "Gisborne Airport",
    93309 to "New Plymouth Airport",
    93313 to "Hawera",
    93327 to "Whanganui Airport",
    93339 to "Waiouru",
    93373 to "Napier Airport",
    93393 to "Mahia",
    93404 to "Palmerston North Airport",
    93410 to "Levin",
    93420 to "Paraparaumu Airport",
    93439 to "Wellington Airport",
    93479 to "Ngawi",
    93498 to "Castlepoint",
    93515 to "Westport Airport",
    93527 to "Farewell Spit",
    93546 to "Nelson Airport",
    93562 to "Stephens Island",
    93597 to "Cape Campbell",
    93615 to "Hokitika Airport",
    93678 to "Kaikoura",
    93709 to "Haast",
    93738 to "Mount Cook",
    93721 to "Milford Sound",
    93747 to "Tara Hills",
    93773 to "Timaru Airport",
    93781 to "Christchurch Airport",
    93792 to "Le Bons Bay",
    93800 to "Secretary Island",
    93805 to "Puysegur Point",
    93831 to "Queenstown Airport",
    93845 to "Invercargill Airport",
    93887 to "Nugget Point",
    93891 to "Dunedin Airport",
    93909 to "South West Cape",
    93929 to "Enderby Island",
    93947 to "Campbell Island",
    93985 to "Chatham Island",
    93994 to "Raoul Island"
)