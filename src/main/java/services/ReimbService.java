package services;

import models.Reimb;

import repositories.ReimbDAO;
import repositories.ReimbDAOImpl;
import repositories.ReimbLists;

import java.util.List;

public class ReimbService {


        private ReimbDAO reimbDAO;

        public ReimbService(){

            this.reimbDAO = new ReimbDAOImpl();
        }

        public ReimbService(ReimbDAO reimbDAO){

            this.reimbDAO = reimbDAO;
        }



        public void createReimb(Reimb reimb){
            this.reimbDAO.createReimb(reimb);
        }

        public void updateReimb(Reimb reimb){
            this.reimbDAO.updateReimb(reimb);
        }

    }
