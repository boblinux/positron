package fr.univtln.groupc.activities.profil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.univtln.groupc.entities.CPlayerEntity;
import fr.univtln.groupc.entities.CSkillEntity;
import fr.univtln.m1dapm.groupec.tperron710.positron.R;

public class CSkillTree extends AppCompatActivity {

    TextView mFree_SkillPoints = (TextView) findViewById(R.id.text_View_free_skill_point);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cskill_tree);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cskill_tree, menu);
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

    public int calculateFreeSkillPoint(CPlayerEntity pPlayer){
        int lSkillPoints = pPlayer.getLevel()*2;
        int lSkillPointOwned = 0, lFreePoint = 0;

        for(CSkillEntity lSkill : pPlayer.getSkills()){
            lSkillPointOwned = lSkillPoints + lSkill.getLevel();
        }
        lFreePoint = lSkillPoints - lSkillPointOwned;

        mFree_SkillPoints.setText(lFreePoint);

        return lFreePoint;
    }

    public void resetSkills(View view){


    }

    public void selectSkill_Maintenance_1(View pView){


    }
    public void selectSkill_Maintenance_21(View pView){


    }
    public void selectSkill_Maintenance_22(View pView){


    }
    public void selectSkill_Maintenance_3(View pView){


    }


    public void selectSkill_Attack_1(View pView){


    }
    public void selectSkill_Attack_21(View pView){


    }
    public void selectSkill_Attack_22(View pView){


    }
    public void selectSkill_Attack_3(View pView){


    }

    public void selectSkill_Hacking_1(View pView){


    }
    public void selectSkill_Hacking_21(View pView){


    }
    public void selectSkill_Hacking_22(View pView){


    }
    public void selectSkill_Hacking_3(View pView){


    }

    public void selectSkill_Scout_1(View pView){


    }
    public void selectSkill_Scout_21(View pView){


    }
    public void selectSkill_Scout_22(View pView){


    }
    public void selectSkill_Scout_3(View pView){


    }


}
