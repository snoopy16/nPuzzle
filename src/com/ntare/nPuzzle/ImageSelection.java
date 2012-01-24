
//ImageSelection.java. Activity 1 that allows users to select a particular image for game.

package com.ntare.nPuzzle;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ImageSelection extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button Puzzle0 = (Button)this.findViewById(R.id.B1);
        Puzzle0.setOnClickListener(this);
        
        Button Puzzle1 = (Button)this.findViewById(R.id.B2);
        Puzzle1.setOnClickListener(this);
        
        Button Puzzle2 = (Button)this.findViewById(R.id.B3);
        Puzzle2.setOnClickListener(this);
        
        
    }

    @Override
	public void onClick(View v) {
    	
    	if(v.getId()==R.id.B1){
    		
    		int id = R.drawable.puzzle_0;
       		StarmyActivity(id);
    	}
    	
    	else if(v.getId()==R.id.B2){
    		
    		int id = R.drawable.puzzle_1;
    		StarmyActivity(id);
    	}
    	
    	else if(v.getId()==R.id.B3){
    		
    		int id = R.drawable.puzzle_2;
    		StarmyActivity(id);
    	}
    }
    
    //Start Activity2=GamePlay passing the image id as parameter
    
    void StarmyActivity(int id){
    	Bundle bundle = new Bundle();
		  
	    //bundle.putInt("param2", id);
    	bundle.putString("param2", String.valueOf(id));
	    
        Intent j = new Intent(this, GamePlay.class);
		j.putExtras(bundle);

        this.startActivity(j);	
    }
    
}