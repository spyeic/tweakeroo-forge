package fi.dy.masa.tweakeroo;

import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.malilib.event.InitializationHandler;

@Mod(Reference.MOD_ID)
public class Tweakeroo
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public static int renderCountItems;
    public static int renderCountXPOrbs;

    public Tweakeroo() {
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());

        // Register config GUI
        ModLoadingContext.get().registerExtensionPoint(
                ConfigGuiHandler.ConfigGuiFactory.class,
                () -> new ConfigGuiHandler.ConfigGuiFactory((minecraftClient, screen) -> {
                    GuiConfigs gui = new GuiConfigs();
                    gui.setParent(screen);
                    return gui;
                })
        );
    }
}
