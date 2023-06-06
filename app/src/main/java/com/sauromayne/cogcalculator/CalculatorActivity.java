package com.sauromayne.cogcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    // setup variables that will be used throughout

    //checks and counts
    private boolean organic, lured, trapUsed;
    private int soundCount, throwCount, squirtCount, dropCount, gagCount;

    // damage
    private int trapDamage, soundDamage, throwDamage, squirtDamage, dropDamage;
    private int rawDamage, groupBonus, luredBonus, totalDamage;

    // enemy
    private int cogStartHealth, cogHealth;
    private String cogLevel;

    // checkboxes
    private CheckBox isOrganic, isLured;

    // progress bar
    private ProgressBar cogHealthBar;

    // text views
    private TextView cogHealthView, defeatedView, defeatedTitleView, bananaDmgView,
            rakeDmgView, marblesDmgView, quicksandDmgView, trapdoorDmgView,
            tntDmgView, railroadDmgView;

    // image views
    private ImageView winLose;

    // image buttons
    ImageButton banana, rake, marbles, quicksand, trapdoor, tnt, railroad;


    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // text views
        TextView cogLevelView = (TextView) findViewById(R.id.levelValue);
        cogHealthView = (TextView) findViewById(R.id.hpValue);
        defeatedView = (TextView) findViewById(R.id.defeatedText);
        defeatedTitleView = (TextView) findViewById(R.id.defeatedTitle);
        // trap text views
        bananaDmgView = (TextView) findViewById(R.id.bananaDmg);
        rakeDmgView = (TextView) findViewById(R.id.rakeDmg);
        marblesDmgView = (TextView) findViewById(R.id.marblesDmg);
        quicksandDmgView = (TextView) findViewById(R.id.quicksandDmg);
        trapdoorDmgView = (TextView) findViewById(R.id.trapdoorDmg);
        tntDmgView = (TextView) findViewById(R.id.tntDmg);
        railroadDmgView = (TextView) findViewById(R.id.railroadDmg);

        // hp bar
        cogHealthBar = (ProgressBar) findViewById(R.id.hpBar);

        // checkboxes
        isOrganic = (CheckBox) findViewById(R.id.is_organic);
        isLured = (CheckBox) findViewById(R.id.is_lured);

        // image views
        ImageView cogImage = (ImageView) findViewById(R.id.cogLevel);
        winLose = (ImageView) findViewById(R.id.defeatedImage);

        // reset button
        ImageButton reset = findViewById(R.id.resetButton);
        ImageButton newCog = findViewById(R.id.newCog);
        // set variables for trap buttons
        banana = findViewById(R.id.trap1);
        rake = findViewById(R.id.trap2);
        marbles = findViewById(R.id.trap3);
        quicksand = findViewById(R.id.trap4);
        trapdoor = findViewById(R.id.trap5);
        tnt = findViewById(R.id.trap6);
        railroad = findViewById(R.id.trap7);

        // set variables for sound buttons
        ImageButton bikehorn = findViewById(R.id.sound1);
        ImageButton whistle = findViewById(R.id.sound2);
        ImageButton bugle = findViewById(R.id.sound3);
        ImageButton aoogah = findViewById(R.id.sound4);
        ImageButton trunk = findViewById(R.id.sound5);
        ImageButton fog = findViewById(R.id.sound6);
        ImageButton opera = findViewById(R.id.sound7);

        // set variables for throw buttons
        ImageButton cupcake = findViewById(R.id.throw1);
        ImageButton fruitSlice = findViewById(R.id.throw2);
        ImageButton creamSlice = findViewById(R.id.throw3);
        ImageButton wholeFruit = findViewById(R.id.throw4);
        ImageButton wholeCream = findViewById(R.id.throw5);
        ImageButton birthday = findViewById(R.id.throw6);
        ImageButton wedding = findViewById(R.id.throw7);

        // set variables for squirt buttons
        ImageButton squirtFlower = findViewById(R.id.squirt1);
        ImageButton glassWater = findViewById(R.id.squirt2);
        ImageButton squirtGun = findViewById(R.id.squirt3);
        ImageButton seltzer = findViewById(R.id.squirt4);
        ImageButton hose = findViewById(R.id.squirt5);
        ImageButton cloud = findViewById(R.id.squirt6);
        ImageButton geyser = findViewById(R.id.squirt7);

        // set variables for drop buttons
        ImageButton flowerPot = findViewById(R.id.drop1);
        ImageButton sandbag = findViewById(R.id.drop2);
        ImageButton anvil = findViewById(R.id.drop3);
        ImageButton weight = findViewById(R.id.drop4);
        ImageButton safe = findViewById(R.id.drop5);
        ImageButton piano = findViewById(R.id.drop6);
        ImageButton toontanic = findViewById(R.id.drop7);

        // set on click listeners
        // reset
        reset.setOnClickListener(this);
        // new cog
        newCog.setOnClickListener(this);
        // trap
        banana.setOnClickListener(this);
        rake.setOnClickListener(this);
        marbles.setOnClickListener(this);
        quicksand.setOnClickListener(this);
        trapdoor.setOnClickListener(this);
        tnt.setOnClickListener(this);
        railroad.setOnClickListener(this);

        // sound
        bikehorn.setOnClickListener(this);
        whistle.setOnClickListener(this);
        bugle.setOnClickListener(this);
        aoogah.setOnClickListener(this);
        trunk.setOnClickListener(this);
        fog.setOnClickListener(this);
        opera.setOnClickListener(this);

        // throw
        cupcake.setOnClickListener(this);
        fruitSlice.setOnClickListener(this);
        creamSlice.setOnClickListener(this);
        wholeFruit.setOnClickListener(this);
        wholeCream.setOnClickListener(this);
        birthday.setOnClickListener(this);
        wedding.setOnClickListener(this);

        // squirt
        squirtFlower.setOnClickListener(this);
        glassWater.setOnClickListener(this);
        squirtGun.setOnClickListener(this);
        seltzer.setOnClickListener(this);
        hose.setOnClickListener(this);
        cloud.setOnClickListener(this);
        geyser.setOnClickListener(this);

        // drop
        flowerPot.setOnClickListener(this);
        sandbag.setOnClickListener(this);
        anvil.setOnClickListener(this);
        weight.setOnClickListener(this);
        safe.setOnClickListener(this);
        piano.setOnClickListener(this);
        toontanic.setOnClickListener(this);

        // set cog picture
        cogImage.setImageDrawable(getResources().getDrawable(R.mipmap.hollywood_crop));

        // retrieve bundle from Selection Activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // assign cogLevel and health values
        cogLevel = extras.getString("COG_LEVEL");
        cogStartHealth = Integer.parseInt(extras.getString("COG_HP"));
        cogHealth = cogStartHealth;

        // setup hp bar and textview
        cogLevelView.setText(cogLevel);
        cogHealthView.setText(String.valueOf(cogHealth) + " / " + String.valueOf(cogHealth));
        cogHealthBar.setMax(cogHealth);
        cogHealthBar.setProgress(cogHealth); // set progress so the bar is filled

        // hide the defeats views
        winLose.setVisibility(View.GONE); // X or Check
        defeatedView.setVisibility(View.GONE); // defeated text
        defeatedTitleView.setVisibility(View.GONE);

    }

    public void Check(View v){
        // set boolean values to the checkbox value
        organic = isOrganic.isChecked();
        lured = isLured.isChecked();

        // text views


        // sound
        TextView bikehornDmgView = (TextView) findViewById(R.id.bikehornDmg);
        TextView whistleDmgView = (TextView) findViewById(R.id.whistleDmg);
        TextView bugleDmgView = (TextView) findViewById(R.id.bugleDmg);
        TextView aoogahDmgView = (TextView) findViewById(R.id.aoogahDmg);
        TextView trunkDmgView = (TextView) findViewById(R.id.trunkDmg);
        TextView fogDmgView = (TextView) findViewById(R.id.fogDmg);
        TextView operaDmgView = (TextView) findViewById(R.id.operaDmg);

        // throw
        TextView cupcakeDmgView = (TextView) findViewById(R.id.cupcakeDmg);
        TextView fruitSliceDmgView = (TextView) findViewById(R.id.fruitSliceDmg);
        TextView creamSliceDmgView = (TextView) findViewById(R.id.creamSliceDmg);
        TextView wholeFruitDmgView = (TextView) findViewById(R.id.wholeFruitDmg);
        TextView wholeCreamDmgView = (TextView) findViewById(R.id.wholeCreamDmg);
        TextView birthdayDmgView = (TextView) findViewById(R.id.bdayCakeDmg);
        TextView weddingDmgView = (TextView) findViewById(R.id.weddingDmg);

        // squirt
        TextView squirtFlowerDmgView = (TextView) findViewById(R.id.squirtFlowerDmg);
        TextView waterGlassDmgView = (TextView) findViewById(R.id.waterGlassDmg);
        TextView squirtGunDmgView = (TextView) findViewById(R.id.squirtGunDmg);
        TextView seltzerDmgView = (TextView) findViewById(R.id.seltzerDmg);
        TextView hoseDmgView = (TextView) findViewById(R.id.hoseDmg);
        TextView cloudDmgView = (TextView) findViewById(R.id.cloudDmg);
        TextView geyserDmgView = (TextView) findViewById(R.id.geyserDmg);

        // drop
        TextView flowerPotDmgView = (TextView) findViewById(R.id.flowerPotDmg);
        TextView sandbagDmgView = (TextView) findViewById(R.id.sandbagDmg);
        TextView anvilDmgView = (TextView) findViewById(R.id.anvilDmg);
        TextView weightDmgView = (TextView) findViewById(R.id.weightDmg);
        TextView safeDmgView = (TextView) findViewById(R.id.safeDmg);
        TextView pianoDmgView = (TextView) findViewById(R.id.pianoDmg);
        TextView toontanicDmgView = (TextView) findViewById(R.id.toontanicDmg);

        // switch gag dmg values for organic gags
        if(isOrganic.isChecked()){
            // trap
            bananaDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.banana) * 1.1)));
            rakeDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.rake) * 1.1)));
            marblesDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.marbles) * 1.1)));
            quicksandDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.quicksand) * 1.1)));
            trapdoorDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.trapdoor) * 1.1)));
            tntDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.tnt) * 1.1)));
            railroadDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.railroad) * 1.1)));

            // sound
            bikehornDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.bikehorn) * 1.1) + 1));
            whistleDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.whistle) * 1.1) + 1));
            bugleDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.bugle) * 1.1)));
            aoogahDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.aoogah) * 1.1)));
            trunkDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.trunk) * 1.1)));
            fogDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.fog) * 1.1)));
            operaDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.opera) * 1.1)));

            // throw
            cupcakeDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.cupcake) * 1.1) + 1));
            fruitSliceDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.fruit_slice) * 1.1)));
            creamSliceDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.cream_slice) * 1.1)));
            wholeFruitDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.whole_fruit) * 1.1)));
            wholeCreamDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.whole_cream) * 1.1)));
            birthdayDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.birthday) * 1.1)));
            weddingDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.wedding) * 1.1)));

            // squirt
            squirtFlowerDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.squirting_flower) * 1.1) + 1));
            waterGlassDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.glass_water) * 1.1) + 1));
            squirtGunDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.squirt_gun) * 1.1)));
            seltzerDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.seltzer) * 1.1)));
            hoseDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.hose) * 1.1)));
            cloudDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.cloud) * 1.1)));
            geyserDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.geyser) * 1.1)));

            // drop
            flowerPotDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.flower_pot) * 1.1)));
            sandbagDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.sandbag) * 1.1)));
            anvilDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.anvil) * 1.1)));
            weightDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.weight) * 1.1)));
            safeDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.safe) * 1.1)));
            pianoDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.piano) * 1.1)));
            toontanicDmgView.setText(
                    String.valueOf((int)(getResources().getInteger(R.integer.toontanic) * 1.1)));
        }
        else{
            // trap
            bananaDmgView.setText(R.string.banana_dmg);
            rakeDmgView.setText(R.string.rake_dmg);
            marblesDmgView.setText(R.string.marbles_dmg);
            quicksandDmgView.setText(R.string.quicksand_dmg);
            trapdoorDmgView.setText(R.string.trapdoor_dmg);
            tntDmgView.setText(R.string.tnt_dmg);
            railroadDmgView.setText(R.string.railroad_dmg);

            // sound
            bikehornDmgView.setText(R.string.bikehorn_dmg);
            whistleDmgView.setText(R.string.whistle_dmg);
            bugleDmgView.setText(R.string.bugle_dmg);
            aoogahDmgView.setText(R.string.aoogah_dmg);
            trunkDmgView.setText(R.string.trunk_dmg);
            fogDmgView.setText(R.string.fog_dmg);
            operaDmgView.setText(R.string.opera_dmg);

            // throw
            cupcakeDmgView.setText(R.string.cupcake_dmg);
            fruitSliceDmgView.setText(R.string.fruit_slice_dmg);
            creamSliceDmgView.setText(R.string.cream_slice_dmg);
            wholeFruitDmgView.setText(R.string.whole_fruit_dmg);
            wholeCreamDmgView.setText(R.string.whole_cream_dmg);
            birthdayDmgView.setText(R.string.bday_dmg);
            weddingDmgView.setText(R.string.wedding_dmg);

            // squirt
            squirtFlowerDmgView.setText(R.string.squirt_flower_dmg);
            waterGlassDmgView.setText(R.string.glass_water_dmg);
            squirtGunDmgView.setText(R.string.squirt_gun_dmg);
            seltzerDmgView.setText(R.string.seltzer_dmg);
            hoseDmgView.setText(R.string.hose_dmg);
            cloudDmgView.setText(R.string.cloud_dmg);
            geyserDmgView.setText(R.string.geyser_dmg);

            // drop
            flowerPotDmgView.setText(R.string.flower_pot_dmg);
            sandbagDmgView.setText(R.string.sandbag_dmg);
            anvilDmgView.setText(R.string.anvil_dmg);
            weightDmgView.setText(R.string.weight_dmg);
            safeDmgView.setText(R.string.safe_dmg);
            pianoDmgView.setText(R.string.piano_dmg);
            toontanicDmgView.setText(R.string.toontanic_dmg);
        }
    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    public void onClick(View view) {
        // text views-------------------------------------------------------------------------------
        TextView rawDamageView = (TextView) findViewById(R.id.rawValue);
        TextView groupBonusView = (TextView) findViewById(R.id.groupValue);
        TextView luredBonusView = (TextView) findViewById(R.id.lureValue);
        TextView totalDamageView = (TextView) findViewById(R.id.totalValue);

        // image views------------------------------------------------------------------------------
        ImageView gagChoice1 = (ImageView) findViewById(R.id.gagChoice1);
        ImageView gagChoice2 = (ImageView) findViewById(R.id.gagChoice2);
        ImageView gagChoice3 = (ImageView) findViewById(R.id.gagChoice3);
        ImageView gagChoice4 = (ImageView) findViewById(R.id.gagChoice4);

        // gag images-------------------------------------------------------------------------------
        //trap
        int bananaMip = R.mipmap.trap_banana;
        int rakeMip = R.mipmap.trap_rake;
        int marblesMip = R.mipmap.trap_marbles;
        int quicksandMip = R.mipmap.trap_quicksand;
        int trapdoorMip = R.mipmap.trap_trapdoor;
        int tntMip = R.mipmap.trap_tnt;
        int railroadMip = R.mipmap.trap_railroad;
        // sound
        int bikehornMip = R.mipmap.sound_bikehorn;
        int whistleMip = R.mipmap.sound_whistle;
        int bugleMip = R.mipmap.sound_bugle;
        int aoogahMip = R.mipmap.sound_aoogah;
        int trunkMip = R.mipmap.sound_trunk;
        int fogMip = R.mipmap.sound_fog;
        int operaMip = R.mipmap.sound_opera;
        // throw
        int cupcakeMip = R.mipmap.throw_cupcake;
        int fruitSliceMip = R.mipmap.throw_fruitslice;
        int creamSliceMip = R.mipmap.throw_creamslice;
        int wholeFruitMip = R.mipmap.throw_wholefruit;
        int wholeCreamMip = R.mipmap.throw_wholecream;
        int birthdayMip = R.mipmap.throw_bdaycake;
        int weddingMip = R.mipmap.throw_weddingcake;
        // squirt
        int squirtFlowerMip = R.mipmap.squirt_flower;
        int glassWaterMip = R.mipmap.squirt_water;
        int squirtGunMip = R.mipmap.squirt_gun;
        int seltzerMip = R.mipmap.squirt_seltzer;
        int hoseMip = R.mipmap.squirt_hose;
        int cloudMip = R.mipmap.squirt_cloud;
        int geyserMip = R.mipmap.squirt_geyser;
        // drop
        int flowerPotMip = R.mipmap.drop_flowerpot;
        int sandbagMip = R.mipmap.drop_sandbag;
        int anvilMip = R.mipmap.drop_anvil;
        int weightMip = R.mipmap.drop_weight;
        int safeMip = R.mipmap.drop_safe;
        int pianoMip = R.mipmap.drop_piano;
        int toontanicMip = R.mipmap.drop_toontanic;

        // gag damage identifiers-------------------------------------------------------------------
        int bananaVal = R.integer.banana;
        int rakeVal = R.integer.rake;
        int marblesVal = R.integer.marbles;
        int quicksandVal = R.integer.quicksand;
        int trapdoorVal = R.integer.trapdoor;
        int tntVal = R.integer.tnt;
        int railroadVal = R.integer.railroad;
        // sound
        int bikehornVal = R.integer.bikehorn;
        int whistleVal = R.integer.whistle;
        int bugleVal = R.integer.bugle;
        int aoogahVal = R.integer.aoogah;
        int trunkVal = R.integer.trunk;
        int fogVal = R.integer.fog;
        int operaVal = R.integer.opera;
        // throw
        int cupcakeVal = R.integer.cupcake;
        int fruitSliceVal = R.integer.fruit_slice;
        int creamSliceVal = R.integer.cream_slice;
        int wholeFruitVal = R.integer.whole_fruit;
        int wholeCreamVal = R.integer.whole_cream;
        int birthdayVal = R.integer.birthday;
        int weddingVal = R.integer.wedding;
        // squirt
        int squirtFlowerVal = R.integer.squirting_flower;
        int glassWaterVal = R.integer.glass_water;
        int squirtGunVal = R.integer.squirt_gun;
        int seltzerVal = R.integer.seltzer;
        int hoseVal = R.integer.hose;
        int cloudVal = R.integer.cloud;
        int geyserVal = R.integer.geyser;
        // drop
        int flowerPotVal = R.integer.flower_pot;
        int sandbagVal = R.integer.sandbag;
        int anvilVal = R.integer.anvil;
        int weightVal = R.integer.weight;
        int safeVal = R.integer.safe;
        int pianoVal = R.integer.piano;
        int toontanicVal = R.integer.toontanic;

//------------------------------GAG BUTTONS---------------------------------------------------------
        switch (view.getId()){
            //----------------------------------------TRAP------------------------------------------
            // switch to cog selection activity
            case R.id.newCog:
                Intent cogSelection = new Intent(this, SelectionActivity.class);
                startActivity(cogSelection);
                break;
            // reset calculator activity if reset button pressed
            case R.id.resetButton:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            case R.id.trap1:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(bananaVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(bananaVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, bananaVal);
                // place gag used in the gag track
                updateGagTrack(bananaMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap2:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(rakeVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(rakeVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, rakeVal);
                //place gag used in the gag track
                updateGagTrack(rakeMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap3:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(marblesVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(marblesVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, marblesVal);
                //place gag used in the gag track
                updateGagTrack(marblesMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap4:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(quicksandVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(quicksandVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, quicksandVal);
                //place gag used in the gag track
                updateGagTrack(quicksandMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap5:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(trapdoorVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(trapdoorVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, trapdoorVal);
                //place gag used in the gag track
                updateGagTrack(trapdoorMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap6:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(tntVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(tntVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, tntVal);
                //place gag used in the gag track
                updateGagTrack(tntMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            case R.id.trap7:
                // add organic or regular damage to the gag total
                if(organic)
                    trapDamage += (int)(getResources().getInteger(railroadVal) * 1.1);
                else
                    trapDamage += getResources().getInteger(railroadVal);
                // update text views and calculate
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, railroadVal);
                //place gag used in the gag track
                updateGagTrack(railroadMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                // disable trap
                disableTrap();
                break;
            //----------------------------------------SOUND-----------------------------------------
            case R.id.sound1:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(bikehornVal) * 1.1) + 1;
                else
                    soundDamage += getResources().getInteger(bikehornVal);
                //update soundCount and execute turnUpdate
                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, bikehornVal);
                //place gag used in the gag track
                updateGagTrack(bikehornMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound2:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(whistleVal) * 1.1) + 1;
                else
                    soundDamage += getResources().getInteger(whistleVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, whistleVal);
                //place gag used in the gag track
                updateGagTrack(whistleMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound3:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(bugleVal) * 1.1);
                else
                    soundDamage += getResources().getInteger(bugleVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, bugleVal);
                //place gag used in the gag track
                updateGagTrack(bugleMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound4:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(aoogahVal) * 1.1);
                else
                    soundDamage += getResources().getInteger(aoogahVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, aoogahVal);
                //place gag used in the gag track
                updateGagTrack(aoogahMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound5:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(trunkVal) * 1.1);
                else
                    soundDamage += getResources().getInteger(trunkVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, trunkVal);
                //place gag used in the gag track
                updateGagTrack(trunkMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound6:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(fogVal) * 1.1);
                else
                    soundDamage += getResources().getInteger(fogVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, fogVal);
                //place gag used in the gag track
                updateGagTrack(fogMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.sound7:
                // add organic or regular damage to the gag total
                if(organic)
                    soundDamage += (int)(getResources().getInteger(operaVal) * 1.1);
                else
                    soundDamage += getResources().getInteger(operaVal);

                soundCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, operaVal);
                //place gag used in the gag track
                updateGagTrack(operaMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            //----------------------------------------THROW-----------------------------------------
            case R.id.throw1:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(cupcakeVal) * 1.1) + 1;
                else
                    throwDamage += getResources().getInteger(cupcakeVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, cupcakeVal);
                //place gag used in the gag track
                updateGagTrack(cupcakeMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw2:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(fruitSliceVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(fruitSliceVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, fruitSliceVal);
                //place gag used in the gag track
                updateGagTrack(fruitSliceMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw3:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(creamSliceVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(creamSliceVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, creamSliceVal);
                //place gag used in the gag track
                updateGagTrack(creamSliceMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw4:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(wholeFruitVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(wholeFruitVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, wholeFruitVal);
                //place gag used in the gag track
                updateGagTrack(wholeFruitMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw5:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(wholeCreamVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(wholeCreamVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, wholeCreamVal);
                //place gag used in the gag track
                updateGagTrack(wholeCreamMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw6:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(birthdayVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(birthdayVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, birthdayVal);
                //place gag used in the gag track
                updateGagTrack(birthdayMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.throw7:
                // add organic or regular damage to the gag total
                if(organic)
                    throwDamage += (int)(getResources().getInteger(weddingVal) * 1.1);
                else
                    throwDamage += getResources().getInteger(weddingVal);
                // increase gag count
                throwCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, weddingVal);
                //place gag used in the gag track
                updateGagTrack(bikehornMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            //---------------------------------------SQUIRT-----------------------------------------
            case R.id.squirt1:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(squirtFlowerVal) * 1.1) + 1;
                else
                    squirtDamage += getResources().getInteger(squirtFlowerVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, squirtFlowerVal);
                //place gag used in the gag track
                updateGagTrack(squirtFlowerMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt2:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(glassWaterVal) * 1.1) + 1;
                else
                    squirtDamage += getResources().getInteger(glassWaterVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, glassWaterVal);
                //place gag used in the gag track
                updateGagTrack(glassWaterMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt3:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(squirtGunVal) * 1.1);
                else
                    squirtDamage += getResources().getInteger(squirtGunVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, squirtGunVal);
                //place gag used in the gag track
                updateGagTrack(squirtGunMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt4:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(seltzerVal) * 1.1);
                else
                    squirtDamage += getResources().getInteger(seltzerVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, seltzerVal);
                //place gag used in the gag track
                updateGagTrack(seltzerMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt5:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(hoseVal) * 1.1);
                else
                    squirtDamage += getResources().getInteger(hoseVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, hoseVal);
                //place gag used in the gag track
                updateGagTrack(hoseMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt6:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(cloudVal) * 1.1);
                else
                    squirtDamage += getResources().getInteger(cloudVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, cloudVal);
                //place gag used in the gag track
                updateGagTrack(cloudMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.squirt7:
                // add organic or regular damage to the gag total
                if(organic)
                    squirtDamage += (int)(getResources().getInteger(geyserVal) * 1.1);
                else
                    squirtDamage += getResources().getInteger(geyserVal);
                // increase gag count
                squirtCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, geyserVal);
                //place gag used in the gag track
                updateGagTrack(geyserMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            //----------------------------------------DROP------------------------------------------
            case R.id.drop1:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(flowerPotVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(flowerPotVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, flowerPotVal);
                //place gag used in the gag track
                updateGagTrack(flowerPotMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop2:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(sandbagVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(sandbagVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, sandbagVal);
                //place gag used in the gag track
                updateGagTrack(sandbagMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop3:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(anvilVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(anvilVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, anvilVal);
                //place gag used in the gag track
                updateGagTrack(anvilMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop4:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(weightVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(weightVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, weightVal);
                //place gag used in the gag track
                updateGagTrack(weightMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop5:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(safeVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(safeVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, safeVal);
                //place gag used in the gag track
                updateGagTrack(safeMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop6:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(pianoVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(pianoVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, pianoVal);
                //place gag used in the gag track
                updateGagTrack(pianoMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
            case R.id.drop7:
                // add organic or regular damage to the gag total
                if(organic)
                    dropDamage += (int)(getResources().getInteger(toontanicVal) * 1.1);
                else
                    dropDamage += getResources().getInteger(toontanicVal);
                // increase gag count
                dropCount += 1;
                turnUpdate(rawDamageView, groupBonusView,
                        luredBonusView, totalDamageView, toontanicVal);
                //place gag used in the gag track
                updateGagTrack(toontanicMip,gagChoice1, gagChoice2, gagChoice3, gagChoice4);
                break;
        }

    }
//-------------------------------------------GAG BUTTON END-----------------------------------------

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    public void Calculate(int damageSource) {
        // calculation is only performed if 4 gags or less have been used
        if(gagCount <= 4){
            // define local group bonus and turn total variables
            int turnBonus = 0;
            int turnTotal = 0;

            if(organic)
                turnTotal = (int)(getResources().getInteger(damageSource) * 1.1);
            else
                turnTotal = getResources().getInteger(damageSource);

            // add all the gag damage values to get the current raw damage
            rawDamage = (trapDamage + soundDamage + throwDamage + squirtDamage + dropDamage);

            // divide the gag damage by 2 to calculate lure bonus
            if(lured){
                if(soundCount > 0)
                    luredBonus = 0; // no lure bonus from sound
                else if(throwCount > 0) {
                    luredBonus = throwDamage / 2; // if throw is used, then it is used to calculate the group bonus
                }
                else if(squirtCount > 0) {
                    luredBonus = squirtDamage / 2;
                }
                else
                    luredBonus = 0;     // only gag left is drop, can't use drop on lured cogs
            }

            // divide the gag damage by 5 if more than 1 of same type is used
            // integer division is used, which takes the floor as Toontown damage is calculate
            if(soundCount > 1) {
                turnBonus += soundDamage / 5;
                groupBonus = turnBonus;
            }
            if(throwCount > 1) {
                turnBonus += throwDamage / 5;
                groupBonus = turnBonus;
            }
            if(squirtCount > 1) {
                turnBonus += squirtDamage / 5;
                groupBonus = turnBonus;
            }
            if(dropCount > 1) {
                turnBonus += dropDamage / 5;
                groupBonus = turnBonus;
            }

            // calculate the total damage by adding all the values
            totalDamage = rawDamage + luredBonus + groupBonus;

            if(gagCount == 4) {
                turnTotal += luredBonus + groupBonus; // add the bonus damage to last turn
            }

            // update cog hp values
            cogHealth -= turnTotal; // lower cog's health
            cogHealthView.setText(cogHealth + " / " + cogStartHealth);
            cogHealthBar.setProgress(cogHealth);
            if(cogHealth < 0)
                cogHealthView.setText("0 / " + cogStartHealth);

            // Check for victory
            if(gagCount == 4){
                if(cogHealth > 0) {
                    defeatedView.setText("Oops! You need " + (cogStartHealth - totalDamage) +
                            " more damage!");
                }
                else if(cogHealth < 0) {
                    defeatedView.setText("Good job! Overkill by " + (-1 * cogStartHealth + totalDamage)
                            + " damage!");
                    winLose.setImageDrawable(getResources().getDrawable(R.mipmap.throw_bdaycake));
                }
                else{
                    defeatedView.setText("WOW! You did exactly enough damage!");
                }

                // show the defeated views
                winLose.setVisibility(View.VISIBLE); // X or Check
                defeatedView.setVisibility(View.VISIBLE); // defeated text
                defeatedTitleView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void turnUpdate(TextView rawDamageView, TextView groupBonusView,
                            TextView luredBonusView, TextView totalDamageView,
                           int damageSource){
        // increase gag count
        gagCount += 1;
        // calculate damage
        Calculate(damageSource);
        //update text views
        rawDamageView.setText(String.valueOf(rawDamage));
        groupBonusView.setText(String.valueOf(groupBonus));
        luredBonusView.setText(String.valueOf(luredBonus));
        totalDamageView.setText(String.valueOf(totalDamage));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void updateGagTrack(int mipMapId, ImageView gagChoice1, ImageView gagChoice2,
                               ImageView gagChoice3, ImageView gagChoice4){
        //place gag used in the gag track
        if(gagCount == 1)
            gagChoice1.setImageDrawable(getResources().getDrawable(mipMapId));
        else if(gagCount == 2)
            gagChoice2.setImageDrawable(getResources().getDrawable(mipMapId));
        else if(gagCount == 3)
            gagChoice3.setImageDrawable(getResources().getDrawable(mipMapId));
        else if(gagCount == 4)
            gagChoice4.setImageDrawable(getResources().getDrawable(mipMapId));
    }

    public void disableTrap(){
        banana.setVisibility(View.GONE);
        bananaDmgView.setVisibility(View.GONE);
        rake.setVisibility(View.GONE);
        rakeDmgView.setVisibility(View.GONE);
        marbles.setVisibility(View.GONE);
        marblesDmgView.setVisibility(View.GONE);
        quicksand.setVisibility(View.GONE);
        quicksandDmgView.setVisibility(View.GONE);
        trapdoor.setVisibility(View.GONE);
        trapdoorDmgView.setVisibility(View.GONE);
        tnt.setVisibility(View.GONE);
        tntDmgView.setVisibility(View.GONE);
        railroad.setVisibility(View.GONE);
        railroadDmgView.setVisibility(View.GONE);
    }

}