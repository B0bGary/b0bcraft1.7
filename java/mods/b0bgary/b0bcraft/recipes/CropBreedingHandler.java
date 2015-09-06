package mods.b0bgary.b0bcraft.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

public class CropBreedingHandler {
	
	 public static ArrayList<CropBreedingRecipe> recipeCropBreedList = new ArrayList<CropBreedingRecipe>(); 
	 
	 //public static HashMap<Block,CropBreedingRecipe> m =new HashMap<Block, CropBreedingRecipe>();
	 
	    private static List<CropBreedingRecipe> recipes = new ArrayList<CropBreedingRecipe>();
	

	public static void addRecipe(Block base, Block other, Block result) {
		CropBreedingRecipe r=new CropBreedingRecipe(base, other, result);
		//m.put(base, r);
		 //GameRegistry.addRecipe(recipe);
		 
		 recipes.add(r);

    }

	public static Block getPossibleOutcomes(Block base){
		
		for(int i=0;i<recipes.size();i++){
			CropBreedingRecipe l=recipes.get(i);
			 if(base==l.getBase()){
					return l.getResult();
			 }
		}
		return null;
		
		
	}
	
public static Block getSpecificOutcome(Block base, Block other){
		
		for(int i=0;i<recipes.size();i++){
			CropBreedingRecipe l=recipes.get(i);
			 if(base==l.getBase()){
				 if(other==l.getOther()){
					 return l.getResult();
				 }
					
			 }
		}
		return null;
		
		
	}

}
