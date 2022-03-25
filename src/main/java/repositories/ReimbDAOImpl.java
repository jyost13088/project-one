package repositories;

import models.Reimb;

import util.Connectionutil;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class ReimbDAOImpl implements ReimbDAO {


    public void createReimb(Reimb reimb) {
        try (Connection conn = Connectionutil.getConnection()) {
            String sql = "insert into ERS_Reimbursement(reimb_amount,reimb_description, reimb_author_fk,reimb_status_id_fk, reimb_type_id_fk) values ( ?, ?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimb.getAmount());

            ps.setString(2, reimb.getDescription());
            ps.setInt(3, reimb.getAuthor());
            ps.setInt(4, reimb.getStatus_Id());
            ps.setInt(5, reimb.getType_Id());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }


    public void updateReimb(Reimb reimb) {

        try (Connection conn = Connectionutil.getConnection()) {
            String sql = "update ERS_Reimbursement set reimb_status_id_fK = ?,reimb_resolver_fk =?, reimb_resolved= ?  where reimb_id_pk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimb.getStatus_Id());
            ps.setInt(2,reimb.getResolver());
            //LocalDateTime now = LocalDateTime.now();
           // ps.setTimestamp(3, Timestamp.valueOf(now));
            ps.setTimestamp(3, reimb.getResolved());
            ps.setInt(4, reimb.getReimb_Id());

            ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
