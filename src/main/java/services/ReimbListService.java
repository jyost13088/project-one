package services;

import models.ReimbList;
import repositories.ReimbLists;


import java.util.List;

public class ReimbListService {


    private ReimbLists reimbLists;

    public ReimbListService(){

        this.reimbLists = new ReimbLists();
    }

    public ReimbListService(ReimbLists reimbLists){

        this.reimbLists = reimbLists;
    }


    public List<ReimbList> getAllGivenUserId(Integer userId) {

        return this.reimbLists.getOneReimbList(userId);
    }

    public List<ReimbList> getAllReimbLists(){

        return this.reimbLists.getAllReimbLists();
    }




}
