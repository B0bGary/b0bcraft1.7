package mods.b0bgary.b0bcraft.recipes;

import net.minecraft.block.Block;

public class CropBreedingRecipe {
    private Block base;
    private Block other;
    private Block result;

    public CropBreedingRecipe(Block base,Block other,Block result) {
        this.base = base;
        this.other = other;
        this.result = result;
    }

    public Block getBase() {
        return base;
    }

    public Block getOther() {
        return other;
    }
    
    public Block getResult() {
        return result;
    }
}