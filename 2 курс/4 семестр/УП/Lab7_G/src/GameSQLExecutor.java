
import java.sql.*;
import java.util.ArrayList;

public class GameSQLExecutor {
    static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static String connect;
    static String connectWithoutCreate;
    String name;
    ArrayList<String> pendingQueries = new ArrayList<>();

    public GameSQLExecutor(String name) {
        connect = "jdbc:derby:" + name + ";create=true";
        connectWithoutCreate = "jdbc:derby:" + name + ";create=false";
        this.name = name;
    }

    public void create() {
        System.setProperty("derby.system.home", "C:\\Derby");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connect);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE CulinaryGuide " +
                    "(" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                    "name VARCHAR(32)" +
                    ")");

            statement.executeUpdate("CREATE TABLE Types " +
                    "(" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                    "name VARCHAR(64), " +
                    "culinaryguideId INTEGER REFERENCES CulinaryGuide(id)" +
                    ")");

            statement.executeUpdate("CREATE TABLE Dish " +
                    "(" +
                    "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                    "name VARCHAR(64), " +
                    "cooking VARCHAR(256), " +
                    "ingredients VARCHAR(256), " +
                    "typeId INTEGER REFERENCES Types(id)" +
                    ")"
            );
            statement.execute("INSERT INTO CulinaryGuide(NAME) VALUES('" + name + "')");
            statement.close();
        } catch (Exception e) {
            System.err.println("Run-time error: ");
            e.printStackTrace();
        }
        pendingQueries.clear();
    }

    public void lazyAddSection(GameType type, int culinaryguideId) {
        String sql =
                String.format("INSERT INTO Types(name,culinaryguideId) VALUES('%s',%d)", type.getName(), culinaryguideId);
        System.out.println(sql);
        pendingQueries.add(sql);
    }

    public void lazyAddReport(Game game, int gameTypeId) {
        String sql = String.format("INSERT INTO Dish(name,cooking,ingredients,typeId) VALUES('%s','%s','%s',%d)",
                game.getName(), game.getComplexity(), game.getExotic(), gameTypeId);
        System.out.println(sql);
        pendingQueries.add(sql);
    }

    public void executePending() {
        System.setProperty("derby.system.home", "C:\\Derby");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connect);
            Statement all = conn.createStatement();
            ResultSet resultSet = all.executeQuery("select * from CulinaryGuide");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            Statement statement = conn.createStatement();

            for (String query : pendingQueries) {
                System.out.println(query);
                statement.executeUpdate(query);
            }
            statement.close();
        } catch (Exception e) {
            System.err.println("Run-time error: ");
            e.printStackTrace();
        }
        pendingQueries.clear();
    }

    public ArrayList<GameLibrary> readCulinaryGuides() {
        System.setProperty("derby.system.home", "C:\\Derby");
        ArrayList<GameLibrary> culinaryGuides = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connect);
            Statement statement = conn.createStatement();

            ResultSet CulinaryGuidesResult = statement.executeQuery("select * from CulinaryGuide");
            culinaryGuides = getCulinaryGuidesFromResult(CulinaryGuidesResult);

            statement = conn.createStatement();
            ResultSet dishsTypeResult = statement.executeQuery("select * from Types");
            ArrayList<GameType> gameTypes = getDishTypeFromResult(dishsTypeResult, culinaryGuides);

            statement = conn.createStatement();
            ResultSet dishsResult = statement.executeQuery("select * from Dish");
            ArrayList<Game> game = getDishsFromResult(dishsResult, gameTypes);
        } catch (Exception e) {
            System.err.println("Run-time error: ");
            e.printStackTrace();
        }
        return culinaryGuides;
    }

    private ArrayList<Game> getDishsFromResult(ResultSet dishsResult, ArrayList<GameType> gameTypes) throws SQLException {
        ArrayList<Game> dishs = new ArrayList<>();
        while (dishsResult.next()) {
            String name = dishsResult.getString(2);
            String producer = dishsResult.getString(3);
            String number = dishsResult.getString(4);

            GameType parent = gameTypes.get(dishsResult.getInt(5) - 1);
            Game game = new Game(name, producer, number);
            game.setDishType(parent);

            dishs.add(game);
            parent.add(game);
        }
        return dishs;
    }

    private ArrayList<GameType> getDishTypeFromResult(ResultSet dishTypesResult, ArrayList<GameLibrary> culinaryGuides)
            throws SQLException {
        ArrayList<GameType> gameTypes = new ArrayList<>();
        while (dishTypesResult.next()) {
            String name = dishTypesResult.getString(2);
            System.out.println(name);
            GameLibrary parent = culinaryGuides.get(dishTypesResult.getInt(3) - 1);
            GameType gameType = new GameType(name, parent);
            gameTypes.add(gameType);
            parent.add(gameType);
        }
        return gameTypes;
    }

    private ArrayList<GameLibrary> getCulinaryGuidesFromResult(ResultSet CulinaryGuideResult) throws SQLException {
        ArrayList<GameLibrary> culinaryGuides = new ArrayList<>();
        while (CulinaryGuideResult.next()) {
            culinaryGuides.add(new GameLibrary(CulinaryGuideResult.getString(2)));
        }
        return culinaryGuides;
    }

}