package repository.util;

public class SQLQuery {

    public static final String INSERT_IN_ADVERSE_REACTIONS = "insert into adverse_reactions (report_date, " +
            "description, suspected_drug, criteria_id, outcome_id, reporter_id, reporter_type_id) values " +
            "(?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_IN_CRITERIAS = "insert into seriousness_criterias (name) values (?)" +
            "(?)";
    public static final String GET_CRITERIA_ID_BY_NAME = "select id from seriousness_criterias where name = ?";
    public static final String INSERT_IN_OUTCOMES = "insert into outcomes (name) values (?)";
    public static final String GET_OUTCOME_ID_BY_NAME = "select id from outcomes where name = ?";
    public static final String INSERT_IN_REPORTERS = "insert into reporters (name) values (?)";
    public static final String GET_REPORTER_ID_BY_NAME = "select id from reporters where name = ?";
    public static final String INSERT_IN_REPORTER_TYPES = "insert into reporter_types (name) values (?)";
    public static final String GET_REPORTER_TYPE_ID_BY_NAME = "select id from reporter_types where name = ?";


}