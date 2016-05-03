package fr.univtln.groupc.services;

import fr.univtln.groupc.dao.CCrudMethods;
import fr.univtln.groupc.entities.CConsumableEntity;
import fr.univtln.groupc.entities.CPortalEntity;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by marti on 03/05/2016.
 */

@Path("/consumables")
public class CConsumableService {
    private CCrudMethods mCrudMethods = new CCrudMethods();

    @POST
    @Consumes("application/json")
    @Path("create")
    public void createConsumable(CConsumableEntity pConsumable){
        mCrudMethods.create(pConsumable);
    }

    @GET
    @Path("/{id}")
    public CConsumableEntity read(@PathParam("id") int pId){
        return (CConsumableEntity) mCrudMethods.find(CConsumableEntity.class, pId);
    }

    @GET
    @Path("/")
    public List<CConsumableEntity> readAll(){
        return (List<CConsumableEntity>)mCrudMethods.findWithNamedQuery(CConsumableEntity.GET_ALL);
    }

}