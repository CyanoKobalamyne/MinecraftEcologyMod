package ccpm.gui.element;

import DummyCore.Client.GuiElement;
import ccpm.api.IHasProgress;
import ccpm.utils.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ProgressBar extends GuiElement {

	int x;
	int y;
	IHasProgress tile;
	
	ResourceLocation bar = new ResourceLocation("ccpm:textures/gui/pb2.png");
	ResourceLocation bar2 = new ResourceLocation("ccpm:textures/gui/pb1.png");
	
	public ProgressBar(int x, int y, IHasProgress tile) {
		this.x = x;
		this.y = y;
		this.tile = tile;
	}

	@Override
	public ResourceLocation getElementTexture() {
		return bar;
	}

	@Override
	public void draw(int posX, int posY, int mouseX, int mouseY) {
		this.drawTexturedModalRect(posX, posY, 0, 0, 24, 17);
		
		int s = MiscUtils.pixelatedTextureSize(tile.getProgress(), tile.getMaxProgress(), 25);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(bar2);
		
		this.drawTexturedModalRect(posX, posY, 0, 0, s, 17);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
