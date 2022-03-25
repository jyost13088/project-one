package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimb;
import services.ReimbListService;
import services.ReimbService;

public class ReimbController {
    ReimbService reimbService;

    public ReimbController(){

        this.reimbService = new ReimbService();
    }

    public ReimbController(ReimbListService reimbListService){

        this.reimbService = reimbService;
    }

    public void createReimb(Context context){
        Reimb reimb = context.bodyAsClass(Reimb.class);

          reimbService.createReimb(reimb);

        context.json(new JsonResponse(true, "Reimbursement has been created" , null));

    }
    public void updateReimb(Context context){
        Reimb reimb = context.bodyAsClass(Reimb.class);

        reimbService.updateReimb(reimb);

        context.json(new JsonResponse(true, "Reimbursement has been updated  " , null));
    }
}
