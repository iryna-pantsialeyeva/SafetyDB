package repository.util;

public class SQLQuery {

    public static final String GET_ALL_ADVERSE_REACTIONS = "select id, report_date, description, suspected_drug," +
            " criteria_name, outcome_name, user_id, reporter_id, causal_relationship_reporter_id, " +
            "causal_relationship_company from adverse_reactions";
    public static final String INSERT_IN_ADVERSE_REACTIONS = "insert into adverse_reactions (report_date, " +
            "description, suspected_drug, outcome_name, criteria_name, user_id, reporter_id, causal_relationship_reporter_id, " +
            "causal_relationship_company) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_ADVERSE_REACTIONS = "update adverse_reactions set report_date = ?, description = ?, " +
            "suspected_drug = ?, outcome_name = ?, criteria_name = ?, causal_relationship_company = ? where id = ?";
    public static final String DELETE_FROM_ADVERSE_REACTIONS_BY_ID = "delete from adverse_reactions where id = ?";

    public static final String GET_USER_BY_USERID = "select id, email, password, active from users where id = ?";
    public static final String GET_USER_BY_EMAIL = "select id, email, password, active from users where email = ?";

    public static final String GET_REPORTER_BY_REPORTERID = "select id, full_name, reporter_type_name from " +
            "reporters where id = ?";
    public static final String GET_REPORTER_ID_BY_NAME = "select id from reporters where full_name = ?";
    public static final String INSERT_IN_REPORTERS = "insert into reporters (full_name, reporter_type_name) values " +
            "(?, ?)";
    public static final String GET_REPORTER_BY_NAME = "select id, full_name, reporter_type_name from reporters where " +
            "full_name = ?";
    public static final String UPDATE_IN_REPORTERS = "update reporters set full_name = ?, reporter_type_name = ? " +
            "where id = ?";

    public static final String UPDATE_IN_USERS = "update users set email = ?, password = ?, active = ? " +
            "where id = ?";

    public static final String GET_RELATIONSHIP_BY_RELATIONSHIPID = "select id, name, time_relationship, " +
            "withdrawal_result, reintroduction_result, other_explanaition from causal_relationships where id = ?";
    public static final String INSERT_IN_RELATIONSHIPS = "insert into causal_relationships (name, " +
            "time_relationship, withdrawal_result, reintroduction_result, other_explanaition) values " +
            "(?, ?, ?, ?, ?)";
    public static final String GET_RELATIONSHIP_ID = "select id from causal_relationships where " +
            "name = ? and time_relationship = ? and withdrawal_result = ? and reintroduction_result = ? " +
            "and other_explanaition = ?";
    public static final String UPDATE_IN_RELATIONSHIPS = "update causal_relationships set " +
            "name = ? and time_relationship = ? and withdrawal_result = ? and reintroduction_result = ? " +
            "and other_explanaition = ? where id = ?";

    public static final String GET_ADVERSE_REACTION_BY_ID = "select * from adverse_reactions where id = ?";
    public static final String GET_ADVERSE_REACTION_BY_TITLE = "select * from adverse_reactions where title = ?";
    public static final String GET_ADVERSE_REACTION_BY_SUSPECTED_DRUG = "select * from adverse_reactions where " +
            "suspected_drug = ?";
    public static final String GET_ADVERSE_REACTION_BY_REPORTER = "select * from adverse_reactions where " +
            "reporter_id = ?";
    public static final String GET_ADVERSE_REACTION_ID_BY_PARAMETERS = "select id from adverse_reactions where " +
            "report_date = ? and description = ? and suspected_drug = ? and criteria_id = ? and outcome_id = ? " +
            "and reporter_id = ? and reporter_type_id = ?";


    public static final String INSERT_IN_CRITERIAS = "insert into seriousness_criterias (name) values (?)" +
            "(?)";
    public static final String GET_CRITERIA_ID_BY_NAME = "select id from seriousness_criterias where name = ?";
    public static final String GET_FROM_CRITERIAS_BY_NAME = "select * from seriousness_criterias where name = ?";
    public static final String INSERT_IN_OUTCOMES = "insert into outcomes (name) values (?)";
    public static final String GET_OUTCOME_ID_BY_NAME = "select id from outcomes where name = ?";
    public static final String GET_FROM_OUTCOMES_BY_NAME = "select * from outcomes where name = ?";
    public static final String INSERT_IN_REPORTER_TYPES = "insert into reporter_types (name) values (?)";
    public static final String GET_REPORTER_TYPE_ID_BY_NAME = "select id from reporter_types where name = ?";
    public static final String GET_FROM_REPORTER_TYPES_BY_ID = "select * from reporter_types where id = ?";
    public static final String GET_FROM_REPORTER_TYPES_BY_NAME = "select * from reporter_types where name = ?";
    public static final String GET_RELATIONSHIP_ID_BY_NAME = "select * from causal_relationships where name = ?";
    public static final String GET_COMPANY_ASSESSMENT_ID = "select id from company_assessment where " +
            "name = ?";
    public static final String GET_COMPANY_ASSESSMENT_BY_ID = "select * from company_assessment where id = ?";
    public static final String GET_COMPANY_ASSESSMENT_ID_BY_NAME = "select * from company_assessment where name = ?";
    public static final String GET_USER_ID_BY_NAME = "select id from users where email = ?";

    public static final String GET_ALL_ADR_ID = "select id from adverse_reactions";
    public static final String GET_DATE_BY_ID = "select report_date from adverse_reactions where id = ?";
    public static final String GET_DESCRIPTION_BY_ID = "select description from adverse_reactions where id = ?";
    public static final String GET_SUSPECTED_DRUG_BY_ID = "select suspected_drug from adverse_reactions where id = ?";
    public static final String GET_CRITERIA_BY_ID = "select criteria_name from adverse_reactions where id = ?";
    public static final String GET_OUTCOME_BY_ID = "select outcome_name from adverse_reactions where id = ?";
    public static final String GET_USERID_BY_ID = "select user_id from adverse_reactions where id = ?";
    public static final String GET_REPORTERID_BY_ID = "select reporter_id from adverse_reactions where id = ?";
    public static final String GET_RELATIONSHIPTYPE_BY_ID = "select causal_relationship_company from " +
            "adverse_reactions where id = ?";
    public static final String GET_RELATIONSHIPID_BY_ID = "select causal_relationship_reporter_id from " +
            "adverse_reactions where id = ?";
}