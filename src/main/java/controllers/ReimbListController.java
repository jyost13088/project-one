package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimb;
import models.ReimbList;
import services.ReimbListService;

import java.util.List;

public class ReimbListController {

    ReimbListService reimbListService;

    public ReimbListController(){

        this.reimbListService = new ReimbListService();
    }

    public ReimbListController(ReimbListService reimbListService){

        this.reimbListService = reimbListService;
    }

    public void displayAllListForUser(Context context){
        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<ReimbList> lists = reimbListService.getAllGivenUserId(userId);
        context.json(new JsonResponse(true, "listing all list for user " + userId, lists));
    }
    public void displayAllLists(Context context){

        List<ReimbList> lists = reimbListService.getAllReimbLists();
        context.json(new JsonResponse(true, "listing all reimbursements ",lists));
    }


}
