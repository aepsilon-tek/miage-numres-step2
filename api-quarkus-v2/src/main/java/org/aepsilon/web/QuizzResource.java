package org.aepsilon.web;


import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.jboss.resteasy.reactive.RestPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/quizz")

public class QuizzResource {


    /**
     * curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions
     * @return
     */
    @GET()
    @Path("questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> listQuestion(){
        Log.infof("In listQuestion");
        return Question.listAll();
    }


    /**
     * curl -w "\nTime: %{time_total}s\nSize: %{size_download} bytes\n" http://localhost:8080/quizz/questions/1/proposals
     * @return
     */
    @GET()
    @Path("questions/{id}/proposals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proposal> listProposals(@RestPath Integer id){
        Log.infof("In listProposals  for questionId=%d",id);
        return Proposal.list("question.id",id);
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
    public long evaluate(List<Proposal> rep){
        Log.infof("In evaluate ");
        Map<String, Object> params = new HashMap<>();
        params.put("isCorrect", true);
        params.put("idProposals", rep.stream().map(p->p.id).collect(Collectors.toList()));

        return Proposal.count("correct= :isCorrect and id in :idProposals ",params);
    }
}
