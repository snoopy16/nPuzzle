//YouWin.java. Activity 3 that congratulates user for winning the game and displays image. Also provide 
//a button to re-start the game


package com.ntare.nPuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class YouWin extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	LinearLayout l = new LinearLayout(this);
    	LinearLayout l2 = new LinearLayout(this);
    	LinearLayout root = new LinearLayout(this);
    	root.setOrientation(LinearLayout.VERTICAL);


    	ImageView im = new ImageView(this);
        TextView t = new TextView(this);
        Button b = new Button(this);
        
        
       	b.setOnClickListener(this);
    	b.setText("Main Menu");
       	b.setId(100);
       
       	//Retreive the image id and total # of moves
       	Bundle bundle = this.getIntent().getExtras(); 
        if(bundle !=null)
        {
        int count = bundle.getInt("param1");
       // int id = bundle.getInt("param2");
        String id=bundle.getString("param2");
       

        t.setText("Congratuations, you won! Moves: "+count);
        im.setImageResource(Integer.parseInt(id));
        im.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
        l.addView(t);
        l.addView(b);
        l2.addView(im);
        root.addView(l);
        root.addView(l2);
        //Display statement, image and button
        setContentView(root);
        
        }

               
        
    }

	@Override
	public void onClick(View v) {
     		

        Intent j = new Intent(this, ImageSelection.class);
        this.startActivity(j);
	}
    
    
}