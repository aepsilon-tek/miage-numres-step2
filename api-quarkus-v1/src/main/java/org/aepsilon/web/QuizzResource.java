package org.aepsilon.web;


import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.service.QuizzService;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/quizz")

public class QuizzResource {

    @Inject
    QuizzService quizzService;

    /**
     * curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions
     * @return
     */
    @GET()
    @Path("questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuestionDto> listQuestion(){
        Log.infof("In listQuestion");
        return quizzService.listAllQuestions();
    }


    /**
     * curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions/1/proposals
     * @return
     */
    @GET()
    @Path("questions/{id}/proposals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProposalDto> listProposals(@RestPath Long id){
        Log.infof("In listProposals  for questionId=%d",id);
        return quizzService.listProposals(id);
    }


    /**
     *  curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/proposals/evaluate  -H 'accept: application/json'  -H 'content-type: application/json; charset=UTF-8' --data-raw '[{"id":1},{"id":2}]'
     * @param rep
     * @return
     */
    @POST()
    @Path("proposals/evaluate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public long evaluate(List<ProposalDto> rep){
        Log.infof("In evaluate ");
        return quizzService.evaluateProposals(rep);
    }
}
