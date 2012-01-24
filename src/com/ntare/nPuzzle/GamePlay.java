//GamePlay.java. Activity 2 that allows users to play the game using selected image in Activity 1. If the user
//Succeeds i.e arranges the tiles in the right order he wins.
//Only works for n=8



package com.ntare.nPuzzle;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.Toast;
import android.util.FloatMath;
//import android.content.Intent;



public class GamePlay extends Activity implements View.OnClickListener {
	 
	int[] model={8,7,6,5,4,3,2,1,0}; //Shuffled State. Initialized.
	int id;
	//int[] model = {1,2,3,4,5,6,7,8,0}; //Ideal Solution
	
	int count=1; //count keeps a track of number of moves
	final int n=8; //program works only for n=8. The gamelogic is not general enough to work for n=15 and n=24. 
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
       
        CreatemyView(model);
        
       
    }
    
    @Override
	public void onClick(View v) {
    	int pos=0;
    	
    	//Get the position of the clicked button in the grid layout
    	for (int i=0;i<model.length;i++)
    	{
    		if(model[i]==v.getId())
    			pos=i;
    	}
    	

        	
    	//define neighbors
    	int top=pos-sq(n+1); int bottom=pos+sq(n+1); int right=pos+1; int left=pos-1;
    	

    	
    	if(v.getId()==0){
    		Toast toast1 = Toast.makeText(GamePlay.this, "You click the blank space, not allowed", Toast.LENGTH_LONG);
    		toast1.show();
    	}
    	
    	
    	//Check for cases on the left, right, top and bottom edges/corners
    	
   	   	CheckLeftColumn(model, pos, right, left, top, bottom);
       
    	CheckRightColumn(model, pos, right, left, top, bottom);
    
    	CheckBottomEdge(model, pos, right, left, top, bottom);
    	
    	CheckTopEdge(model, pos, right, left, top, bottom);

    	CheckCenter(model, pos, right, left, top, bottom);
    	
    }//end of onClick()
    	
    	
    	
    void CheckLeftColumn(int[] model, int pos, int right, int left, int top, int bottom){
    	 
     		if(pos==0 || pos==sq(n+1) || pos==2*sq(n+1) || pos==3*sq(n+1) || pos==4*sq(n+1)){
     			
     			//check for bottom left
     			if(pos==n-sq(n+1)+1){
     				
     				if(model[right]==0) {
     					
     					SwapButtons(model, right, pos);
     					
     				}
     				
     				else if(model[top]==0){
     					
     					SwapButtons(model, top, pos);
     				}
     				
     				else {
     					
     					InvalidMove();
     				}
     				
     			}//end of bottom left
     			
     			
     			//check for top left
     			else if(pos==0){
     				
     				if(model[right]==0){
     				
     					SwapButtons(model, right, pos);
     			    }
     				
     				else if(model[bottom]==0){
     					
     					SwapButtons(model, bottom, pos);
     				}
     					
     				     				
                    else {
     					
     					InvalidMove();
     				}
     			
     			}//end of top left
     			
     			
     			//check for edge condition
     			else {
     				if (model[right]==0){
     					
     					SwapButtons(model, right, pos);
     				}
     				
     				else if(model[top]==0){
     					SwapButtons(model, top, pos);
     				}
     				
     				else if(model[bottom]==0){
     					SwapButtons(model, bottom, pos);
     					
     				}
     				
                    else {
     					
     					InvalidMove();
     				}
     			}//end of edge condition
     			
     			}//end of outer if statement for leftmost row
     			
     		//With the updated model array, first remove the old view and then re-create the view
     		RemovemyView();
     		CreatemyView(model);
     	
    }
    
    
	void CheckRightColumn(int[] model, int pos, int right, int left, int top, int bottom){
		
    	if(pos==sq(n+1)-1 || pos==2*sq(n+1)-1 || pos==3*sq(n+1) -1 || pos==4*sq(n+1)-1 || pos==5*sq(n+1)-1 ){
    		
    		//check for the bottom right position
    		if(pos==n){
    			
    			if(model[top]==0){
    				SwapButtons(model, top, pos);
    			}
    			
    			else if(model[left]==0){
    				SwapButtons(model, left, pos);
    			}
    			
    			else {
 					
 					InvalidMove();
 				}
    			
    		}//end of bottom right check
    		
    		//check for top right position
    		else if(pos==sq(n+1)-1){
    			if(model[left]==0){
    				SwapButtons(model, left, pos);
    			}
    			
    			else if(model[bottom]==0){
    				SwapButtons(model, bottom, pos);
    			}
    			
    			else {
 					
 					InvalidMove();
 				}
    			
    		}//end of top right check
    		
    		
    		//check the right edge position
    		
    		else {
    			
    			if(model[left]==0){
    				SwapButtons(model, left, pos);
    			}
    			
    			else if(model[top]==0){
    				SwapButtons(model, top, pos);
    			}
    			
    			else if(model[bottom]==0){
    				SwapButtons(model, bottom, pos);
    			}
    			else {
 					
 					InvalidMove();
 				}
    		}//end of check for right edge position
    		
    		
    	}
    		
    		RemovemyView();
    		CreatemyView(model);
    		
    	}

		
	void CheckBottomEdge(int[] model, int pos, int right, int left, int top, int bottom){
		
		if(pos<n && pos>n-sq(n+1)+1){
			
			if(model[left]==0){
				SwapButtons(model, left, pos);
			}
			
			else if(model[top]==0){
				SwapButtons(model, top, pos);
			}
			
			else if(model[right]==0){
				SwapButtons(model, right, pos);
			}
			
			else {
					
					InvalidMove();
				}
		}
		
    		RemovemyView();
    		CreatemyView(model);
    		
    	}
		
	    
	void CheckTopEdge(int[] model, int pos,int right, int left, int top, int bottom){
		
		
		if(pos>0 && pos < sq(n+1)-1){
			
			if(model[left]==0){
				SwapButtons(model, left, pos);
			}
			
			else if(model[bottom]==0){
				SwapButtons(model, bottom, pos);
			}
			
			else if(model[right]==0){
				SwapButtons(model, right, pos);
			}
			
			else {
					
					InvalidMove();
				}
		}

   		RemovemyView();
   		CreatemyView(model);
   	}
   	 
   	 		
	void CheckCenter(int[] model, int pos, int right, int left, int top, int bottom){
		//hardcoded value here as the logic failed for this condition
		if(pos==4){
	
		if (model[left]==0){
			SwapButtons(model, left, pos);
		}
		
		else if(model[right]==0){
			SwapButtons(model, right, pos);
		}
		
		else if(model[top]==0){
			SwapButtons(model,top, pos);
		}
		
		else if(model[bottom]==0){
			SwapButtons(model, bottom, pos);
		}
		else {
				
				InvalidMove();
			}
		
		}
		RemovemyView();
		CreatemyView(model);
	}

	
	void WinGame(int[] model,int count){
		//harcoded for n=8 since other cases did not work with the gamelogic. 
		//Set out the winning criteria
			if(model[0]==1 && model[1]==2 && model[2]==3 && model[3]==4 && model[4]==5 && model[5]==6 && model[6]==7 && model[7]==8 && model[8]==0){
				
                Intent j = new Intent(this, YouWin.class);

                
                //If winning is determined, then congratulate user by directing her to Activity 3(YoWin). Let user know the total
                //number of moves he made and the original image.
			    Bundle bundle = new Bundle();
			    Bundle bundle1 = this.getIntent().getExtras(); 
		        if(bundle1 !=null)
		        {
		        String value = bundle1.getString("param2");
		        
		      
			  
			    bundle.putInt("param1", count);
			   // bundle.putInt("param2", value);
			    bundle.putString("param2", value);
			    
    			j.putExtras(bundle);

                this.startActivity(j);
		        }
    	
			}

	}
	
	
	//define square-root function
    int sq(int x){
    	return (int)FloatMath.sqrt(x);
    }
    
    //define whenever there is an invalid move
    void InvalidMove(){
    	Toast toast = Toast.makeText(GamePlay.this, "Invalid Click. Should click next to blank tile ", Toast.LENGTH_LONG);
	    toast.show();
    }
    
    void RemovemyView(){
		// get the parent layout and remove the clicked imagebutton
    	LinearLayout root = (LinearLayout)this.findViewById(R.id.root_layout);
    	 root.removeAllViews();
	}
    
    //once the button next to blank tile is clicked, swap their positions
    void SwapButtons(int model[], int neighbor, int pos){
    	    count=count+1;
        	int temp=model[pos];
			model[pos]=model[neighbor];
			model[neighbor]=temp;
    	
    }
    
    void CreatemyView(int model[]){
    	    	
    	 LinearLayout root = (LinearLayout)this.findViewById(R.id.root_layout);
    	 
    	// WinGame(model, count);
    	 Bundle bundle1 = this.getIntent().getExtras(); 
	        if(bundle1 !=null)
	        {
	        String value = bundle1.getString("param2");
	        Toast toast1 = Toast.makeText(GamePlay.this, value, Toast.LENGTH_LONG);
    		toast1.show();
        	//Bitmap background = BitmapFactory.decodeResource(this.getResources(), Integer.parseInt(value)); 

    	
    	for (int k=1;k<=sq(n+1);k++) {
    		
    		LinearLayout row = new LinearLayout(this);
    		row.setId(k);
          
            for (int i = sq(n+1)*(k-1); i < sq(n+1)*k; i++) {
            	
            	//Unfortunately, the image id passed from Activity 1 did not get captured here and everytime I ran it, I got
            	//forced close. Not sure why this did not work. Hardcoded the image as puzzle_0
            	
            	Bitmap background = BitmapFactory.decodeResource(this.getResources(), Integer.valueOf(value)); 
            	//Bitmap background = BitmapFactory.decodeResource(this.getResources(), R.drawable.puzzle_0);

            	int screenWidth = this.getResources().getDisplayMetrics().widthPixels; //320
            	int screenHeight = this.getResources().getDisplayMetrics().heightPixels; //480
            	
            	int width = background.getWidth();
                int height = background.getHeight();
               
                //Scale the image to fit the screen
                int scaleWidth =  screenWidth *  width/height;
                int scaleHeight =  screenHeight * width/ height;
                
                //define the tile width and tileheight. use the case of n=8
                int tileWidth = scaleWidth / 3;
                int tileHeight = scaleHeight / 3;
                
                
                         
                // create a matrix for the manipulation
                Matrix matrix = new Matrix();
                // resize the bit map
                matrix.postScale(scaleWidth, scaleHeight);
                

                // recreate the new Bitmap. This did not work either!
              //  Bitmap resizedBitmap = Bitmap.createBitmap(background, 0, 0, width, height, matrix, true); 
                Bitmap.createScaledBitmap(src, dstWidth, dstHeight, filter)
            
               	Button button = new Button(this);
                
                int m=(3-k);
                
                Bitmap cropped = Bitmap.createBitmap(background, 0, m*100, tileWidth, tileHeight);
               
                // make a Drawable from Bitmap to allow to set the BitMap 
                // to the ImageView, ImageButton or what ever
                BitmapDrawable bmd = new BitmapDrawable(cropped);
             
                // set the Drawable on the ImageView
                button.setBackgroundDrawable(bmd);
               
               	background.recycle();
             
             	button.setOnClickListener(this);
             	button.setId(model[i]);
           	
            	if(model[i]==0){
           		button.setVisibility(View.INVISIBLE);
            	}
           		
           	
            	row.addView(button);
          
           	
            }//end of inner for
          
        
      
         root.addView(row);
        
    	
	        }//outer for loop 
	        }
    	
    }//End of CreatmyView function
    
    
    
   
    
}//End of Class