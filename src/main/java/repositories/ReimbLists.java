package repositories;


import models.ReimbList;
import util.Connectionutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbLists extends ReimbList {

    public List<ReimbList> getAllReimbLists() {
        List<ReimbList> reimbLists = new ArrayList<>();

        try (Connection conn = Connectionutil.getConnection()) {
            //String sql = "Select * from ERS_Reimbursement as r inner join ers_reimbursement_status as s on r.reimb_status_id_fk = s.reimb_status_id_pk order by r.reimb_author_fK, r.reimb_status_id_fK ;";
            String sql = "select r.reimb_id_pk as reimb_Id, " +
                    "u.user_firstname as firstname, " +
                    "u.user_lastname as lastname, " +
                    "r.reimb_amount as amount," +
                    "r.reimb_description as description, " +
                    "r.reimb_submitted as submitted, " +
                    "r.reimb_status_id_fk as status_Id, " +
                    "rs.reimb_status  as status, " +
                    "r.reimb_type_id_fk as type_Id," +
                    "rt.reimb_type as type" +
                    "  from ers_users as u " +
                    "inner join ers_reimbursement as r on u.ers_users_id_pk = r.reimb_author_fk  " +
                    "inner join ers_reimbursement_status as rs on r.reimb_status_id_fk = rs.reimb_status_id_pk " +
                    "inner join ers_reimbursement_type as rt on r.reimb_type_id_fk = rt.reimb_type_id_pk " +
                    "order by r.reimb_status_id_fk ;";
            PreparedStatement ps = conn.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reimbLists.add(new ReimbList(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)

                ));
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return reimbLists;

    }
    public List<ReimbList> getOneReimbList(Integer userId) {
        List<ReimbList> reimbLists = new ArrayList<>();

        try (Connection conn = Connectionutil.getConnection()) {
            //String sql = "Select * from ERS_Reimbursement as r inner join ers_reimbursement_status as s on r.reimb_status_id_fk = s.reimb_status_id_pk order by r.reimb_author_fK, r.reimb_status_id_fK ;";
            String sql = "select  r.reimb_id_pk as reimb_Id, " +
                    "u.user_firstname as firstname, " +
                    "u.user_lastname as lastname, " +
                    "r.reimb_amount as amount," +
                    "r.reimb_description as description, " +
                    "r.reimb_submitted as submitted, " +
                    "r.reimb_status_id_fk as status_Id, " +
                    "rs.reimb_status  as status, " +
                    "r.reimb_type_id_fk as type_Id," +
                    "rt.reimb_type as type" +
                    "  from ers_users as u " +
                    "inner join ers_reimbursement as r on u.ers_users_id_pk = r.reimb_author_fk  " +
                    "inner join ers_reimbursement_status as rs on r.reimb_status_id_fk = rs.reimb_status_id_pk " +
                    "inner join ers_reimbursement_type as rt on r.reimb_type_id_fk = rt.reimb_type_id_pk " +
                    " where u.ers_users_id_pk = ? " +
                    "order by r.reimb_status_id_fk ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reimbLists.add(new ReimbList(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)

                ));
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return reimbLists;

    }

}
