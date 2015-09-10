package mods.b0bgary.b0bcraft.core

public class EventHandlers {
	
	public static void add(){
		MinecraftForge.EVENT_BUS.register(new EventHandlerVanilLaCrop());

	}
}