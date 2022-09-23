package repository.util;

public class SQLQuery {

    public static final String GET_ALL_ADVERSE_REACTIONS = "select * from adverse_reactions";
    public static final String GET_ADVERSE_REACTION_BY_ID = "select * from adverse_reactions where id = ?";
    public static final String GET_ADVERSE_REACTION_BY_TITLE = "select * from adverse_reactions where title = ?";
    public static final String GET_ADVERSE_REACTION_BY_SUSPECTED_DRUG = "select * from adverse_reactions where " +
            "suspected_drug = ?";
    public static final String GET_ADVERSE_REACTION_ID_BY_PARAMETERS = "select id from adverse_reactions where " +
            "report_date = ? and description = ? and suspected_drug = ? and criteria_id = ? and outcome_id = ? " +
            "and reporter_id = ? and reporter_type_id = ?";
    public static final String INSERT_IN_ADVERSE_REACTIONS = "insert into adverse_reactions (report_date, " +
            "description, suspected_drug, criteria_id, outcome_id, reporter_id, reporter_type_id) values " +
            "(?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_ADVERSE_REACTIONS = "update adverse_reactions set report_date = ?, " +
            "description = ?, suspected_drug = ?, criteria_id = ?, outcome_id = ?, reporter_id = ?, " +
            "reporter_type_id = ? where id = ?";
    public static final String DELETE_FROM_ADVERSE_REACTIONS = "delete from adverse_reactions where report_date = ? " +
            "and reporter_id = ?";
    public static final String INSERT_IN_CRITERIAS = "insert into seriousness_criterias (name) values (?)" +
            "(?)";
    public static final String GET_CRITERIA_ID_BY_NAME = "select id from seriousness_criterias where name = ?";
    public static final String GET_FROM_CRITERIAS_BY_ID = "select * from seriousness_criterias where id = ?";
    public static final String GET_FROM_CRITERIAS_BY_NAME = "select * from seriousness_criterias where name = ?";
    public static final String INSERT_IN_OUTCOMES = "insert into outcomes (name) values (?)";
    public static final String GET_OUTCOME_ID_BY_NAME = "select id from outcomes where name = ?";
    public static final String GET_FROM_OUTCOMES_BY_ID = "select * from outcomes where id = ?";
    public static final String GET_FROM_OUTCOMES_BY_NAME = "select * from outcomes where name = ?";
    public static final String INSERT_IN_REPORTERS = "insert into reporters (name) values (?)";
    public static final String GET_REPORTER_ID_BY_NAME = "select id from reporters where name = ?";
    public static final String GET_FROM_REPORTERS_BY_ID = "select * from reporters where id = ?";
    public static final String GET_FROM_REPORTERS_BY_NAME = "select * from reporters where name = ?";
    public static final String INSERT_IN_REPORTER_TYPES = "insert into reporter_types (name) values (?)";
    public static final String GET_REPORTER_TYPE_ID_BY_NAME = "select id from reporter_types where name = ?";
    public static final String GET_FROM_REPORTER_TYPES_BY_ID = "select * from reporter_types where id = ?";
    public static final String GET_FROM_REPORTER_TYPES_BY_NAME = "select * from reporter_types where name = ?";

}