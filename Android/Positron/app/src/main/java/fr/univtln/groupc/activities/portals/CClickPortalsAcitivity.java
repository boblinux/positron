package fr.univtln.groupc.activities.portals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import fr.univtln.groupc.actions.CActions;
import fr.univtln.groupc.entities.CPortalEntity;
import fr.univtln.groupc.entities.CResonatorEntity;
import fr.univtln.groupc.rest.CRestUpdate;
import fr.univtln.m1dapm.groupec.tperron710.positron.R;

public class CClickPortalsAcitivity extends AppCompatActivity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cclick_portals_acitivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cclick_portals_acitivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    public void attackingBuilding(ABuildingEntity pTarget, CPlayerEntity pAttacker, CConsumableEntity pAmmunition , CPortalEntity pPortal){

        CActions lActions = new CActions();
        pTarget = lActions.attackBuilding(pAmmunition,pTarget,pAttacker);

        if(pTarget.getEnergy() <= 0){
            // TODO Delete Building
            //new CRestDelete();
            updatePortalTeam(pPortal);
        }
        else{
            //TODO Updtate Building
            //new CRestUpdate().;
        }

    }

  */


    public void buildingResonator(CPortalEntity pPortal,CResonatorEntity pResonator){
        CActions lActions = new CActions();

        pPortal = lActions.buildResonator(pPortal, pResonator);
        if(updatePortalTeam(pPortal) == 0){
            new CRestUpdate().updatePortalRest(pPortal);
        }

    }

    public int updatePortalTeam(CPortalEntity pPortal){
        if(pPortal.getTeam() != null){
            int lTeam = pPortal.getTeam().getId();
            pPortal.attributeTeam();
            if (lTeam != pPortal.getTeam().getId()){
                new CRestUpdate().updatePortalRest(pPortal);
                // TODO delete Link?
                return 1;
            }
        }
        else{
            pPortal.attributeTeam();
            if (pPortal!=null){
                new CRestUpdate().updatePortalRest(pPortal);
                //TODO Delete LINK?
                return 1;
            }
        }
        return 0;
    }

    public void maintenir(View view){
        mIntent = new Intent(this, CPutPortalsView.class);
        startActivity(mIntent);
    }
}